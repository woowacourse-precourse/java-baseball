package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private List<Integer> computer = new ArrayList<>();

    public void createRandomNumber(){
        while(computer.size()<3){
            int randomNumber= Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
    }
}
