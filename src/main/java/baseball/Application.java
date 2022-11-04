package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private final int MAX_NUMBER_SIZE = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private final String RESTART = "1";
    private final String NO_RESTART = "2";

    String input = "";
    String answer = "";

    GameIO gameIO = GameIO.getInstance();
    Referee referee = new Referee();

    public void startGame() {
        gameIO.printStartLog();
        answer = generateAnswer();

        boolean isContinue = true;
        while(isContinue) {
            try {
                input = gameIO.getInput();
                if(!gameIO.isLegalInput(input)) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException illegalArgumentException) {
                gameIO.printInputExceptionLog();
                throw illegalArgumentException;
            }

            String judgement = referee.judge(input, answer);
            gameIO.printResult(judgement);

            if(judgement == Referee.THREE_STRIKE) {
                gameIO.printGameEndInfo();
                isContinue = isFinishGame();
            }
        } // end of While

        gameIO.printFinishLog();
    }

    public String generateAnswer() {
        String answer = "";

        while(answer.length() < MAX_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            String numberString = gameIO.convertIntToString(randomNumber);
            if(!answer.contains(numberString)) {
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
            } else if (input.equals(NO_RESTART)) {
                return false;
            }
        }
    }

    public void resetGame() {
        answer = generateAnswer();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.startGame();
    }
}
