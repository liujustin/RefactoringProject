package ScoreStatesPackage;

import BowlerPackage.Bowler;

/**
 * Created by SerBubblez on 5/1/2017.
 */
public interface Scoring {

    public void getScore(int[] curScore, int[][] cumulScores, int throwIndex, int bowlIndex);

}
