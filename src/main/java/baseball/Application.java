package baseball;

import baseball.computer.ComputerFunction;
import baseball.game.GameFunction;
import baseball.user.UserFunction;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final UserFunction user = new UserFunction();
    private static final ComputerFunction com = new ComputerFunction();
    private static final GameFunction game = new GameFunction();
    private static List<Integer> computerNumList;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String userInput;
        boolean playingGames = false;
        boolean gameAgain = true;

        while (gameAgain) {
            int ballScore = 0;
            int strikeScore = 0;

            if (!playingGames) {
                computerNumList = com.createRandomList();
                playingGames = true;
            }

            game.printInputRequestMsg();
            userInput = user.requestInputData();
            List<Integer> userNumList = user.createUserList(userInput);

            strikeScore = game.userNumListAndComNumListCheckStrikeCount(userNumList, computerNumList);
            ballScore = game.userNumListAndComNumListCheckBallCount(userNumList, computerNumList) - strikeScore;

            game.printScoreMsg(strikeScore, ballScore);

            if (strikeScore == 3) {
                userInput = user.requestInputData();
                gameAgain = game.again(userInput);
                playingGames = false;
            }
        }
    }
}
