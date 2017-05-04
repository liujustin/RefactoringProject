package ScoreStatesPackage;

import BowlerPackage.Bowler;

/**
 * Created by Kaurakit on 5/1/2017.
 */
public class DefaultState implements Scoring{

    private int[] curScores;
    private int[][] cumulScores;

    public void getScore(int[] curScore, int[][] cumulScores, int throwIndex, int bowlIndex){
        int balls_per_frame = 2;
        int frameNum = throwIndex/balls_per_frame;

        //We're dealing with a normal throw, add it and be on our way.

        if( throwIndex%2 == 0 && throwIndex < 18){
            if ( throwIndex == 0 ) {
                //First frame, first ball.  Set his cumul score to the first ball
                if(curScore[throwIndex] != -2){
                    cumulScores[bowlIndex][frameNum] += curScore[throwIndex];
                }
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
            if(curScore[throwIndex] != -1 && throwIndex > 2){
                if(curScore[throwIndex] != -2){
                    cumulScores[bowlIndex][frameNum] += curScore[throwIndex];
                }
            }
        }
        if ( throwIndex == 1 && curScore[throwIndex] > 0) {
            cumulScores[bowlIndex][0] += curScore[1];
        }
        if (frameNum == 9){
            if (throwIndex == 18){
                cumulScores[bowlIndex][9] += cumulScores[bowlIndex][8];
            }
            if(curScore[throwIndex] != -2){
                cumulScores[bowlIndex][9] += curScore[throwIndex];
            }
        }
        else if (frameNum == 10) {
            if(curScore[throwIndex] != -2){
                cumulScores[bowlIndex][9] += curScore[throwIndex];
            }
        }
    }
}




