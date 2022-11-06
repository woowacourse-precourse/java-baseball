package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> randomNumber;

    public Computer() {
        randomNumber = GenerateRandomThreeNumber();
    }

    private List<Integer> GenerateRandomThreeNumber() {
        List<Integer> randomNumList = new ArrayList<>();

        while(randomNumList.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);

            if(!randomNumList.contains(randomNum)) {
                randomNumList.add(randomNum);
            }
        }

        return randomNumList;
    }
}
