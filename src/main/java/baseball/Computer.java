package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {


    public String descriptionAndInput(String description) {
        System.out.print(description);

        return Console.readLine();
    }

    public List<Integer> makeRandomizedArray() {
        List<Integer> RandomizedArr = new ArrayList<>();
        while(RandomizedArr.size() <3){
            int randomizedNumber = Randoms.pickNumberInRange(1, 9);
            if(!RandomizedArr.contains(randomizedNumber)){
                RandomizedArr.add(randomizedNumber);
            }
        }
        return RandomizedArr;
    }

    public void printStartJavaBaseball() {

        System.out.println("숫자 야구 게임을 시작합니다");
    }
}
