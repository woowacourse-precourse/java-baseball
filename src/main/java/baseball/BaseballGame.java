package baseball;

import static baseball.utils.Constants.CONTINUE;
import static baseball.utils.Constants.RANDOM_NUMBER_LENGTH;

import java.util.List;

public class BaseballGame implements Game {

    @Override
    public void intro() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void run() {
        int strike = 0;
        int ball;
        List<Integer> computer = RandomThreeDigitNumberGenerator.generate();
        List<Integer> player;

        System.out.println(computer);
        while (strike != RANDOM_NUMBER_LENGTH) {
            System.out.print("숫자를 입력해주세요 : ");
            player = BaseballGameService.getPlayerNumber();
            List<Integer> ballAndStrike = ResultCalculator.calculateBallAndStrike(computer, player);
            ball = ballAndStrike.get(0);
            strike = ballAndStrike.get(1);
            System.out.println(ball + "볼 " + strike + "스트라이크:");
        }
    }

    @Override
    public void outro() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (BaseballGameService.getContinueOrBreak() == CONTINUE) {
            replay();
        }
    }
}
