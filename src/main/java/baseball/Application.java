package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String line = "1";
        while (!line.equals("2")) {
            game(createBaseBall());
            line = Console.readLine();
            if (!line.matches("^[12]$")) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void game(List<Integer> computer) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String line = Console.readLine();
            List<Integer> input = convertBaseBallByLine(line);
            int strike = countStrike(input, computer);
            int ball = countBall(input, computer);
            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
                continue;
            }
            String output = "";
            if (ball > 0) {
                output += String.format("%d볼 ", ball);
            }
            if (strike > 0) {
                output += String.format("%d스트라이크", strike);
            }
            System.out.println(output);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
        }
    }

    public static int countStrike(List<Integer> input, List<Integer> computer) {
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).intValue() != computer.get(i).intValue()) {
                continue;
            }
            count++;
        }
        return count;
    }

    public static int countBall(List<Integer> input, List<Integer> computer) {
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            if (!computer.contains(input.get(i))) {
                continue;
            }
            if (input.get(i).intValue() == computer.get(i).intValue()) {
                continue;
            }
            count++;
        }
        return count;
    }

    public static List<Integer> convertBaseBallByLine(String line) {
        if (!line.matches("^\\d{3}$")) {
            throw new IllegalArgumentException();
        }
        List<Integer> list = new ArrayList<>();
        for (String digit : line.split("")) {
            int value = Integer.parseInt(digit);
            if (list.contains(value)) {
                throw new IllegalArgumentException();
            }
            list.add(value);
        }
        return list;
    }

    public static List<Integer> createBaseBall() {
        List<Integer> baseBallNumber = new ArrayList<>();
        while (baseBallNumber.size() < 3) {
            int digit = Randoms.pickNumberInRange(0, 9);
            if (baseBallNumber.contains(digit)) {
                continue;
            }
            baseBallNumber.add(digit);
        }
        return baseBallNumber;
    }
}
