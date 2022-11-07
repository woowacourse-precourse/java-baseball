package baseball.view;

import baseball.view.utils.OutputUtils;
import baseball.view.utils.UserInputUtils;

public class RestartView {

    public boolean doseUserWantMoreGame() {
        OutputUtils.outputLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        OutputUtils.outputLine("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = UserInputUtils.readLine();
        if (userInput.trim().equals("1")) {
            return true;
        }
        if (userInput.trim().equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("1또는 2만 입력해주세요");
    }
}
