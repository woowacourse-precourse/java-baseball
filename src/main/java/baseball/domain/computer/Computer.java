package baseball.domain.computer;

import java.util.List;

public interface Computer {

    List<Integer> generateRandomNumber();

    String baseballResult(List<Integer> randomNumber, String userInput);
}
