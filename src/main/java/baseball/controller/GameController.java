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
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    ComNumber comNumber = new ComNumber();
    public void makePlayers() {
        inputView.gameStart();

        while(true) {
            comNumber.setComnumber(inputController.insertComNumber());
            System.out.println(comNumber.getComnumber());
            if(!playBall(comNumber)) {
                break;
            }
        }
    }

    public boolean playBall(ComNumber comNumber) {
        boolean startorend = false;
        UserNumber userNumber = new UserNumber();
        while(true) {
            inputView.insertNumber();
            List<Integer> remusernumber = new ArrayList<>();
            remusernumber = inputController.insertUserNumber();
            userNumber.setUsernumber(remusernumber);
            if(outputController.gameResult(comNumber,userNumber)) {
                outputView.gameEnd();
                inputView.restartGame();
                if(inputController.chooseGameEnd().equals(InputValidation.ONE)) { startorend = true; }
                else { startorend = false; }
                break;
            }
        }
        return startorend;
    }
}
