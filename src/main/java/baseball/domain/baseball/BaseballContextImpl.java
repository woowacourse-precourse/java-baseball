package baseball.domain.baseball;

import baseball.domain.baseball.status.BaseballGameStatus;
import baseball.domain.baseball.status.InitStatus;
import baseball.domain.player.Computer;
import baseball.domain.player.Participant;
import baseball.domain.player.Player;
import baseball.domain.referee.Referee;
import baseball.domain.score.Score;
import camp.nextstep.edu.missionutils.Console;

public class BaseballContextImpl implements BaseballContext {
    private final Referee referee;
    private BaseballGameStatus gameStatus;
    private Player computer;
    private Player participant;

    public BaseballContextImpl() {
        this.referee = new Referee();
        this.gameStatus = new InitStatus();
    }


    @Override
    public String input() {
        return Console.readLine();
    }

    @Override
    public void initializeComputerNumber() {
        this.computer = new Computer();
    }

    @Override
    public void initializeParticipantNumber(String input) {
        this.participant = new Participant(input);
    }

    @Override
    public Score ruled() {
        return referee.ruled(computer.numbers(), participant.numbers());
    }

    @Override
    public boolean runAble() {
        return this.gameStatus.runAble();
    }

    @Override
    public void next() {
        this.gameStatus = this.gameStatus.next(this);
    }

    @Override
    public void println(final String message) {
        System.out.println(message);
    }

    @Override
    public void print(String message) {
        System.out.print(message);
    }
}
