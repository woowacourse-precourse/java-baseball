package baseball;

import baseball.data.BaseballData;
import baseball.game.NumberParser;
import baseball.game.NumberReferee;
import baseball.game.ComputerInput;
import baseball.game.PlayerNumberInput;
import baseball.printer.ResultPrint;
import java.util.List;

public class Application {
    private static final PlayerNumberInput playerNumberInput = new PlayerNumberInput();
    private static final ComputerInput computerInput = new ComputerInput();
    private static final NumberReferee numberReferee = new NumberReferee();
    private static final NumberParser numberParser = new NumberParser();
    private static final ResultPrint resultPrint = new ResultPrint();

    public static void main(String[] args) {
        startNumberBaseballGame();
    }

    public static void startNumberBaseballGame() {
        List<Integer> computer;
        do {
            computer = computerInput.generateComputerNumbers();
            startGuessingPhase(computer);
        } while (startQuestioningPhase());
    }

    public static void startGuessingPhase(List<Integer> computer){
        List<Integer> player;
        int strike = 0;
        int ball = 0;
        while (strike != BaseballData.GAME_SIZE) {
            String input = playerNumberInput.inputPlayerString();
            player = numberParser.parsePlayerNumber(input);
            strike = numberReferee.checkStrike(player, computer);
            ball = numberReferee.checkBall(player, computer);
            resultPrint.printGuessResult(strike, ball);
        }
    }

    public static boolean startQuestioningPhase() {
        String restartString = playerNumberInput.inputRestartString();
        numberParser.checkExceptionsPlayerRestartString(restartString);
        if(numberParser.checkPlayerRestartString(restartString)){
            return true;
        }
        return false;
    }
}