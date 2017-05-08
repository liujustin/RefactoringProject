package ScoreStatesPackage;


/**
 * Created by Kaurakit on 5/1/2017.
 */
public class SpareState implements ScoringState {

    public void getScore(int[] curScore, int[][] cumulScores, int throwIndex, int bowlIndex){
        // REF add the next score to calculate spare score
        int frameNum = throwIndex/BALLS_PER_FRAME;
        cumulScores[bowlIndex][(frameNum)] += curScore[throwIndex+1] + curScore[throwIndex];
    }

}
