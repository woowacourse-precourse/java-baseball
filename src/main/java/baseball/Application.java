package baseball;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public List<Integer> numList = new ArrayList<>();
    public void createNum(){
        while (numList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numList.contains(randomNumber)) {
                numList.add(randomNumber);
            }
        }
    }

    public List<Integer> getNumList() {
        return numList;
    }

    public static void main(String[] args){
        Application app = new Application();

    }
}
