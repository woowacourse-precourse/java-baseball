package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class AllStrikeView {
    public static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String REGAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    public static boolean replayGame() {
        System.out.println(END_MESSAGE);
        System.out.println(REGAME_MESSAGE);
        String playerInput = Console.readLine();

        if (playerInput.equals("1")) {
            return true;
        }
        return false;
    }
}
