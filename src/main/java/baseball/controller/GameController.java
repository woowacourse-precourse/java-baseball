package baseball.controller;

import baseball.model.ComNumber;
import baseball.model.UserNumber;
import baseball.utils.InputValidation;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    InputController inputController = new InputController();
    OutputController outputController = new OutputController();
    ComNumber comNumber = new ComNumber();
    public void makePlayers() {
        System.out.println(InputView.GAME_START);

        while(true) {
            comNumber.setComnumber(inputController.insertComNumber());
            if(!playBall(comNumber)) {
                break;
            }
            System.out.println(OutputView.GAME_END);
            System.out.println(InputView.RESTART_GAME);
        }
    }

    public boolean playBall(ComNumber comNumber) {
        boolean startorend = false;
        UserNumber userNumber = new UserNumber();
        while(true) {
            System.out.print(InputView.INSERT_NUMBER);
            List<Integer> remusernumber = new ArrayList<>();
            remusernumber = inputController.insertUserNumber();
            userNumber.setUsernumber(remusernumber);
            if(outputController.gameResult(comNumber,userNumber)) {
                System.out.println(InputView.RESTART_GAME);
                if(inputController.chooseGameEnd().equals(InputValidation.ONE)) { startorend = true; }
                else { startorend = false; }
                break;
            }
        }
        return startorend;
    }
}
