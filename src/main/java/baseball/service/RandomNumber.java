package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.entity.NumberBaseball.GAME_ANSWER_MAX_VALUE;

public class RandomNumber {
    public String generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < GAME_ANSWER_MAX_VALUE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        List<String> stringNumberList = computer.stream().map(String::valueOf).collect(Collectors.toList());
        String generated = String.join("", stringNumberList);
        return generated;
    }
}
