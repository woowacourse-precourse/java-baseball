package baseball;

import java.util.List;
public class NumberCheck {
    public static void sameNumberCheck(String num) {
        int sameNumber = 0;
        for(int i=0;i<num.length();i++){
            for(int j=i+1;j<num.length();j++){
                if (num.charAt(i) == num.charAt(j)) {
                    sameNumber += 1;
                }
            }
        }
        if (sameNumber != 0) {
            throw new IllegalArgumentException("입력숫자의 중복이 있습니다. 다시 입력해주세요.");
        }
    }
    public static void nullCheck(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (num.substring(i, i + 1).equals(" ")) {
                throw new IllegalArgumentException("입력숫자의 공백이 있습니다. 다시 입력해주세요.");
            }
        }
    }

    public static int Check(String num, List<Integer> answer) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == (int) num.charAt(i) - 48) {
                strike += 1;
            } else if (answer.contains((int) num.charAt(i) - 48)) {
                ball += 1;
            }
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
        return strike;
    }
}
