package utils;

import baseball.digit.Digit;
import baseball.game.GameMessage;
import camp.nextstep.edu.missionutils.Console;
import baseball.validator.RetryValidator;
import baseball.validator.TrialValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputUtil {

    private InputUtil(){
    }

    public static List<Digit> inputTryNumber(){
        System.out.print(GameMessage.TRY_CORRECT.getMessage());
        String input = Console.readLine();
        TrialValidator.validate(input);
        return convertDigit(input);
    }

    public static List<Digit> convertDigit(String input){
        List<String> characterList = Arrays.asList(input.split(""));
        List<Digit> newDigitList = new ArrayList<>(3);
        for(int i = 0; i < characterList.size(); i++) {
            newDigitList.add(new Digit(i, Integer.valueOf(characterList.get(i))));
        }
        return newDigitList;
    }
    public static List<Digit> convertDigit(List<Integer> inputIntegerList){
        List<Digit> newDigitList = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            newDigitList.add(new Digit(i, inputIntegerList.get(i)));
        }
        return newDigitList;
    }

    public static Boolean inputRetryNumber(){
        System.out.print(GameMessage.RETRY_GAME.getMessage());
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
