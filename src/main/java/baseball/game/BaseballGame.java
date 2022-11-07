package baseball.game;

import baseball.player.Computer;
import baseball.player.Human;
import baseball.player.Playable;
import baseball.validator.Referee;
import baseball.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

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

    private void startGame() {
        generateAnswer();
        do {
            System.out.print("숫자를 입력해주세요 : ");
            inputAnswer();
        } while (!isCorrectAnswer());
    }

    private void generateAnswer() {
        computer.inputAnswer();
        answer = computer.getAnswer();
        referee.setAnswer(answer);
    }

    private void inputAnswer() {
        human.inputAnswer();
    }

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

    private void validateInput(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("옳바른 입력값이 아닙니다.");
        }
    }

    private boolean isCorrectAnswer() {
        return referee.checkAnswer(human.getAnswer());
    }
}
