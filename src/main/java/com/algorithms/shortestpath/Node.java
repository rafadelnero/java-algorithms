package com.algorithms.shortestpath;

// A Queue Node
class Node {
    // (x, y) represents matrix cell coordinates, and
    // `dist` represents their minimum distance from the source
    int x, y, dist;
 
    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}