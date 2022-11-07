package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> ls = getRandomThreeNumbers();
        System.out.println(ls);
    }

    public static List<Integer> getRandomThreeNumbers(){
        List<Integer> numberList = new ArrayList<>();
        while(numberList.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!numberList.contains(randomNumber)){
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }
}
