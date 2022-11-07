package baseball.mvc.controller;

import baseball.domain.game.GameComputer;
import baseball.mvc.model.Model;
import baseball.mvc.structure.consts.GameModelKeyConst;
import baseball.util.GameStatus;

public class GameSettingsController {

    public GameStatus process(Model model) {
        model.addAttribute(GameModelKeyConst.COMPUTER_KEY, new GameComputer());

        return GameStatus.PLAY;
    }
}
