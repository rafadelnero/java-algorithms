package algoexpert.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/** Teams compete against each other - two teams compete against each other
 Each team is the home team and the other the away team
 There is always a winner on each competition or one loser, no ties.
 A team receives 3 points if it wins and 0 if it loses
 The winner of the tournament receives the most amount of points

 Write a function that returns the winner of the tournament
 The competitions array has the homeTeam and awayTeam
 The results array contains information about the winner
 1 means that the home team won, 0 the away team won

 One team will always win, every tournament will have at least two teams

 Plan for this algorithm
 Traverse the competitions array
 Create a for looping with the results
 Store the string for the beaten team, verify if it's the last register, include , "and ."
 Store the results in a hashmap */
public class TournamentWinner {

    int HOME_TEAM = 0;
    int AWAY_TEAM = 1;
    // O(n) time | O(k) space
    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> winnerResults = new HashMap<>();
        for (int i = 0; i < competitions.size(); i++) {
           var competition = competitions.get(i);
           String winningTeam = results.get(i) == 1 ? competition.get(HOME_TEAM) : competition.get(AWAY_TEAM);
           winnerResults.put(winningTeam, winnerResults.getOrDefault(winningTeam, 0) + 3);
        }

        return Collections.max(winnerResults.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    @Test
    public void testCase1() {
        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        ArrayList<String> competition1 = new ArrayList<>(Arrays.asList("HTML", "C#"));
        ArrayList<String> competition2 = new ArrayList<>(Arrays.asList("C#", "Python"));
        ArrayList<String> competition3 = new ArrayList<>(Arrays.asList("Python", "HTML"));
        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);
        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 1));
        String expected = "Python";
        var actual = new TournamentWinner().tournamentWinner(competitions, results);
        Assertions.assertSame(expected, actual);
    }
}

