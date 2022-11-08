package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static final int len = 3; //항상 3자리 수로 고정이므로 len변수에 값 저장
    private static List<Integer> computerNum; //컴퓨터 숫자

    public static void main(String[] args) {

    }


    //1. 컴퓨터 3자리 랜덤 숫자 생성
    public static List<Integer> getComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < len) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }



}
