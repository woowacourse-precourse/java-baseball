package baseball;
import java.lang.reflect.Array;
import java.util.*;
import camp.nextstep.edu.missionutils.*;
public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        BaseballGame Game = new BaseballGame();
        List<Integer> list=Game.makeRandomNumber();
        System.out.println(list);
    }
}

class BaseballGame {
    //숫자 3개를 임의로 추출 하고 컴퓨터에 해당하는 변수에 할당하는 기능
    List<Integer> makeRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}

