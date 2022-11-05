package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NUBMER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료.\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public View(){}

    public String initView(){
        System.out.println(GAME_START_MESSAGE);
        System.out.println(NUBMER_INPUT_MESSAGE);
        String inputNumber = Console.readLine();
        return inputNumber;
    }

}
