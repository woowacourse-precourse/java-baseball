package baseball.service;

import baseball.utils.RandomNumberGenerator;

import java.util.List;

public class GameSettingService {
    private final int RIGHT_LIST_SIZE = 3;
    private RandomNumberGenerator randomNumberGenerator;

    public GameSettingService() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    public List<Integer> generateRandomThreeNumbers() {
        List<Integer> computerAnswerNumbers = randomNumberGenerator.generateRandomNumberList();
        long uniqueNumbers = computerAnswerNumbers.stream()
                .distinct()
                .count();
        if (uniqueNumbers != RIGHT_LIST_SIZE) {
            generateRandomThreeNumbers();
        }
        return computerAnswerNumbers;
    }
}
