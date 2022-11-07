package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Baseball baseball = new Baseball();
        do {
            baseball.pickRandomNumber();

        } while (true);
    }
}

class Baseball {
    private List<Integer> computerNumber = List.of(0, 0, 0);
    private List<Integer> playerNumber = List.of(0, 0, 0);
    private List<Integer> baseballCount = List.of(0, 0);

    public void pickRandomNumber() {
        for (int i = 0; i < 3;) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.set(i, randomNumber);
                i++;
            }
        }
    }

    public void playerNumberList () {
        String getPlayerNumber = null;
        try {
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);
            System.out.print("숫자를 입력해주세요 :");
            getPlayerNumber = br.readLine();
        } catch (Exception e) { }

        int num = Integer.parseInt(getPlayerNumber);
        for (int i = 0; i < 3; i++) {
            playerNumber.set(i, (num % 10));
            num /= 10;
        }
    }

    public void comparisonPlayerComputer() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                comparisonNumber(playerNumber.get(i), computerNumber.get(j), i, j);
            }
        }
    }
    public void comparisonNumber(int playerNumber, int computerNumber, int i, int j) {
        if (playerNumber == computerNumber) {
            if (i == j) {
                countBaseball(0);
            } else {
                countBaseball(1);
            }
        }
    }
    public void countBaseball(int i) {
        int count;
        count = baseballCount.get(i) + 1;
        baseballCount.set(i, count);
    }

    public void printBaseballScore() {
        if (baseballCount.get(0) == 0 && baseballCount.get(1) == 0) {
            System.out.print("낫싱");
        } else {
            printBall();
            printStrike();
        }
    }
    public void printStrike() {
        if (baseballCount.get(0) != 0) {
            System.out.printf("%d스트라이크", baseballCount.get(0));
        }
    }
    public void printBall() {
        if (baseballCount.get(1) != 0) {
            System.out.printf("%d볼 ", baseballCount.get(1));
        }
    }
}