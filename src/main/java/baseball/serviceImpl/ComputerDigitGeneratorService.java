package baseball.serviceImpl;

import baseball.service.DigitGenerator;
import baseball.util.Digits;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerDigitGeneratorService implements DigitGenerator {

    private void addNumber(List<Integer> digits, int number) {
        if (!digits.contains(number)) {
            digits.add(number);
        }
    }

    @Override
    public List<Integer> generator() {
        List<Integer> digits = new ArrayList<>();
        while (digits.size() < Digits.SIZE.getDigit()) {
            int randomNumber = Randoms.pickNumberInRange(Digits.FIRST.getDigit(),
                    Digits.LAST.getDigit());
            addNumber(digits, randomNumber);
        }
        return digits;
    }
}
