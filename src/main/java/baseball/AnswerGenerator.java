package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class AnswerGenerator {

    public static List<String> convertComputerList() {
        List<Integer> computerList = generateRandNum();
        List<String> convertedList = new ArrayList<>();
        for (Integer integer : computerList) {
            convertedList.add(String.valueOf(integer));
        }
        System.out.println(convertedList);
        return convertedList;
    }

    private static List<Integer> generateRandNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
