package baseball;

import static baseball.utils.Constants.CONTINUE;
import static baseball.utils.Constants.RANDOM_NUMBER_LENGTH;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameMachine {
    public static IntInputValidator intInputValidator;

    public static void startBaseballGame() {
        int strike = 0;
        int ball;
        int playerNumberInput;
        List<Integer> player;
        List<Integer> computer = RandomThreeDigitNumberGenerator.generate();
        System.out.print("숫자 야구 게임을 시작합니다.");

        while (strike != RANDOM_NUMBER_LENGTH) {
            System.out.print("숫자를 입력해주세요 : ");
            playerNumberInput = StringToIntConvertor.convert(Console.readLine());
            intInputValidator = new PlayerNumberValidator();
            intInputValidator.validate(playerNumberInput);
            player = Arrays.stream(String.valueOf(playerNumberInput).split("")).map(Integer::parseInt)
                    .collect(Collectors.toList());

            List<Integer> ballAndStrike = ResultCalculator.calculateBallAndStrike(computer, player);
            ball = ballAndStrike.get(0);
            strike = ballAndStrike.get(1);
            System.out.println(ball + "볼 " + strike + "스트라이크:");
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int continueOrBreak = StringToIntConvertor.convert(Console.readLine());
        intInputValidator = new ContinueOrBreakValidator();
        intInputValidator.validate(continueOrBreak);
        if (continueOrBreak == CONTINUE) {
            GameMachine.startBaseballGame();
        }
    }
}
