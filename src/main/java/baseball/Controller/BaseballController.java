package baseball.Controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BaseballController {
    private static final int NUMBER_SIZE=3;

    //게임 시작
    public void startBaseballGame() {

    }

    //랜덤 숫자 생성
    private List<String> createRandomNumber(){
        List<String> computerNumber = new ArrayList<>();

        for(int i=0; i<NUMBER_SIZE; i++) {
            computerNumber.add(Integer.toString(Randoms.pickNumberInRange(1, 9)));
        }

        return computerNumber;
    }


}
