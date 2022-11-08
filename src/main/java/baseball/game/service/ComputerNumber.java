package baseball.game.service;

import baseball.game.constants.Common;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerNumber {

    public static List<Integer> generate() {
        List<Integer> computerNumber = new ArrayList<>();

        while (computerNumber.size() < Common.ESSENTIAL_LENGTH) {
            int number = Randoms.pickNumberInRange(1, 9);
            addComputerNumberDigit(computerNumber,number);
        }

        return computerNumber;
    }

    private static void addComputerNumberDigit(List<Integer> computerNumber, int number) {
        if (!computerNumber.contains(number)) {
            computerNumber.add(number);
        }
    }
}
