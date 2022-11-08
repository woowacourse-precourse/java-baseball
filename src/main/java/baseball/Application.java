package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String computer = getRandomNumber();
        printStartMsg();
    }

    public static String getRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        StringBuffer sb = new StringBuffer();
        for(Integer x : computer){
            sb.append(x);
        }
        return sb.toString();
    }

    public static void printStartMsg(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
