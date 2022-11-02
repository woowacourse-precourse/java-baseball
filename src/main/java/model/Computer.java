package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    final static int NUM_START_RANGE_RAM = 1;
    final static int NUM_END_RANGE_RAM = 9;

    List<Integer> numThreeRanOfComputerList;

    public Computer() {
        this.numThreeRanOfComputerList =new ArrayList<>();
    }

    public void creatRanNumOfComputerList(){
        while (numThreeRanOfComputerList.size() < 3) {
            int randomNumber = getOneRanNumAnInt();
            if (!numThreeRanOfComputerList.contains(randomNumber)) {
                numThreeRanOfComputerList.add(randomNumber);
            }
        }
    }

    public int getOneRanNumAnInt() {
        return Randoms.pickNumberInRange(NUM_START_RANGE_RAM, NUM_END_RANGE_RAM);
    }
}
