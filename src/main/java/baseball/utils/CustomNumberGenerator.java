package baseball.utils;

import static baseball.input.InputFilter.*;
import static baseball.message.Message.printMessage;

import baseball.message.Message;

import java.util.List;

public class CustomNumberGenerator {
    public List<Integer> generate() {
        printMessage(Message.INPUT_MESSAGE_FOR_PLAYER_NUMBERS);
        return convertToNumbers(splitToLetters(readLine()));
    }
}
