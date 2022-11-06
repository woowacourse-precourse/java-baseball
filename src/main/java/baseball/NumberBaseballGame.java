package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGame {
    private List<Integer> computerNumber;
    private List<Integer> userNumber;
    private int strike;
    private int ball;

    public NumberBaseballGame() {
        computerNumber = new ArrayList<>();
        strike = 0;
        ball = 0;
        System.out.println("숫자 야구 게임을 시작합니다");
        getRandomThreeDigitNumber();
    }

    public void gameStart() {
        System.out.print("숫자를 입력해주세요 :");
        String inputNumber = Console.readLine();
        userNumber = getUserNumberList(inputNumber);
        compareUserAndComputer();
        System.out.println(getResultToString());
    }

    public boolean checkGameEnd() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String response = Console.readLine();
            if (response == "1") {
                return true;
            }
            if (response == "2") {
                return false;
            }
        }
        return true;
    }

    public void getRandomThreeDigitNumber() {
        for (int i = 0; i < 3; i++) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(num)) {
                computerNumber.add(num);
            }
        }
    }

    public List<Integer> getUserNumberList(String userNumber) {
        String[] userNumberArray = userNumber.split("");
        List<Integer> userNumberList = new ArrayList<>();
        for (String number : userNumberArray) {
            userNumberList.add(Integer.parseInt(number));
        }
        return userNumberList;
    }

    public void compareUserAndComputer() {
        for (int i = 0; i < userNumber.size(); i++) {
            if (computerNumber.indexOf(userNumber.get(i)) == i) {
                strike++;
                continue;
            }
            if (computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }
    }

    public String getResultToString() {
        if (ball != 0 && strike != 0) {
            return ball + "볼 " + strike + "스트라이크";
        }
        if (ball != 0 && strike == 0) {
            return ball + "볼";
        }
        if (ball == 0 && strike != 0) {
            return strike + "스트라이크";
        }
        return "낫싱";
    }

}
