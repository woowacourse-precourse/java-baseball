package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerBallNumber {
    List<Integer> numbers;

    public List<Integer> getComputerBalls() {
        numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }


//    public List<Integer> setRandomNumber() {
//        Set<Integer> digitSet = new HashSet<>();
//
//        while (digitSet.size() < 3) {
//            digitSet.add(getRandomNumber());
//        }
//        numbers = new ArrayList<>(digitSet);
//        return numbers;
//    }
//
//    private int getRandomNumber() {
//        return Randoms.pickNumberInRange(1, 9);
//    }
}
