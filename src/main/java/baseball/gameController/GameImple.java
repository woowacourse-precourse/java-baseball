package baseball.gameController;

import baseball.computer.GameComputer;
import baseball.gameController.view.GameView;
import baseball.player.PlayerInput;
import baseball.utils.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import static baseball.gameController.constant.MagicNumber.END;
import static baseball.gameController.constant.MagicNumber.RENEW;

public class GameImple implements Game {

    private PlayerInput playerInput;
    private GameComputer gameComputer;

    public GameImple(PlayerInput playerInput, GameComputer gameComputer) {
        this.playerInput = playerInput;
        this.gameComputer = gameComputer;
    }

    @Override
    public void play() {
        gameComputer.autoSetNumbers();

        do {
            GameView.printInputNotice();

            playerInput.setNumbers(Console.readLine());
            String hintMessage = gameComputer.printHintForInput(playerInput.getNumbers());

            GameView.printHint(hintMessage);
        } while (gameComputer.isNotGameEndCase(playerInput.getNumbers()));

        GameView.printWinnerNotice();

        choiceRenewOrEnd(Console.readLine());
    }

    private void choiceRenewOrEnd(String code) {
        InputValidator.validateChoiceCode(code);
        if (code.equals(RENEW)) play();
        else if (code.equals(END)) ; //아무 행동도 취할 필요 없다
    }


}
