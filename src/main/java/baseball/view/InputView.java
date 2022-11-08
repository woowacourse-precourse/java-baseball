package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private int RESTART_NUM = 1;
    private int EXIT_NUM = 2;
    private String GAMESTART = "숫자 야구 게임을 시작합니다.";
    private String INPUT_USERNUM = "숫자를 입력해주세요 : ";
    private String restartOrExit = String.format("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.",
            RESTART_NUM, EXIT_NUM);
    private String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void GameStart() {
        System.out.println(GAMESTART);
    }

    public void InputUserNum() {
        System.out.println(INPUT_USERNUM);
    }

    public String RestartOrExit() {
        System.out.println(GAME_END);
        System.out.println(restartOrExit);
        String userInputNum = Console.readLine();

        return userInputNum;
    }

}
