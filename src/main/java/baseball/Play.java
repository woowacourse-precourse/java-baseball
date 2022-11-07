package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Play {

    public static void playStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int number = createThreeNumber();
    }
    public static int createThreeNumber() {
        int number = Randoms.pickNumberInRange(1, 9);
        return number;
    }
}
