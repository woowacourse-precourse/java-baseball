package baseball.mvc.controller;

import baseball.domain.game.GameComputer;
import baseball.domain.game.GameResult;
import baseball.domain.number.GameNumbers;
import baseball.mvc.model.Model;
import baseball.mvc.structure.consts.GameModelKeyConst;
import baseball.util.GameStatus;

public class GamePlayController {

    public GameStatus process(GameComputer computer, GameNumbers playerAnswer, Model model) {
        GameResult gameResult = computer.calculateGameResult(playerAnswer);

        model.addAttribute(GameModelKeyConst.GAME_RESULT_KEY, gameResult);

        if (gameResult.isCorrect()) {
            return GameStatus.END;
        }
        return GameStatus.PLAY;
    }
}
