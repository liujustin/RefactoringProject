package ScoreStatesPackage;

/**
 * Created by Kaurakit on 5/1/2017.
 */
public class StrikeState implements ScoringState {


    public StrikeState (){

    }

    public void getScore(int[] curScore, int[][] cumulScores, int throwIndex, int bowlIndex){
        int frameNum = throwIndex/BALLS_PER_FRAME;

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
                // REF if there exists a subsequent throw to add
                cumulScores[bowlIndex][frameNum] += curScore[throwIndex+1] + cumulScores[bowlIndex][(frameNum)-1];
                if (curScore[throwIndex+2] != -1 && curScore[throwIndex+2] != -2){
                    // REF if there exists a second throw to add that isn't a strike
                    cumulScores[bowlIndex][(frameNum)] += curScore[throwIndex+2];
                }
            }
            else {
                if ( frameNum > 0 ){
                    // REF if its not the first frame
                    cumulScores[bowlIndex][frameNum] += curScore[throwIndex+2] + cumulScores[bowlIndex][(frameNum)-1];
                } else {
                    cumulScores[bowlIndex][frameNum] += curScore[throwIndex+2];
                }
                if (curScore[throwIndex+3] != -1){
                    //REF if there exists two more scores to add to it
                    if( curScore[throwIndex+3] != -2){
                        //REF if he last score to add isn't a strike
                        cumulScores[bowlIndex][(frameNum)] += curScore[throwIndex+3];
                    }
                } else {
                    cumulScores[bowlIndex][(frameNum)] += curScore[throwIndex+4];

                }
            }
        }
    }

}

