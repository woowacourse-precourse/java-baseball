package baseball;

import baseball.exception.InputException;
import baseball.service.ComputerService;
import baseball.service.PlayerService;
import baseball.service.ScoreBoardService;
import baseball.view.InstructionView;
import baseball.view.ResultView;

import java.util.List;

public class Game {
    private static final int RESTART = 1;
    ComputerService computerService = new ComputerService();
    InputException inputException = new InputException();
    InstructionView instructionView = new InstructionView();
    PlayerService playerService = new PlayerService();
    ResultView resultView = new ResultView();
    ScoreBoardService scoreBoardService = new ScoreBoardService();

    /**
     * 재시작/종료 코드의 예외를 체크하고 있으면 던진다.
     *
     * @param runCode 재시작/종료 코드
     */
    private void checkRunCodeException(String runCode) {
        inputException.isInvalidCodeSize(runCode);
        inputException.isDigitException(runCode);
        inputException.isInvalidCode(Integer.parseInt(runCode));
    }

    /**
     * 재시작/종료 코드를 입력받고 정수형으로 변환하며<br>
     * 예외를 확인하여 있으면 던진다.
     *
     * @return 정수형 재시작(1)/종료(2) 코드
     */
    private int inputRunCode() {
        String runCode = instructionView.printInputCode();
        checkRunCodeException(runCode);
        return Integer.parseInt(runCode);
    }

    /**
     * 게임 결과를 출력한다.<br>
     * 볼과 스트라이크가 0이 아니면 볼 스트라이크<br>
     * 볼이 있으면 볼<br>
     * 스트라이크가 있으면 스트라이크<br>
     * 볼과 스트라이크가 둘다 없으면 낫싱<br>
     */
    private void printResult() {
        if (scoreBoardService.isBallAndStrike()) {
            resultView.printBall(scoreBoardService.getScoreBoard().getBall());
            resultView.printStrike(scoreBoardService.getScoreBoard().getStrike());
        } else if (scoreBoardService.isBall()) {
            resultView.printBall(scoreBoardService.getScoreBoard().getBall());
            System.out.println("");
        } else if (scoreBoardService.isStrike()) {
            resultView.printStrike(scoreBoardService.getScoreBoard().getStrike());
        } else if (scoreBoardService.isNothing()) {
            resultView.printNothing();
        }
    }

    /**
     * 컴퓨터의 랜덤 숫자들을 초기화하고 성공이 아닐시 반복 수행을 하며<br>
     * 플레이어가 입력한 숫자들을 가지고 비교한다.<br>
     * 비교 성공시 재시작/종료 코드를 입력받으며 재시작 코드 입력시 다시 게임을 시작한다.
     */
    private void runGame() {
        computerService.initComputer();
        List<Integer> computerNumbers = computerService.getComputer().getNumbers();
        while (!scoreBoardService.isThreeStrike()) {
            String inputNumbers = instructionView.printInputNumbers();
            playerService.inputNumbersToPlayer(inputNumbers);
            List<Integer> playerNumbers = playerService.getPlayer().getNumbers();
            scoreBoardService.setScoreBoard(computerNumbers, playerNumbers);
            printResult();
        }
        resultView.printSuccess();
        if (inputRunCode() == RESTART) {
            scoreBoardService.getScoreBoard().setThreeStrike(false);
            runGame();
        }
    }

    /**
     * 야구 게임의 시작한다고 알리는 출력문을 출력후 게임을 실행한다.
     */
    public void startGame() {
        instructionView.printStart();
        runGame();
    }
}