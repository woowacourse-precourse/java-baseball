package baseball;

import baseball.db.DB;
import baseball.db.Data;
import baseball.domain.Computer;
import baseball.domain.Referee;
import baseball.domain.User;
import baseball.util.GameInput;
import baseball.util.GameOutput;

import java.time.LocalDateTime;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private final String RESTART = "1";
    private final String NO_RESTART = "2";

    int tryCount = 0;

    GameInput gameInput = GameInput.getInstance();
    GameOutput gameOutput = GameOutput.getInstance();
    User user = new User();
    Computer computer = new Computer();
    Referee referee = Referee.getInstance();
    DB database = DB.getInstance();

    public void startGame() throws IllegalArgumentException {
        gameOutput.printStartLog();
        computer.generateAnswer();

        boolean isContinue = true;
        while (isContinue) {
            String input = gameInput.getInput();
            user.setInput(input);
            gameInput.isLegalInput(user.getNumber());

            tryCount++;

            String judgement = referee.judge(user.getNumber(), computer.getAnswer());
            gameOutput.printResult(judgement);

            if (referee.isThreeStrike(judgement)) {
                gameOutput.printGameEndInfo();
                isContinue = isFinishGame();
            }
        } // end of While

        finishGame();
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
        computer.generateAnswer();
        database.addData(new Data(LocalDateTime.now(), tryCount));
        tryCount = 0;
    }

    public void finishGame() {
        database.addData(new Data(LocalDateTime.now(), tryCount));
        gameOutput.printFinishLog();
        database.showAllData();
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
