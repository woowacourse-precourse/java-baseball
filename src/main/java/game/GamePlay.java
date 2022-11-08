package game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GamePlay {
    private static final int ANSWER_START_NUMBER = 1;
    public static final int ANSWER_END_NUMBER = 9;
    public static List<Integer> getAnswer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(ANSWER_START_NUMBER, ANSWER_END_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static boolean provideHintMessage(List<Integer> answer, List<Integer> userInput){
        boolean isAnswer = false;
        int ball = 0;
        int strike = 0;

        for(int userChar : userInput){
            // TODO: 2022/11/08 answer과 userChar비교해 ball, strike 여부 판단하는 함수 : 리턴값에 따라 ball이나 strike 증가
        }



        return isAnswer;
    }

}
