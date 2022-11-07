package baseball.gameclient;

import baseball.gameconsole.ClientConsole;
import baseball.generator.NumberPicker;
import baseball.referee.Referee;
import baseball.validator.InputValidator;

public class GameClient {

    public static final int NEXT_TRY = 0;
    public static final int RESTART = 1;
    public static final int GAME_END = 2;
    private final ClientConsole clientConsole;
    private final NumberPicker numberPicker;
    private final InputValidator inputValidator;
    private final Referee referee;
    private String userBall;
    private String computerBall;

    public GameClient(ClientConsole clientConsole, NumberPicker numberPicker,
        InputValidator inputValidator, Referee referee) {
        this.clientConsole = clientConsole;
        this.numberPicker = numberPicker;
        this.inputValidator = inputValidator;
        this.referee = referee;
        setComputerBall();
    }

    private void setComputerBall() {
        this.computerBall = numberPicker.pickRandomThreeBalls();
    }

    public void start() {
        clientConsole.outStartGameSentence();
        onGame();
    }

    private void onGame() {
        receiveUserBall();
        int nextFlow = tellScoreToUser();
        if (nextFlow == NEXT_TRY) {
            onGame();
            return;
        }

        if (nextFlow == RESTART) {
            setComputerBall();
            start();
            return;
        }

        if (nextFlow == GAME_END) {
            clientConsole.outEndGame();
            return;
        }
    }

    private void receiveUserBall() {
        clientConsole.outRequestInputNumber();
        String userInput = clientConsole.readLine();
        inputValidator.verifyUserInGameInput(userInput);
        userBall = userInput;
    }

    private int tellScoreToUser() {
        clientConsole.outResultScoreSentence(referee.evaluate(userBall, computerBall));

        if (isCorrectAnswer()) {
            return chooseEndingCredit();
        }
        return NEXT_TRY;
    }

    private boolean isCorrectAnswer() {
        return computerBall.equals(userBall);
    }

    private int chooseEndingCredit() {
        clientConsole.outEndingSentence();
        String restartOrEndInput = clientConsole.readLine();
        inputValidator.verifyRestartOrEndInput(restartOrEndInput);

        if (isRestart(restartOrEndInput)) {
            return RESTART;
        }

        return GAME_END;
    }

    private boolean isRestart(String restartOrEndInput) {
        return restartOrEndInput.equals("1");
    }
}
