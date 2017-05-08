package ScoreStatesPackage;


/**
 * Created by Kaurakit on 5/1/2017.
 */
public class NormalThrowState implements ScoringState {

    public void getScore(int[] curScore, int[][] cumulScores, int throwIndex, int bowlIndex){
        int frameNum = throwIndex/BALLS_PER_FRAME;

        //We're dealing with a normal throw, add it and be on our way.

        if( throwIndex%2 == 0 && throwIndex < 18){
            if ( throwIndex == 0 ) {
                //First frame, first ball.  Set his cumul score to the first ball
                cumulScores[bowlIndex][frameNum] += curScore[throwIndex];

            }
            else if (frameNum != 9){
                //add his last frame's cumul to this ball, make it this frame's cumul.
                if(curScore[throwIndex] != -2){
                     cumulScores[bowlIndex][frameNum] += cumulScores[bowlIndex][frameNum - 1] + curScore[throwIndex];
                } else {
                    cumulScores[bowlIndex][frameNum] += cumulScores[bowlIndex][frameNum - 1];
                }
            }
        }
        else if (throwIndex < 18){
            //REF before the
            if(curScore[throwIndex] != -1 && throwIndex > 2){
                cumulScores[bowlIndex][frameNum] += curScore[throwIndex];
            }
        }
        if ( throwIndex == 1 && curScore[throwIndex] > 0) {
            //REF adding the second throw to the cumulScores
            cumulScores[bowlIndex][0] += curScore[1];
        }
        if (frameNum == 9){
            //if 2nd last frame
            if (throwIndex == 18){
                //if its the 2nd throw of the last frame
                cumulScores[bowlIndex][9] += cumulScores[bowlIndex][8];
            }
            if(curScore[throwIndex] != -2){
                //if its not a strike
                cumulScores[bowlIndex][9] += curScore[throwIndex];
            }
        }
        else if (frameNum == 10) {
            //if its the last frame
            if(curScore[throwIndex] != -2){
                // REF if its not a strike
                cumulScores[bowlIndex][9] += curScore[throwIndex];
            }
        }
    }
}




