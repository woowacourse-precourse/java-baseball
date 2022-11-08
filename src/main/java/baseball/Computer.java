package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> selectedNum;

    public Computer() {
        selectedNum = new ArrayList<>();
    }
    public void selectNumbers(){
        selectedNum.clear();
        while(selectedNum.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!selectedNum.contains(randomNumber)){
                selectedNum.add(randomNumber);
            }
        }
    }

    public List<Integer> getSelectedNum() {
        return selectedNum;
    }
}
