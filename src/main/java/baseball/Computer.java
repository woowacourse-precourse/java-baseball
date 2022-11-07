package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> randomNumList = new ArrayList<>();

    public Computer() {
        setRandomNumList();
    }

    public void setRandomNumList (){
        while(randomNumList.size() < 3){
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if(!randomNumList.contains(randomNum)) {
                randomNumList.add(randomNum);
            }
        }
    }
}
