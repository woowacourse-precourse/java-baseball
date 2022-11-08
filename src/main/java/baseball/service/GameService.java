package baseball.service;

import baseball.dao.ComputerNumber;
import baseball.dto.Number;
import baseball.vo.*;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class GameService {
    public boolean addComputerNumber() {
        return addComputerNumber(pickNumber(3));
    }
    public boolean addComputerNumber(int number) {
        Number dto = Number.getInstance();

        return dto.insert(new ComputerNumber(number));
    }

    public boolean deleteComputerNumber(int number) {
        Number dto = Number.getInstance();
        List<ComputerNumber> computerNumbers = dto.findByNumber(number);

        return dto.delete(computerNumbers.get(0));
    }

    public Scoreboard compareComputerNumberWith(int number) {
        Number dto = Number.getInstance();
        ComputerNumber computerNumber = dto.getOldest();
        TwoNumbers numbers = new TwoNumbers(computerNumber.getNumber(), number);

        return numbers.compare();
    }

    public static int pickNumber(int numberDigit) {
        int number = pickOneDigitNumber();

        for (int length = 1; length < numberDigit; length++) {
            number = appendRandomOneDigit(number);
        }

        return number;
    }

    private static int pickOneDigitNumber() {
        return Randoms.pickNumberInRange(1,9);
    }

    private static int appendRandomOneDigit(int number) {
        OneDigitNumbers oneDigitNumbers = new OneDigitNumbers(number);
        int randomOneDigitNumber = pickOneDigitNumber();

        if (oneDigitNumbers.contains(randomOneDigitNumber)) {
            return appendRandomOneDigit(number);
        }

        return number + (randomOneDigitNumber * (int) Math.pow(10, oneDigitNumbers.size()));
    }
}