package ScoreStatesPackage;


/**
 * Created by Kaurakit on 5/1/2017.
 */
public class SpareState implements Scoring{

    public void getScore(int[] curScore, int[][] cumulScores, int throwIndex, int bowlIndex){
        int balls_per_frame = 2;
        int frameNum = throwIndex/balls_per_frame;
        cumulScores[bowlIndex][(frameNum)] += curScore[throwIndex+1] + curScore[throwIndex];
    }

}
