package baseball;

import java.util.ArrayList;

public class BallStrikeChecker {
    static boolean threeStrike;
    ArrayList<Integer> judgement;

    public BallStrikeChecker(RandomNumberGenerator answer, Guess myGuess){
        threeStrike=false;
        judgement=countBallAndStrike(answer.numberList,myGuess.numberList);
        if(judgement.get(1)==3){
            threeStrike=true;
        }
    }
    static ArrayList<Integer> countBallAndStrike(ArrayList<Integer> guessList, ArrayList<Integer> answers) {
        ArrayList<Integer> ballStrikeCnt = new ArrayList<>() {{
            add(0);
            add(0);
        }};
        Integer strikeCnt;
        Integer ballCnt;

        for (int idx = 0; idx < guessList.size(); idx++) {
            int guess = guessList.get(idx);

            if (guess == answers.get(idx)) {
                strikeCnt = ballStrikeCnt.get(1);
                ballStrikeCnt.set(1, ++strikeCnt);
                continue;
            }
            if (answers.contains(guess)) {
                ballCnt = ballStrikeCnt.get(0);
                ballStrikeCnt.set(0, ++ballCnt);
            }
        }

        return ballStrikeCnt;
    }
}
