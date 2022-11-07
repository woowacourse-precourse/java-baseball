package baseball;

import java.util.HashMap;
import java.util.Map;

public class ThreeNumberRepository {

    private static final Map<String, ThreeNumber> numbers = new HashMap<>();

    public ThreeNumber save(String role, ThreeNumber threeNumber) {
        numbers.put(role, threeNumber);
        return threeNumber;
    }

    public ThreeNumber findByRole(String role) {
        return numbers.get(role);
    }

    public int countStrike() {
        ThreeNumber computerNumber = findByRole("computer");
        ThreeNumber playerNumber = findByRole("player");
        int count = 0;
        if (computerNumber.getNumber1() == playerNumber.getNumber1()) {
            count += 1;
        }
        if (computerNumber.getNumber2() == playerNumber.getNumber2()) {
            count += 1;
        }
        if (computerNumber.getNumber3() == playerNumber.getNumber3()) {
            count += 1;
        }
        return count;
    }

    public int countBall() {
        ThreeNumber computerNumber = findByRole("computer");
        ThreeNumber playerNumber = findByRole("player");
        int count = 0;
        if ((computerNumber.getNumber1() == playerNumber.getNumber2()) || (computerNumber.getNumber1()
                == playerNumber.getNumber3())) {
            count += 1;
        }
        if ((computerNumber.getNumber2() == playerNumber.getNumber1()) || (computerNumber.getNumber2()
                == playerNumber.getNumber3())) {
            count += 1;
        }
        if ((computerNumber.getNumber3() == playerNumber.getNumber1()) || (computerNumber.getNumber3()
                == playerNumber.getNumber2())) {
            count += 1;
        }
        return count;
    }
}
