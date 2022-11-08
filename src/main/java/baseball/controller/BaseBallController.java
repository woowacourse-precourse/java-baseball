package baseball.controller;

import baseball.view.AllStrikeView;
import baseball.model.Computer;
import baseball.model.Referee;
import baseball.view.OutputScoreView;
import baseball.view.PlayerInputView;
import baseball.vo.Player;
import baseball.vo.ScoreBoard;

public class BaseBallController {

    public static void startGame()
    {
        Referee referee = new Referee(Computer.computerSelectNumbers());
        while (referee.isAllStrike() == false)
        {
            Player player = PlayerInputView.selectNumbers();
            ScoreBoard scoreBoard = referee.giveScore(player);
            OutputScoreView.outputScoreBoard(scoreBoard);
        }
        if (AllStrikeView.replayGame())
            startGame();
    }
}
