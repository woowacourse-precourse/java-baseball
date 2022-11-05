package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Integer strike;
    private Integer ball;
    private List<Integer> comNum;
    private List<Integer> userNum;

    public Game(){
        init();
    }

    //함수 호출하자마자 랜덤값 세자리 생성
    public void init(){
        comNum = new ArrayList<>();
        for(int i =0; i<3;){
            int num = Randoms.pickNumberInRange(1,9);
            if(!comNum.contains(num)){
                comNum.add(num);
                i++;
            }
        }
    }
}
