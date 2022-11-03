package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    public static List<Integer> randomNumber(){
        List<Integer> randomNumbers = new ArrayList<>();
        while(randomNumbers.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!randomNumbers.contains(randomNumber)){
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;

    }



}


