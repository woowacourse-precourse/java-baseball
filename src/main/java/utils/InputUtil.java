package utils;

import baseball.digit.Digit;
import baseball.validator.RetryValidator;
import baseball.validator.TrialValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static utils.ConvertUtil.convertDigit;
import static utils.OutputUtil.printRetryGame;
import static utils.OutputUtil.printTryCorrect;

public class InputUtil {

    private InputUtil(){
    }

    public static List<Digit> inputTryNumber(){
        printTryCorrect();
        String input = Console.readLine();
        TrialValidator.validate(input);
        return convertDigit(input);
    }



    public static Boolean inputRetryNumber(){
        printRetryGame();
        String input = Console.readLine();
        RetryValidator.validate(input);
        int isRetrySignalNumber = Integer.parseInt(input);
        return isRetrySignal(isRetrySignalNumber);
    }

    private static Boolean isRetrySignal(int isRetrySignal) {
        return isRetrySignal == RetrySignal.RETRY_TRUE.getSignal();
    }
    private enum RetrySignal {

        RETRY_TRUE(1),
        RETRY_FALSE(2),
        ;
        private final int signal;

        RetrySignal(int signal) {
            this.signal = signal;
        }
        public int getSignal() {
            return signal;
        }
    }
}
