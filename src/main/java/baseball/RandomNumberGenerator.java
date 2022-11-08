package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedList;
import java.util.List;

/*
    컴퓨터가 1~9 사이의 임의의 정수 난수 3개를 선택하는 클래스이다.
    1~9 사이의 정수를 총 3번 추출한다.
    중복되는 값이 있어서는 안 된다.
 */

public class RandomNumberGenerator {
    public static List<Integer> randomNumberList = new LinkedList<>();
    static int getRandomNumber(){
        return Randoms.pickNumberInRange(1,9);
    }

    static boolean IsInList(int number){
        return randomNumberList.contains(number);
    }

    static void addToRandomNumberList() {
        while (true) {
            int number = getRandomNumber();
            if (!IsInList(number)){
                randomNumberList.add(number);
                break;
            }
        }
    }

    public void generate() {
        for(int i=0;i<3;i++) {
            addToRandomNumberList();
        }
    }
}
