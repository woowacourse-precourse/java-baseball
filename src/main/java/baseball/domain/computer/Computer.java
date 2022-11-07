package baseball.domain.computer;

import java.util.List;

public interface Computer {

    List<Integer> generateRandomNumber();

    String checkBallAndStrike(List<Integer> randomNumber, String userInput);
}
