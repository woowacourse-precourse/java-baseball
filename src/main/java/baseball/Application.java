package baseball;

import baseball.data.BaseballData;
import baseball.game.NumberParser;
import baseball.game.NumberReferee;
import baseball.game.ComputerInput;
import baseball.game.PlayerNumberInput;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final PlayerNumberInput playerNumberInput = new PlayerNumberInput();
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

    public static void StartGuessingPhase(List<Integer> computer){
        List<Integer> player;
        int strike = 0;
        int ball = 0;
        while (strike != BaseballData.GAME_SIZE) {
            String input = playerNumberInput.inputPlayerString();
            player = numberParser.parsePlayerNumber(input);
            strike = numberReferee.checkStrike(player, computer);
            ball = numberReferee.checkBall(player, computer);
            PrintResult(strike, ball);
        }
    }

    public static boolean StartQuestioningPhase() {
        String restartString = playerNumberInput.inputRestartString();
        numberParser.checkExceptionsPlayerRestartString(restartString);
        if(numberParser.checkPlayerRestartString(restartString)){
            return true;
        }
        return false;
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