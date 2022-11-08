package baseball.domain.manager;

import baseball.constant.GameMessage;
import baseball.constant.GameStatus;
import baseball.domain.computer.Computer;
import baseball.domain.user.User;
import baseball.util.BallCount;

import java.io.IOException;

public class NumberBaseBallManager {

    private GameStatus status = GameStatus.NOT_INITIALIZED;
    private final User user = new User();

    public void validate(String input) throws IllegalArgumentException {
        GameStatus currentStatus = getStatus();
        if (currentStatus == GameStatus.IN_GAME) {
            validateGuess(input);
            return;
        }

        if (currentStatus == GameStatus.PENDING) {
            validateAnswerContinueOrNot(input);
        }
    }

    public void validateAnswerContinueOrNot(String input)
            throws IllegalArgumentException {
        if (input.length() != 1) {
            throw new IllegalArgumentException();
        }

        int val = input.charAt(0) - '0';
        if (val != 1 && val != 2) {
            throw new IllegalArgumentException();
        }
    }

    public void validateGuess(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        int sum = 0;
        boolean[] visit = new boolean[10];

        for (int i = 0; i < 3; i++) {
            int digit = getDigit(input.charAt(i));
            checkDuplicate(digit,visit);
            sum = sum*10 + digit;
        }
    }

    private void checkDuplicate(int digit,boolean[] visit) throws IllegalArgumentException {
        if (visit[digit]) throw new IllegalArgumentException();
        visit[digit] = true;
    }

    private int getDigit(char character) throws IllegalArgumentException {
        int digit = character - '0';
        if (digit<=0 || digit>=10) throw new IllegalArgumentException();

        return digit;
    }

    public void checkResult(BallCount result){
        int strike = result.getStrike();

        if (strike==3) {
            status = GameStatus.PENDING;
        }
    }

    public void start() throws IOException {
        System.out.println(selectMessage());

        while (status!=GameStatus.FINISHED) {
            Computer computer = initComputer();

            playGame(computer);

            determineToContinue();
        }
    }

    private Computer initComputer() {
        Computer computer = new Computer();
        computer.initialize();
        status = GameStatus.INITIALIZED;

        return computer;
    }
    public void playGame(Computer computer) throws IOException {
        status = GameStatus.IN_GAME;

        while (status==GameStatus.IN_GAME) {
            System.out.print(selectMessage());
            communicate(computer);
        }

        System.out.println(GameMessage.GAME_OVER.getValue());
    }

    private void communicate(Computer computer)
            throws IOException,IllegalArgumentException {
        String userAnswer = user.answer();
        validate(userAnswer);
        BallCount result = computer.calculateBallCount(userAnswer);
        System.out.println(selectResultOutput(result));
        checkResult(result);
    }

    private void determineToContinue() throws IOException {
        System.out.println(selectMessage());
        String responseToContinue = user.answer();
        validate(responseToContinue);
        determineToContinue(Character.getNumericValue(responseToContinue.charAt(0)));
    }

    public void determineToContinue(int response) {
        if( response == 1 ) {
            status=GameStatus.IN_GAME;
            return;
        }
        status=GameStatus.FINISHED;
    }

    public String selectMessage() {
        if (getStatus() == GameStatus.NOT_INITIALIZED) {
            return GameMessage.START_GAME.getValue();
        }
        if (getStatus() == GameStatus.IN_GAME) {
            return GameMessage.QUESTION_TO_GUESS_NUMBER.getValue();
        }
        if (getStatus() == GameStatus.PENDING) {
            return GameMessage.QUESTION_TO_CONTINUE.getValue();
        }
        return "";
    }

    public String selectResultOutput(BallCount result) {
        int ball = result.getBall();
        int strike = result.getStrike();
        
        if (ball == 0 && strike == 0) {
            return "낫싱\n";
        }

        StringBuilder sb = new StringBuilder();
        
        if (result.getBall() > 0) {
            sb.append(result.getBall()).append(GameMessage.BALL.getValue());
        }

        if (result.getStrike() > 0) {
            sb.append(result.getStrike()).append(GameMessage.STRIKE.getValue());
        }
        return sb.toString();
   }

    public GameStatus getStatus(){
        return this.status;
    }
}
