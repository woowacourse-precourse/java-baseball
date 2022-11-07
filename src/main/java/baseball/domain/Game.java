package baseball.domain;

import baseball.exception.GameException;
import baseball.exception.TypeException;
import baseball.view.Instruction;
import baseball.view.Result;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private static final int START = 1;
    private static final int THREE_STRIKE = 3;
    private static final Instruction instruction = new Instruction();
    private static final GameException gameException = new GameException();
    private static final TypeException typeException = new TypeException();
    Result result = new Result();
    Computer computer;
    Player player;

    public void initGame() {
        instruction.printStart();
        startGame();
    }

    /**
     * 게임을 시작한다.
     */
    private void startGame() {
        setComputer();
        do {
            setPlayer();
        } while (!canSuccess());
        if (setRunCode() == START) {
            startGame();
        }
    }

    /**
     * 사용자의 입력과 컴퓨터의 번호가 동일하여 성공이 가능한지 판단한다.
     *
     * @return 성공하면 true
     */
    private boolean canSuccess() {
        int[] ballAndStrike = new Comparator(computer.getRandomNumbers(), player.getPlayerNumbers()).getResult();
        int ball = ballAndStrike[0];
        int strike = ballAndStrike[1];
        if (isBall(ball)) {
            if (isStrike(strike)) { // `x`볼 `y`스트라이크
                return false;
            }
            System.out.println("");
            return false;
        }
        if (isStrike(strike)) {
            return isThreeStrike(strike);
        }
        result.printNothing();
        return false;
    }

    /**
     * 입력받은 재시작/종료 코드를 검증하여 예외 상황이 있으면 던진다.
     *
     * @param runCode 재시작/종료 코드
     * @return 재시작/종료 코드
     */
    private String inputRunCode(String runCode) {
        gameException.runCodeLengthException(runCode);
        return runCode;
    }

    /**
     * 볼이 있는지 확인하고 볼이 몇개인지 출력한다.
     *
     * @param ball 볼
     * @return 볼이 있으면 true
     */
    private boolean isBall(int ball) {
        if (ball == 0) {
            return false;
        }
        result.printBall(ball);
        return true;
    }

    /**
     * 스트라이크가 있는지 확인하고 스트라이크가 몇개인지 출력한다.
     *
     * @param strike 스트라이크
     * @return 스트라이크가 있으면 true
     */
    private boolean isStrike(int strike) {
        if (strike == 0) {
            return false;
        }
        result.printStrike(strike);
        return true;
    }

    /**
     * 스트라이크가 THREE_STRIKE 와 동일한지 확인하고 동일하면 성공메시지를 출력한다.
     *
     * @param strike 스트라이크
     * @return 스트라이크가 THREE_STRIKE 와 동일하면 true
     */
    private boolean isThreeStrike(int strike) {
        if(strike == THREE_STRIKE) {
            result.printSuccess();
            return true;
        }
        return false;
    }

    /**
     * 컴퓨터를 설정한다.
     */
    private void setComputer() {
        computer = new Computer();
    }

    /**
     * 재시작/종료 코드를 설정한다.
     *
     * @return 재시작/종료 코드
     */
    private int setRunCode() {
        instruction.printRunCode();
        String stringRunCode = inputRunCode(Console.readLine());
        return toInt(stringRunCode);
    }

    /**
     * 플레이어의 번호를 입력받아 설정한다.
     */
    private void setPlayer() {
        instruction.printInputData();
        player = new Player(Console.readLine());
    }

    /**
     * 정수형으로 변환하며 검증을 거쳐 예외 사항이 있으면 던진다.
     *
     * @param runCode 문자형 재시작/종료 코드
     * @return 정수형 재시작/종료 코드
     */
    private int toInt(String runCode) {
        typeException.typeException(runCode);
        int intRunCode = Integer.parseInt(runCode);
        gameException.runCodeValidation(intRunCode);
        return intRunCode;
    }
}
