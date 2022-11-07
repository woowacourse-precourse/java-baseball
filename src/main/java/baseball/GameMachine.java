package baseball;

import baseball.enums.Announcement;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameMachine {
    public List<Integer> generateThreeDiffDigit() {
        List<Integer> integerList = new ArrayList<>();
        while (integerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!integerList.contains(randomNumber)) {
                integerList.add(randomNumber);
            }
        }
        return integerList;
    }

    public List<Integer> askInputThreeDiffDigit(Gamer gamer) {
        Announcement.INPUT_NUMBER.printAnnouncement();
        String input = gamer.inputThreeDiffDigit();
        return convertIntegerList(input);
    }

    private List<Integer> convertIntegerList(String str) {
        List<Integer> integerList = new ArrayList<>();

        String[] strArr = str.split("");
        for (String element:
                strArr) {
            Integer convertedElement = Integer.parseInt(element);
            integerList.add(convertedElement);
        }
        return integerList;
    }
}
