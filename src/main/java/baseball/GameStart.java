package baseball;

import java.util.List;

public class GameStart {
    GetRandomThreeNumber getRandomThreeNumber = new GetRandomThreeNumber();
    ExitGame exitGame = new ExitGame();
    GetBallAndStrikeCount getBallAndStrikeCount = new GetBallAndStrikeCount();
    ReturnGameResult returnGameResult = new ReturnGameResult();
    ReadNumber ReadNumber = new ReadNumber();

    public boolean gameStart() {
        boolean result = true;
        List<String> randomNumber = getRandomThreeNumber.randomThreeNumber();

        while (result) {
            List<String> userNumber = ReadNumber.readThreeNumberFromUser();
            int strikeNumber = getBallAndStrikeCount.strikeCount(randomNumber, userNumber);
            int ballNumber = getBallAndStrikeCount.ballCount(randomNumber, userNumber);
            result = returnGameResult.printResult(strikeNumber, ballNumber);
        }
        return exitGame.exitGame();
    }
}
