package baseball;

import baseball.data.BaseballData;
import baseball.game.NumberParser;
import baseball.game.NumberReferee;
import baseball.game.ComputerInput;
import baseball.game.PlayerInput;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final PlayerInput playerInput = new PlayerInput();
    private static final ComputerInput computerInput = new ComputerInput();
    private static final NumberReferee numberReferee = new NumberReferee();
    private static final NumberParser numberParser = new NumberParser();

    public static void main(String[] args) {
        StartNumberBaseballGame();
    }

    public static void StartNumberBaseballGame() {
        List<Integer> computer;
        ComputerInput computerInput = new ComputerInput();
        do {
            computer = computerInput.GenerateComputerNumbers();
            StartGuessingPhase(computer);
        } while (StartQuestioningPhase());
    }

    public static void StartGuessingPhase(List<Integer> computer) { // 병목지점. 반드시 메서드를 분리해야됨.
        List<Integer> player;
        int strike = 0;
        int ball = 0;
        while (strike != BaseballData.GAME_SIZE) {
            String input = playerInput.inputPlayerString();
            player = numberParser.parsePlayerNumber(input);
            strike = numberReferee.checkStrike(player, computer);
            ball = numberReferee.checkBall(player, computer);
            System.out.println(player);
            PrintResult(strike, ball);
        }
    }

    public static boolean StartQuestioningPhase() {
        String input;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = Console.readLine();

        if (input.equals(BaseballData.RESTART)) {
            return true;
        } else if (input.equals(BaseballData.GAME_OVER)) {
            return false;
        }

        throw new IllegalArgumentException("1과 2만 허용됩니다.");
    }

    public static void PrintResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
            if (strike == 3) {
                System.out.println();
                System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
        System.out.println();
    }

}