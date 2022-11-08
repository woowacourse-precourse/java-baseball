package baseball.controller;

import baseball.service.ExitStatusService;
import baseball.view.GameHost;
import baseball.view.Input;

public class BaseballController {
    public static final int NUM_LENGTH = 3;

    public static void baseball(){
        GameHost.startPrint();
        do{
            RunGame.run();
        }while (!ExitStatusService.exit(Input.exitStatus()));
    }

}
