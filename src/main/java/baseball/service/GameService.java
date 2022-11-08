package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.NUMBER_LIMIT;

public class GameService {

    public static List<Integer> makeComputerNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < NUMBER_LIMIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> makeUserNumber(String input) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            int nextNumber = (input.charAt(i)) - '0';

            if (nextNumber != ' ' - '0') {
                list.add(nextNumber);
            }
        }

        return list;
    }

    public boolean compareAnswer(List<Integer> computer, List<Integer> user) {

        return false;
    }

    public void printHint(int strikeCount, int ballCount) {

    }

}