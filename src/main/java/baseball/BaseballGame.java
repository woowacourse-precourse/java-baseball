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

            ResultCount result = compareNumber(computerNums, userNums);
            int ball = result.ballCount;
            int strike = result.strikeCount;
            messageUtil.printResultMsg(ball, strike);
        }

    }

    public ResultCount compareNumber(List<Integer> computerNums, List<Integer> userNums) {
        int ball = 0, strike = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            int computerNum = computerNums.get(i);
            int userNum = userNums.get(i);

            if (computerNum == userNum) {
                strike++;
                continue;
            }

            if (computerNums.contains(userNum)) {
                ball++;
            }
        }

        return new ResultCount(ball, strike);
    }

    private static class ResultCount {
        int ballCount;
        int strikeCount;

        public ResultCount(int ballCount, int strikeCount) {
            this.ballCount = ballCount;
            this.strikeCount = strikeCount;
        }
    }
}
