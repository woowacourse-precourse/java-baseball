package baseball.service;

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
}
