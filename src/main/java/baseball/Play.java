package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Play {

    public static void playStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int number = createThreeNumber();
    }
    public static int createThreeNumber() {
        int size = 0;
        int randomNumber = 0;
        while (size > 3) {
            randomNumber =  randomNumber * 10 + Randoms.pickNumberInRange(1, 9);
            if (Exception.isRedundancy(randomNumber)) {
                randomNumber /= 10;
                size--;
            }
            size++;
        }
        return randomNumber;
    }
}
