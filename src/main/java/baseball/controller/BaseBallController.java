package baseball.controller;

public class BaseBallController {

    public static void startGame()
    {
        Referee referee = new Referee(computerSelectedNumber);

        while (referee.checkAllStricke())
        {
            // 1. 유저 Input을 받아라.
            // 2. 유저의 ball, strike 갯수를 확인하라.
            // 3. 게임 결과를 화면에 출력하라.
        }
        if (AllStrikeView.replayGame())
            startGame();
    }
}
