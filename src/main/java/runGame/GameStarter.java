package runGame;

import baseball.domain.BaseBall;
import baseball.domain.UserBaseBall;
import baseball.refree.generator.GenerateGameNumber;
import baseball.refree.Referee;
import message.OutputMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class GameStarter {

    private static final int START_NUM = 1;
    private static final int EXIT_NUM = 2;
    private static int restartControlNum;

    private static OutputMessage outputMessage = new OutputMessage();

    public void start() {
        restartControlNum = 0;
        outputMessage.startMessage();
        do {
            playGame();
            restartControlNum = gameRestartController();
            if (restartControlNum == EXIT_NUM) {
                outputMessage.gameExitMessage();
            }
        } while (restartControlNum != EXIT_NUM);
    }

    private int gameRestartController() {
        outputMessage.gameRestartMessage();
        int restartControlNum = controlNumber(Console.readLine());
        outputMessage.gameRestartInputMessage(restartControlNum);
        return restartControlNum;
    }

    public static void playGame() {
        int strikeCount = 0;
        List<Integer> comBallList = new GenerateGameNumber().getGenerateNumerList();

        do {
            List<Integer> userBallList = getUserInputValue();
            BaseBall baseBall = gameResult(comBallList, userBallList);

            outputMessage.gameResultMessage(baseBall);
            strikeCount = baseBall.getStrike();

        } while (strikeCount != 3);
    }

    public static List<Integer> getUserInputValue() throws IllegalArgumentException {
        outputMessage.userInputMessage();
        UserBaseBall userBaseBall = new UserBaseBall();
        userBaseBall.setUserBallNumber(Console.readLine());

        List<Integer> userInputList = userInputToList(userBaseBall.getUserInput());
        outputMessage.userInputBaseBall(userInputList);

        return userInputList;
    }

    public static List<Integer> userInputToList(String userInput) {
        List<Integer> userInputList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            userInputList.add(Character.getNumericValue(userInput.charAt(i)));
        }
        return userInputList;
    }

    private static BaseBall gameResult(List<Integer> comBallList, List<Integer> userBallList) {
        Referee referee = new Referee();

        int strikeCount = referee.strikeCount(userBallList, comBallList);
        int ballCount = referee.ballCount(userBallList, comBallList);

        BaseBall baseBall = new BaseBall();

        baseBall.setBall(ballCount);
        baseBall.setStrike(strikeCount);

        return baseBall;
    }

    private static int controlNumber(String input) {
        return validateRestart(input);
    }

    private static int validateRestart(String input) {
        int controlNum = Integer.parseInt(input);
        if (controlNum != START_NUM && controlNum != EXIT_NUM) {
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
        return controlNum;
    }

}
