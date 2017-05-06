package ScoreStatesPackage;


/**
 * Created by SerBubblez on 5/1/2017.
 */
public interface Scoring {

    int BALLS_PER_FRAME = 2;

    void getScore(int[] curScore, int[][] cumulScores, int throwIndex, int bowlIndex);

}
