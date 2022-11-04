package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        List<Integer> computer = createComputerNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");

        int gameFlag = 0; // gameFlag = 0: 처음, 1: 재시작, 2: 종료
        while (gameFlag != 2) {
            int strike = 0;
            int ball = 0;

            System.out.print("숫자를 입력해주세요 : ");
            String inputNumber = Console.readLine();
            validateInputNumber(inputNumber);

            List<String> inputNumberList = Arrays.asList(inputNumber.split(""));
            List<Integer> player = inputNumberList.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            for (int i = 0; i < 3; i++) {
                if (player.get(i).equals(computer.get(i))) {
                    strike += 1;
                }
                if (computer.contains(player.get(i)) && !player.get(i).equals(computer.get(i))) {
                    ball += 1;
                }
            }

            boolean correctFlag = checkPlayerResult(ball, strike);
        }
    }

    private static List<Integer> createComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static void validateInputNumber(String inputNumber) {
        if (inputNumber.length() != 3 || !inputNumber.matches("^[1-9]+$")) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checkPlayerResult(int ball, int strike) {
        boolean correctFlag = false;
        if (ball != 0 && strike != 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
        } else if (ball != 0) {
            System.out.printf("%d볼\n", ball);
        } else if (strike != 0 && strike != 3) {
            System.out.printf("%d스트라이크\n", strike);
        } else if (strike == 3) {
            System.out.printf("%d스트라이크\n", strike);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            correctFlag = true;
        } else {
            System.out.println("낫싱");
        }
        return correctFlag;
    }

}
