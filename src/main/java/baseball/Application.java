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
            boolean correctFlag = false;

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

}
