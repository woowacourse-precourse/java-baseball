package baseball;

import static baseball.message.SystemMessage.*;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Referee;

import camp.nextstep.edu.missionutils.Console;
public class GameController {
    public static final String RESTART_COMMAND = "1";
    public static final String END_COMMAND = "2";

    private final Player player;
    private final Computer computer;
    private final Referee referee;

    public GameController() {
        player = new Player();
        computer = new Computer();
        referee = new Referee();

    }

    public void run() {
        do {
            readyForGame();
            startGame();
        } while (restartGame());
    }

    private void readyForGame() {

        computer.generateComputerNumber();
        referee.saveComputerNumber(computer.getComputerNumber());
    }

    private void startGame() {

        do {
            inputPlayerNumber();
            referee.judgeResult( player.getPlayerNumber() );
            System.out.println( referee.getResult() );
        } while ( !referee.isAnswer() );
    }

    private void inputPlayerNumber() {
        System.out.print( REQUEST_INPUT_NUMBER );
        player.inputNumber();
    }

    private boolean restartGame() {
        String inputCommand = inputCommandNumber();
        validateCommand(inputCommand);
        return inputCommand.equals(RESTART_COMMAND);
    }

    private String inputCommandNumber() {
        System.out.println( ANSWER_AND_GAME_OVER );
        System.out.println( REQUEST_RESTART_OR_END );
        return Console.readLine();
    }

    private void validateCommand( String command ) {
        if ( !command.equals(RESTART_COMMAND) && !command.equals(END_COMMAND) ) {
            throw new IllegalArgumentException( INVALID_COMMAND_NUMBER );
        }
    }
}
