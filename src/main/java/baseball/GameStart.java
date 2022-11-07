package baseball;

import java.util.List;

public class GameStart {
    RandomNumGenerator getRandomThreeNumber = new RandomNumGenerator();
    UserExitGame userExitGame = new UserExitGame();
    BallOrStrike getBallAndStrikeCount = new BallOrStrike();
    GameResult returnGameResult = new GameResult();
    NumberReader ReadNumber = new NumberReader();

    public boolean gameStart() {
        boolean result = true;
        List<String> randomNumber = getRandomThreeNumber.randomThreeNumber();

        while (result) {
            List<String> userNumber = ReadNumber.readThreeNumberFromUser();
            int strikeNumber = getBallAndStrikeCount.Cnt_Strike(randomNumber, userNumber);
            int ballNumber = getBallAndStrikeCount.ballCount(randomNumber, userNumber);
            result = returnGameResult.ResultShow(strikeNumber, ballNumber);
        }
        return userExitGame.exitGame();
    }
}