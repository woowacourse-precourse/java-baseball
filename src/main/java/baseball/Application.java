package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();

        List<Integer> endListFormat = Arrays.asList(0, 3);

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            String gameControlValue = "";
            System.out.print("숫자를 입력해주세요 : ");

            String playerInput = Console.readLine();

            String computerAnswer = computer.getRandomNumber().toString();

            System.out.println(computerAnswer);

            List<Integer> calcHintResult = computer.calcHint(playerInput, computerAnswer);
            String stringResult = computer.printHint(calcHintResult);
            System.out.println(stringResult);

            if (calcHintResult.equals(endListFormat)) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                gameControlValue = Console.readLine();
            }

            if (gameControlValue.equals("1")) {
                computer = new Computer();
            } else if (gameControlValue.equals("2")) {
                break;
            }
        }
    }
}
