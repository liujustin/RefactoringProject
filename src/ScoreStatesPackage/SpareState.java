package ScoreStatesPackage;


/**
 * Created by Kaurakit on 5/1/2017.
 */
public class SpareState implements Scoring{

    public void getScore(int[] curScore, int[][] cumulScores, int throwIndex, int bowlIndex){
        int frameNum = throwIndex/BALLS_PER_FRAME;
        cumulScores[bowlIndex][(frameNum)] += curScore[throwIndex+1] + curScore[throwIndex];
    }

}
