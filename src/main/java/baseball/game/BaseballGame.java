package baseball.game;

import baseball.player.Computer;
import baseball.player.Human;
import baseball.player.Playable;
import baseball.validator.Referee;
import baseball.validator.Validator;

import java.util.List;

public class BaseballGame implements Game{
    private Playable human;
    private Playable computer;
    private Validator referee;
    private boolean isPlaying;
    private List<Integer> answer;

    public BaseballGame() {
        this.human = new Human();
        this.computer = new Computer();
        this.referee = new Referee();
        this.isPlaying = true;
    }

    @Override
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(isPlaying){
            generateAnswer(computer, referee);
        }
    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    private void generateAnswer(Playable computer, Validator referee){
        computer.setNumber();
        answer = computer.getNumber();
        referee.setAnswer(answer);
    }
}
