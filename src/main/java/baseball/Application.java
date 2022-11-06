package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        baseball();

    }

    public static void baseball() {
        String answer = selectRandomNumber();
    }

    public static String selectRandomNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            while (sb.toString().contains(Integer.toString(randomNumber))) {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            }
            sb.append(randomNumber);
        }

        return sb.toString();
    }

}
