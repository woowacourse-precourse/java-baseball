package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public void TestGenerateNumber() {
        System.out.println(GenerateRandomThreeNums());
    }

    public List<Integer> GenerateRandomThreeNums() {
        List<Integer> numsOfComputer = new ArrayList<>();

        while(numsOfComputer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);

            if(!numsOfComputer.contains(randomNum)) {
                numsOfComputer.add(randomNum);
            }
        }

        return numsOfComputer;
    }
}
