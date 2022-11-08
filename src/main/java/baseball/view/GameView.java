package baseball.view;

import baseball.utils.InputValidation;
import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameView {
    private String GAME_START = "숫자 야구 게임을 시작합니다.";
    private String GAME_SET = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private InputValidation inputValidation;

    private void gameStartMessage(){
        System.out.println(GAME_START);
    }

    private String getInputNumber(){
        System.out.println(INPUT_NUMBER);
        String input = Console.readLine();
        inputValidation.validationNumber(input);
        return input;
    }

    public String gameReStart(){
        System.out.println(GAME_SET);
        String number = Console.readLine();
        inputValidation.isNumeric(number);
        return number;

    }



}
