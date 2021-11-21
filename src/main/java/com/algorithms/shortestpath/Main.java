package com.algorithms.shortestpath;

import java.util.ArrayDeque;
import java.util.Queue;

class Main {

    // Below arrays detail all four possible movements from a cell
    private static final int[] row = { -1, 0, 0, 1 };
    private static final int[] col = { 0, -1, 1, 0 };

    // Function to check if it is possible to go to position (row, col)
    // from the current position. The function returns false if (row, col)
    // is not a valid position or has a value 0 or already visited.
    private static boolean isValid(int[][] mat, boolean[][] visited, int row, int col) {
        return (row >= 0) && (row < mat.length) && (col >= 0) && (col < mat[0].length)
                && mat[row][col] == 1 && !visited[row][col];
    }

    // Find the shortest possible route in a matrix `mat` from source
    // cell (i, j) to destination cell (x, y)
    private static int findShortestPathLength(int[][] matrix, int i, int j, int x, int y) {
        // base case: invalid input
        if (matrix == null || matrix.length == 0 || matrix[i][j] == 0 || matrix[x][y] == 0) {
            return -1;
        }

        // `M × N` matrix
        int M = matrix.length;
        int N = matrix[0].length;

        // construct a matrix to keep track of visited cells
        boolean[][] visited = new boolean[M][N];

        // create an empty queue
        Queue<Node> queue = new ArrayDeque<>();

        // mark the source cell as visited and enqueue the source node
        visited[i][j] = true;
        queue.add(new Node(i, j, 0));

        // stores length of the longest path from source to destination
        int minDist = Integer.MAX_VALUE;

        // loop till queue is empty
        while (!queue.isEmpty()) {
            // dequeue front node and process it
            Node node = queue.poll();

            // (i, j) represents a current cell, and `dist` stores its
            // minimum distance from the source
            i = node.x;
            j = node.y;
            int dist = node.dist;

            // if the destination is found, update `min_dist` and stop
            if (i == x && j == y) {
                minDist = dist;
                break;
            }

            // check for all four possible movements from the current cell
            // and enqueue each valid movement
            for (int k = 0; k < 4; k++) {
                // check if it is possible to go to position
                // (i + row[k], j + col[k]) from current position
                if (isValid(matrix, visited, i + row[k], j + col[k])) {
                    // mark next cell as visited and enqueue it
                    visited[i + row[k]][j + col[k]] = true;
                    queue.add(new Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (minDist != Integer.MAX_VALUE) {
            return minDist;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix =
                {
                        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                        { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                        { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
                        { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
                        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                        { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                        { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
                };

        int minDist = findShortestPathLength(matrix, 0, 0, 7, 5);

        if (minDist != -1) {
            System.out.println("The shortest path from source to destination " +
                    "has length " + minDist);
        } else {
            System.out.println("Destination cannot be reached from source");
        }
    }
}
