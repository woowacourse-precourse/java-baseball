package baseball;

import baseball.data.GameData;
import baseball.game.ComputerNumberGenerator;
import baseball.game.NumberComparer;
import baseball.game.StringParser;
import baseball.game.PlayerNumberInput;
import baseball.printer.PrintData;
import baseball.printer.ResultPrint;
import java.util.List;

public class Application {
    private static final PlayerNumberInput playerNumberInput = new PlayerNumberInput();
    private static final ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
    private static final NumberComparer numberComparer = new NumberComparer();
    private static final StringParser stringParser = new StringParser();
    private static final ResultPrint resultPrint = new ResultPrint();

    public static void main(String[] args) {
        PrintData.printData("GAME_START");
        PrintData.printLine();
        startNumberBaseballGame();
    }

    public static void startNumberBaseballGame() {
        List<Integer> computer;
        do {
            computer = computerNumberGenerator.generateComputerNumbers();
            startGuessingPhase(computer);
        } while (startQuestioningPhase());
    }

    public static void startGuessingPhase(List<Integer> computer){
        List<Integer> player;
        int strike = 0;
        int ball = 0;
        while (strike != GameData.GAME_SIZE) {
            String input = playerNumberInput.inputPlayerString(); // 문자열 형식으로 플레이어의 숫자 입력
            player = stringParser.parsePlayerNumber(input); //
            strike = numberComparer.checkStrike(player, computer);
            ball = numberComparer.checkBall(player, computer);

            resultPrint.printGuessResult(strike, ball); // 스트라이크와 볼 개수에 맞춰 출력
        }
    }

    public static boolean startQuestioningPhase() {
        String restartString = playerNumberInput.inputRestartString();
        stringParser.checkExceptionsPlayerRestartString(restartString);
        if(stringParser.checkPlayerRestartString(restartString)){
            return true;
        }
        return false;
    }
}