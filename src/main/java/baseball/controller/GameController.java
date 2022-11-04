package baseball.controller;

import baseball.domain.ComNumber;
import baseball.domain.UserNumber;
import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    InputController inputController = new InputController();
    OutputController outputController = new OutputController();
    ComNumber comNumber = new ComNumber();
    public static final String RESTART = "1";
    public void makePlayers() {
        System.out.println(InputView.GAME_START);

        while(true) {
            comNumber.setComnumber(inputController.insertComNumber());
            if(!playBall(comNumber)) {
                break;
            }
            System.out.println(InputView.GAME_END);
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
                if(inputController.chooseGameEnd().equals(RESTART)) { startorend = true; }
                else { startorend = false; }
                break;
            }
        }
        return startorend;
    }
}
