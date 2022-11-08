package baseball.controller;

import baseball.model.HintReq;
import baseball.service.ComputerService;
import baseball.service.HintProviderService;
import baseball.service.UserNumValidatorService;
import baseball.view.GameHost;
import baseball.view.Input;
import baseball.view.Output;

import java.util.List;

import static baseball.controller.BaseballController.NUM_LENGTH;

public class RunGame {
    public static void run() {
        List<Integer> computerNum = ComputerService.generator();
        HintReq hintReq;
        do {
            List<Integer> userNum = UserNumValidatorService.validator(Input.userNum());
            hintReq = HintProviderService.Hint(computerNum, userNum);
            Output.hintPrint(hintReq);
        } while (hintReq.getStrikeCount() != NUM_LENGTH);
        GameHost.successPrint();
    }
}
