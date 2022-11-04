package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String randomNum = makeRandomNum();
        System.out.println("숫자를 입력해 주세요. :");
    }

    public static String makeRandomNum() {
        String randomNum = "";
        while(randomNum.length()<3) {
            int ranNum = Randoms.pickNumberInRange(1, 9);
            if(!randomNum.contains(ranNum+"")) {
                randomNum = randomNum + ranNum;
            }
        }
        return randomNum;
    }
}
