package baseball.domain.baseball;

import baseball.domain.baseball.status.BaseballGameStatus;
import baseball.domain.baseball.status.InitStatus;
import baseball.domain.player.Computer;
import baseball.domain.player.Participant;
import baseball.domain.player.Player;
import baseball.domain.referee.Referee;
import baseball.domain.score.Score;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private final Referee referee;
    private BaseballGameStatus gameStatus;
    private Player computer;
    private Player participant;

    public BaseballGame() {
        this.referee = new Referee();
        this.gameStatus = new InitStatus();
    }

    public void run() {
        while (gameStatus.runAble()) {
            this.gameStatus = gameStatus.next(this);
        }
    }


    public String input() {
        return Console.readLine();
    }

    public void print(final Object message) {
        System.out.print(message);
    }

    public void println(final Object message) {
        System.out.println(message);
    }

    public void initializeComputerNumber() {
        this.computer = new Computer();
    }

    public void initializeParticipantNumber(String input) {
        this.participant = new Participant(input);
    }

    public Score ruled() {
        return referee.ruled(computer.numbers(), participant.numbers());
    }
}
