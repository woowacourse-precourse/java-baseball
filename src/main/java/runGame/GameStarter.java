package runGame;

import baseball.domain.UserBaseBall;
import baseball.generator.GenerateGameNumber;
import baseball.refree.Referee;
import message.OutputMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class GameStarter {

    private final int START_NUM = 1;
    private final int EXIT_NUM = 2;

    private static OutputMessage outputMessage = new OutputMessage();

    public void GameStarter() {
    }

    public void start() {
        // 시작 메시지 출력
        outputMessage.startMessage();
        // 게임 시작
        playGame();
    }

    public static void playGame() {
        int strikeCount = 0;
        // 컴퓨터 난수 생성
        List<Integer> comBallList = new GenerateGameNumber().getGenerateNumerList();

        do {
            // 사용자 입력 생성
            List<Integer> userBallList = getUserInputValue();

            strikeCount = gameResult(comBallList, userBallList);

            // isStrikeOut();
        } while(strikeCount != 0);
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

    private static int gameResult(List<Integer> comBallList, List<Integer> userBallList) {
        Referee referee = new Referee();
        int strikeCount = referee.strikeCount(userBallList, comBallList);
        int ballCount = referee.strikeCount(userBallList, comBallList);


        return 0;
    }

}
