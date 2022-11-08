package baseball.service;

import baseball.domain.GameResult;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GameService {

    public List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public String validateUserInput(String userInput) {
        userInput = userInput.trim();

        boolean matches = userInput.matches("[1-9]{3}");
        Set<String> collect = Arrays.asList(userInput.split("")).stream().collect(Collectors.toSet());

        if(!matches || collect.size() != 3)
            throw new IllegalArgumentException();
        else
            return userInput;
    }

    public GameResult makeGameResult(String userInput, List<Integer> answerNumbers) {
        int strike = 0, ball = 0;

        List<Integer> inputNumber = Arrays.asList(userInput.split("")).stream().map(Integer::parseInt).collect(Collectors.toList());
        for(int i = 0; i < 3; i++) {
            if (answerNumbers.get(i).equals(inputNumber.get(i))) strike++;
            else if (inputNumber.get(i).equals(answerNumbers.get((i + 1) % 3)) || inputNumber.get(i) == answerNumbers.get((i + 2) % 3)) ball++;
        }
        return new GameResult(strike, ball);
    }
}
