package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public Computer(){

    }

    public List<Integer> getNumber(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size()<3){
            int comRanNum = Randoms.pickNumberInRange(1,9);

            if (!computer.contains(comRanNum)){
                computer.add(comRanNum);
            }
        }

        return computer;
    }


}
