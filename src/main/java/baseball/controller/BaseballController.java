package baseball.controller;

import baseball.io.option.ReGameOption;
import baseball.io.Input;
import baseball.io.Output;
import baseball.message.OutPutMessage;
import baseball.service.BaseballService;

import java.util.List;

public class BaseballController {

    private final static Input input = new Input();
    private final static Output output = new Output();
    private final BaseballService baseballservice;

    public BaseballController() {
        this.baseballservice = new BaseballService();
    }

    public void run() {
        do {
            baseballservice.initBaseballGame(); // 컴퓨터의 랜덤 수 생성
            output.printMessageWithEnter(OutPutMessage.START_GAME);
            startBaseballGame();
        }while(decideReGameOrEndGame());
    }

    private void startBaseballGame() {
        do {
            output.printMessageWithoutEnter(OutPutMessage.ENTER_USER_NUM);
            List<Integer> userNumber = input.inputUserNumber();
            String result = baseballservice.playBaseballGame(userNumber);
            output.printMessageWithEnter(result);
        }while(isNotGameClear());
    }

    private boolean decideReGameOrEndGame() {
        output.printMessageWithEnter(OutPutMessage.ASK_TRY_AGAIN);
        String result = input.inputReGameNumber();
        ReGameOption reGameOption = ReGameOption.checkValidateOption(result);
        return ReGameOption.reGameOrEndGame(reGameOption);
    }

    private boolean isNotGameClear() {
        if(baseballservice.isGameClear()) {
            output.printMessageWithEnter(OutPutMessage.GAME_CLEAR);
            return false;
        }
        return true;
    }

}
