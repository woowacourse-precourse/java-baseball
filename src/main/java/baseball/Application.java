package baseball;

import baseball.DB.DB;
import baseball.DB.Data;
import baseball.Util.GameInput;
import baseball.Util.GameOutput;
import camp.nextstep.edu.missionutils.Randoms;

import java.time.LocalDateTime;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private final int MAX_NUMBER_SIZE = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private final String RESTART = "1";
    private final String NO_RESTART = "2";

    String userInput = "";
    String answer = "";
    int tryCount = 0;

    GameInput gameInput = GameInput.getInstance();
    GameOutput gameOutput = GameOutput.getInstance();
    Referee referee = Referee.getInstance();
    DB database = DB.getInstance();

    public void startGame() throws IllegalArgumentException {
        gameOutput.printStartLog();
        answer = generateAnswer();

        boolean isContinue = true;
        while (isContinue) {
            userInput = gameInput.getInput();
            gameInput.isLegalInput(userInput);

            tryCount++;

            String judgement = referee.judge(userInput, answer);
            gameOutput.printResult(judgement);

            if (referee.isThreeStrike(judgement)) {
                gameOutput.printGameEndInfo();
                isContinue = isFinishGame();
            }
        } // end of While

        database.addData(new Data(LocalDateTime.now(), tryCount));
        gameOutput.printFinishLog();
        database.showAllData();
    }

    public String generateAnswer() {
        String answer = "";

        while (answer.length() < MAX_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            String numberString = gameInput.convertIntToString(randomNumber);
            if (!answer.contains(numberString)) {
                answer += numberString;
            }
        }
        return answer;
    }

    public boolean isFinishGame() {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = readLine();

            if (input.equals(RESTART)) {
                resetGame();
                return true;
            }
            if (input.equals(NO_RESTART)) {
                return false;
            }
        }
    }

    public void resetGame() {
        answer = generateAnswer();
        database.addData(new Data(LocalDateTime.now(), tryCount));
        tryCount = 0;
    }

    public static void main(String[] args) {
        Application application = new Application();
        try {
            application.startGame();
        } catch (IllegalArgumentException illegalArgumentException) {
            GameOutput.printInputExceptionLog();
            throw illegalArgumentException;
        }
    }
}
