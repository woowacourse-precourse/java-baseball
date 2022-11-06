package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int createRandomNum(){

        int randomNum =0;
        List<Integer> numList = new ArrayList<>();
        while(numList.size()<3){
            int newNum = Randoms.pickNumberInRange(1,9);
            if(!numList.contains(newNum)){
                numList.add(newNum);
                randomNum = randomNum*10+newNum;
            }
        }
        return randomNum;

    }
}
