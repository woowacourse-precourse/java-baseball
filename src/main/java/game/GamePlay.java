package game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GamePlay {
    private static final int ANSWER_START_NUMBER = 1;
    public static final int ANSWER_END_NUMBER = 9;
    public static final int ANSWER_LENGTH = 3;

    public static final int JUDGEMENT_IS_STRIKE = 1;
    public static final int JUDGEMENT_IS_BALL = 2;
    public static final int JUDGEMENT_IS_NOTHING = 3;
    public static List<Integer> getAnswer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(ANSWER_START_NUMBER, ANSWER_END_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static int judgeBallOrStrike(List<Integer> answer, int userChar,int userCharIdx){
        if(answer.get(userCharIdx)==userChar){
            return JUDGEMENT_IS_STRIKE;
        }
        for (int answerChar : answer){
            if(userChar==answerChar) return JUDGEMENT_IS_BALL;
        }
        return JUDGEMENT_IS_NOTHING;
    }

    public static void printHintMessage(int ball, int strike){
        if(ball==0&&strike==0){
            System.out.print("낫싱 ");
        }
        if(ball!=0){
            System.out.print(ball+"볼 ");
        }
        if(strike!=0){
            System.out.print(strike+"스트라이크 ");
        }
        System.out.println();

    }
    public static boolean provideHintMessage(List<Integer> answer, List<Integer> userInput){
        boolean isAnswer = false;
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < ANSWER_LENGTH; i++) {
            int userChar = userInput.get(i);
            int judgement = judgeBallOrStrike(answer, userChar, i);
            if (judgement == JUDGEMENT_IS_STRIKE) {
                strike++;
            } else if (judgement == JUDGEMENT_IS_BALL) {
                ball++;
            }
        }
        printHintMessage(ball, strike);
        if (strike == ANSWER_LENGTH) {
            isAnswer = true;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 ");
        }
        return isAnswer;
    }

}
