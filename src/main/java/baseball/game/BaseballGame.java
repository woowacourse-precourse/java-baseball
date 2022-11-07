package baseball.game;

import baseball.player.Computer;
import baseball.player.Human;
import baseball.player.Playable;
import baseball.validator.Referee;
import baseball.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 야구 게임 역할을 맡는다. 사람과 컴퓨터가 존재하며, 정답의 유효성과 정확성을 판단하는 심판이 존재한다.
 */
public class BaseballGame implements Game {

    private Playable human;
    private Playable computer;
    private Validator referee;
    private List<Integer> answer;
    private boolean isPlaying;

    public BaseballGame() {
        this.human = new Human();
        this.computer = new Computer();
        this.referee = new Referee();
        this.isPlaying = true;
    }

    @Override
    public void start() {
        while (isPlaying) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            startGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            selectGameStatus();
        }
    }

    @Override
    public void restart() {
        isPlaying = true;
    }

    @Override
    public void stop() {
        isPlaying = false;
    }

    /**
     * 게임을 시작시킨다. 이후, 정답을 생성하고 입력받는다.
     */
    private void startGame() {
        generateAnswer();
        do {
            System.out.print("숫자를 입력해주세요 : ");
            inputAnswer();
        } while (!isCorrectAnswer());
    }

    /**
     * 컴퓨터가 정답을 생성하여 심판에게 정답을 보낸다.
     */
    private void generateAnswer() {
        computer.inputAnswer();
        answer = computer.getAnswer();
        referee.setAnswer(answer);
    }

    /**
     * 정답을 입력한다.
     */
    private void inputAnswer() {
        human.inputAnswer();
    }

    /**
     * 다음 게임 상태를 결정한다.
     */
    private void selectGameStatus() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine().trim();
        validateInput(input);
        if (input.equals("1")) {
            restart();
        } else {
            stop();
        }
    }

    /**
     * 다음 게임 상태에 대한 입력값의 유효성을 판별한다. 1과 2만 입력할 수 있으며
     * 그 외의 입력에 대해선 <code>IllegalArgumentException</code>예외를 던진다.
     *
     * @param input
     */
    private void validateInput(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("옳바른 입력값이 아닙니다.");
        }
    }

    /**
     * 정답인지 판별한다.
     *
     * @return 정답이라면 true
     */
    private boolean isCorrectAnswer() {
        return referee.checkAnswer(human.getAnswer());
    }
}
