package baseball;

import static baseball.utils.InputUtil.*;
import static baseball.utils.OutputUtil.*;
import static baseball.utils.RandomUtil.*;

public class Baseball {
    public void startGame() {
        int[] computerNumbers = createRandomNumberList();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            int[] input = getUserNumberInput();

            processingGame(computerNumbers, input);

        }
    }

    private void processingGame(int[] computerNumbers, int[] input) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            String result = makeHint(computerNumbers, input[i], i);
            if (result.equals("스트라이크")) {
                strike++;
            } else if (result.equals("볼")) {
                ball++;
            }
        }
        System.out.println(printHint(strike, ball));
        if (strike == 3)
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
