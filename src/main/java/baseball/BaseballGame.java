package baseball;

import baseball.domain.Computer;
import baseball.domain.Referee;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public static List<Integer> getNumbers() {
        List<Integer> userNumbers = new ArrayList<>();
        System.out.printf("숫자를 입력해주세요: ");
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char c : input.toCharArray()) {
            if (c < 49 || c > 57) {
                throw new IllegalArgumentException();
            }
            if (userNumbers.contains(Character.getNumericValue(c))) {
                throw new IllegalArgumentException();
            }
            userNumbers.add(Character.getNumericValue(c));
        }

        return userNumbers;
    }


    public static void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            startGame();
            String restartCheckInput = Console.readLine();
            if (restartCheckInput.equals("2")) {
                System.out.println("게임 종료");
                break;
            }
        }
    }

    public static void startGame() {
        List<Integer> computerNumber = Computer.createNumbers();
        while (true) {
            List<Integer> userNumber = getNumbers();
            String result = Referee.compare(computerNumber, userNumber);
            System.out.println(result);
            if (result.equals("3스트라이크")){
                break;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
