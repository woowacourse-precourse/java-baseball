package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

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

    public static boolean inputValidator(String input){


        if(input.length()!=3){
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if(input.charAt(i)<'1'|| input.charAt(i)>'9'){
                return false;
            }
        }
        if(input.charAt(0)==input.charAt(1)||input.charAt(1)==input.charAt(2)||input.charAt(2)==input.charAt(0)){
            return false;
        }
        return true;

    }


}
