package baseball;

import java.util.List;

public class Referee {
    static final String Notice_success = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private List<Integer> ComputerNum;
    public int strike = 0;
    public int ball = 0;

    public Referee(List<Integer> ComputerNum) {
        this.ComputerNum = ComputerNum;
    }

    public boolean printResult(List<Integer> userInput) {
        getResult(userInput);
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return true;
        } else {
            String resultStr = "";
            if (ball != 0) {
                resultStr += (ball + "볼 ");
            }
            if (strike != 0) {
                resultStr += (strike + "스트라이크");
            }
            System.out.println(resultStr);
            if (strike == 3) {
                System.out.println(Notice_success);
                return false;
            }
            return true;
        }
    }

    public void getResult(List<Integer> userInput) {
        strike = 0;
        ball = 0;
        for (int i = 0; i < 3; i++) {
            if (ComputerNum.get(i).equals(userInput.get(i))) {
                strike += 1;
            } else if (userInput.contains(ComputerNum.get(i))) {
                ball += 1;
            }
        }
    }
}
