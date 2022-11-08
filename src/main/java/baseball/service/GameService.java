package baseball.service;

import baseball.domain.GameResult;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GameService {

    public List<Integer> makeRandomNumbers() {
        List<Integer> answerNumbers = new ArrayList<>();
        while (answerNumbers.size() < 3) {
            int randNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumbers.contains(randNumber))    answerNumbers.add(randNumber);
        }
        return answerNumbers;
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

    public boolean isRetryGame(String input) {
        input = input.trim();
        if(!(input.equals("1") || input.equals("2")))
            throw new IllegalArgumentException();
        return input.equals("1");
    }
}
