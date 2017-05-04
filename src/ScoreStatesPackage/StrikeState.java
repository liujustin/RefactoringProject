package ScoreStatesPackage;

import BowlerPackage.Bowler;
import LanePackage.Lane;

/**
 * Created by Kaurakit on 5/1/2017.
 */
public class StrikeState implements Scoring {

    public StrikeState (){

    }

    public void getScore(int[] curScore, int[][] cumulScores, int throwIndex, int bowlIndex){
        int balls_per_frame = 2;
        int frameNum = throwIndex/balls_per_frame;

        boolean strikeballs = false;

        // REF This ball is the first ball, and was a strike.
        // REF If we can get 2 balls after it, good add them to cumul.
        if (curScore[throwIndex+2] != -1) {
            // REF if there exists 2 more scores to add on, count it as a strike
            strikeballs = true;
            if(curScore[throwIndex+3] != -1 && curScore[throwIndex+4] != -1) {
                //REF if there exists 3 more scores to add on, there are two strikes
                //Still got em.
                strikeballs = true;
            }
        }
        if (strikeballs){
            //Add up the strike.
            //Add the next two balls to the current cumulscore.
            cumulScores[bowlIndex][frameNum] += 10;
            if(curScore[throwIndex+1] != -1) {
                cumulScores[bowlIndex][frameNum] += curScore[throwIndex+1] + cumulScores[bowlIndex][(frameNum)-1];
                if (curScore[throwIndex+2] != -1){
                    if( curScore[throwIndex+2] != -2){
                        cumulScores[bowlIndex][(frameNum)] += curScore[throwIndex+2];
                    }
                } else {
                    if( curScore[throwIndex+3] != -2){
                        cumulScores[bowlIndex][(frameNum)] += curScore[throwIndex+3];
                    }
                }
            } else {
                if ( throwIndex/2 > 0 ){
                    cumulScores[bowlIndex][frameNum] += curScore[throwIndex+2] + cumulScores[bowlIndex][(frameNum)-1];
                } else {
                    cumulScores[bowlIndex][frameNum] += curScore[throwIndex+2];
                }
                if (curScore[throwIndex+3] != -1){
                    if( curScore[throwIndex+3] != -2){
                        cumulScores[bowlIndex][(frameNum)] += curScore[throwIndex+3];
                    }
                } else {
                    cumulScores[bowlIndex][(frameNum)] += curScore[throwIndex+4];

                }
            }
        }
    }

}

