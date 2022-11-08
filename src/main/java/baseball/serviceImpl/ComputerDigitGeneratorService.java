package baseball.serviceImpl;

import baseball.service.DigitGeneratorImpl;
import baseball.util.Digits;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerDigitGeneratorService implements DigitGeneratorImpl {

    private void addNumber(List<Integer> digits, int number) {
        if (!digits.contains(number)) {
            digits.add(number);
        }
    }

    private String listToString(List<Integer> digits) {
        String regex = "[^1-9]";
        String string = digits.toString().replaceAll(regex, "");
        return string;
    }

    @Override
    public String generator() {
        List<Integer> digits = new ArrayList<>();
        while (digits.size() < Digits.SIZE.getDigit()) {
            int randomNumber = Randoms.pickNumberInRange(Digits.FIRST.getDigit(),
                    Digits.LAST.getDigit());
            addNumber(digits, randomNumber);
        }
        return listToString(digits);
    }
}
