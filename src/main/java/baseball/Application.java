package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static boolean isValidInput(String input){

        return true;
    }
    public static List<Integer> createTargetNums(){
        List<Integer> targetNums = new ArrayList<>();
        while(targetNums.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetNums.contains(randomNumber)) {
                targetNums.add(randomNumber);
            }
        }

        return targetNums;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input="";
        try {
            if(!isValidInput(input))
                throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            //어플리케이션 종료
        }
    }
}
