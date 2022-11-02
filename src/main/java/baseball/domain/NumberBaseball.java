package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberBaseball {
    private String computerNumber;
    private String gameResult;

    public NumberBaseball() {
        createComputerNumber();
    }

    private void createComputerNumber() {
        List<Integer> result = new ArrayList<>();
        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber))
                result.add(randomNumber);
        }
        computerNumber = result.stream().map(String::valueOf)
                .collect(Collectors.joining());
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    public void compareComputerNumberWith(String userNumber) {

    }
}
