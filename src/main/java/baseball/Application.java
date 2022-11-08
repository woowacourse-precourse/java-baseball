package baseball;

import static game.GamePlay.getAnswer;
import static game.GamePlay.provideHintMessage;
import static user.UserInput.getUserInput;
import static user.UserInput.isRetry;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final List<Integer> answer = getAnswer();
        System.out.println(answer);

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isContinued = true;

        while (isContinued) {
            boolean isCorrect = provideHintMessage(answer, getUserInput());
            if (isCorrect == true) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                final String retryUserInput = Console.readLine();
                isContinued = isRetry(retryUserInput);
            }
        }

    }
}
