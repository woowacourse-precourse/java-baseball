package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static User user;
    private static Computer computer;

    private final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String USER_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String BALL_MESSAGE = "볼";
    private final String STRIKE_MESSAGE = "스트라이크";
    private final String NOTHING_MESSAGE = "낫싱";
    private final String END_CONDITION = "3스트라이크";

    public void run() {
        List<Integer> input = new ArrayList<>(), result = new ArrayList<>();
        String cvtResult = new String();

        start();

        while(!cvtResult.equals(END_CONDITION)) {
            System.out.print(USER_NUMBER_INPUT_MESSAGE);
            input = user.getInputNumbers();
            result = computer.compareWithAnswer(input);
            cvtResult = getResultCvtToStr(result);
            System.out.println(cvtResult);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void start() {
        System.out.println(GAME_START_MESSAGE);
        user = new User();
        computer = new Computer();
        computer.generateNewRandomAnswer();
    }

    public String getResultCvtToStr(List<Integer> result) {
        String cvtResult = new String("");
        if(result.get(0)!=0) {
            cvtResult += result.get(0) + BALL_MESSAGE;
        }
        if(!cvtResult.equals("")) {
            cvtResult += " ";
        }
        if(result.get(1)!=0) {
            cvtResult += result.get(1) + STRIKE_MESSAGE;
        }
        if(cvtResult.equals("")) {
            cvtResult += NOTHING_MESSAGE;
        }
        return cvtResult;
    }

    public boolean toBeContinue() {
        Integer number = user.getNumberToContinueGame();
        if(number.equals(1)) {
            return true;
        }
        else {
            return false;
        }
    }
}
