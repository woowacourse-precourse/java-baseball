package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class PlayBaseballGame {
    private Integer strike;
    private Integer ball;
    private List<Integer> RandomNum;
    private List<Integer> UserNum;

    public void RandomNum(){
        while(RandomNum.size() < 3){
            int num = Randoms.pickNumberInRange(1,9);
            if (!RandomNum.contains(num)){
                RandomNum.add(num);
            }
        }
    }

    public void CorrectNum(){

    }

}
