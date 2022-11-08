package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.Message.*;

public class Application {

    private final static int MAX_SIZE = 3;

    private final static ComputerService computerService = new ComputerServiceImpl();
    private final static BaseballGameService baseballGameService = new BaseballGameServiceImpl();

    public static void main(String[] args) {

        showMessage(GAME_START);
        User user = createUser();

        while (isNotEnd(user)) {

            if (isAnswerEmpty(user)) {
                createNewAnswer(user);
            }

            enterNumber(user);
            showGameResult(user);

            endGame(user);
        }
    }

    private static User createUser() {
        return new User();
    }

    private static boolean isNotEnd(User user) {
        return !user.isEnd();
    }

    private static void endGame(User user) {
        if (user.isEnd()) {
            showMessage(GAME_END);
            showMessage(RESTART_OR_EXIT);
            String request = Console.readLine();
            requestCheck(user, request);
        }
    }

    private static void requestCheck(User user, String request) {
        if (request.equals("1")) {
            user.reset();
        } else if (!request.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    private static void showGameResult(User user) {
        baseballGameService.run(user);
        String resultMessage = baseballGameService.getResultMessage(user);
        showMessage(resultMessage);

        if (isCorrectAnswer(user)) {
            user.correctAnswer();
        }
    }

    private static void enterNumber(User user) {
        showMessage(REQUEST_NUMBER);
        String number = Console.readLine();
        user.inputNumber(number);
    }

    private static void showMessage(String message) {
        System.out.println(message);
    }

    private static boolean isAnswerEmpty(User user) {
        return user.getAnswers().isEmpty();
    }

    private static void createNewAnswer(User user) {
        List<Integer> answer = computerService.createComputerNumber();
        user.insertAnswer(answer);
    }

    private static boolean isCorrectAnswer(User user) {
        return user.getStrike() - user.getBall() == MAX_SIZE;
    }
}
