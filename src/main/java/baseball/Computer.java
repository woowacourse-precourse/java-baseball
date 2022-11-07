package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private final List<Integer> randomizedList;
    public Computer() {
        this.randomizedList = makeRandomizedArray();
    }

    public List<Integer> getRandomizedList() {
        return this.randomizedList;
    }

    private List<Integer> makeRandomizedArray() {
        List<Integer> RandomizedArr = new ArrayList<>();

        while(RandomizedArr.size()<3){
            int RandomNumber= Randoms.pickNumberInRange(1, 9);
            if(!RandomizedArr.contains(RandomNumber)){
                RandomizedArr.add(RandomNumber);
            }
        }
        return RandomizedArr;
    }

}
