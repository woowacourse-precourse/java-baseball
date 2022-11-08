package iosystem;

import baseball.GameMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputSystem {

    private InputSystem(){
    }

    public static List<Integer> inputTryNumber(){
        System.out.print(GameMessage.TRY_CORRECT);
        String input = Console.readLine();
        TrialValidator.validate(input);
        List<String> characterList = Arrays.asList(input.split(""));
        return characterList.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    public static boolean inputRetryNumber(){
        System.out.print(GameMessage.RETRY_GAME);
        String input = Console.readLine();
        RetryValidator.validate(input);
        int isRetrySignalNumber = Integer.parseInt(input);
        return isRetrySignal(isRetrySignalNumber);
    }

    private static boolean isRetrySignal(int isRetrySignal) {
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
