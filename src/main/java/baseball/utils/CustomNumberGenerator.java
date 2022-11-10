package baseball.utils;

import static baseball.input.InputFilter.*;
import static baseball.output.OutputViewer.print;

import baseball.output.OutputViewer;

import java.util.List;

public class CustomNumberGenerator {
    public List<Integer> generate() {
        print(OutputViewer.INPUT_MESSAGE_FOR_PLAYER_NUMBERS);
        return convertToNumbers(splitToLetters(readLine()));
    }
}
