package baseball;

import baseball.util.ComputerUtil;
import baseball.util.MessageUtil;
import baseball.util.UserUtil;
import baseball.validation.InputValidation;

import java.util.List;

import static baseball.constant.NumberConst.*;

/**
 * 게임을 제어하는 메인 클래스
 */
public class BaseballGame {
    private final UserUtil userUtil = new UserUtil();

    private final MessageUtil messageUtil = new MessageUtil();

    private final ComputerUtil computerUtil = new ComputerUtil();

    private final InputValidation validator = new InputValidation();

    private List<Integer> computerNums;

    public BaseballGame() {
        messageUtil.printInitMsg();
    }

    public void startGame() {
        int gameControlNum = RESTART_NUM;
        computerNums = computerUtil.generateNumber();

        while (gameControlNum == RESTART_NUM) {
            messageUtil.printInputMsg();
            String userInput = userUtil.getInputNumber();
            List<Integer> userNums = validator.validateInputNum(userInput);
        }

    }

}
