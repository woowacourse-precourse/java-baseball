package baseball;

import baseball.data.GameData;
import baseball.game.ComputerNumberGenerator;
import baseball.game.NumberComparer;
import baseball.game.StringParser;
import baseball.game.PlayerNumberInput;
import baseball.data.PrintData;
import baseball.printer.ResultPrint;
import java.util.List;

public class Application {
    private static final PlayerNumberInput playerNumberInput = new PlayerNumberInput();
    private static final ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
    private static final NumberComparer numberComparer = new NumberComparer();
    private static final StringParser stringParser = new StringParser();
    private static final ResultPrint resultPrint = new ResultPrint();

    public static void main(String[] args) {
        PrintData.printStringData("GAME_START");
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

    /**
     * 컴퓨터가 생성한 숫자가 무엇인지 알아 맞추는 단계<br>
     * 스트라이크가 3개면 재시작할지 물어보는 단게로 넘어감
     * @param computer 컴퓨터가 생성한 정수 3개 리스트
     */
    public static void startGuessingPhase(List<Integer> computer){
        List<Integer> player;
        int strike = 0;
        int ball;
        while (strike != GameData.GAME_SIZE) {
            String input = playerNumberInput.inputPlayerString(); // 문자열 형식으로 플레이어의 숫자 입력
            player = stringParser.parsePlayerNumber(input);
            strike = numberComparer.checkStrike(player, computer);
            ball = numberComparer.checkBall(player, computer);

            resultPrint.printGuessResult(strike, ball); // 스트라이크와 볼 개수에 맞춰 출력
        }
    }

    /**
     * 게임을 재시작할지 물어보는 단계
     * @return true: 재시작, false: 프로그램 종료.
     */
    public static boolean startQuestioningPhase() {
        String restartString = playerNumberInput.inputRestartString();
        stringParser.checkExceptionsPlayerRestartString(restartString);
        if(stringParser.checkPlayerRestartString(restartString)){
            return true;
        }
        return false;
    }
}