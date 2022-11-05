package baseball;

import java.util.List;

public class ProcessService {

    public void validateGameInput(String input) throws IllegalArgumentException {
        if (input.length() > 3) throw new IllegalArgumentException();

        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            if (digit < '1' || digit > '9') throw new IllegalArgumentException();
        }
    }

}
