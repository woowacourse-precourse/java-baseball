package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        int newGame = 1;

        while (newGame == 1) {
            newGame = game();
        }
    }

    public static int game() throws IllegalArgumentException {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println("숫자 야구 게임을 시작합니다.");

        String input;
        boolean endGame = true;

        while (endGame) {
            System.out.print("숫자를 입력해주세요 : ");
            input = Console.readLine();
//            inputException(input);
            endGame = scoreCalculation(input, computer);
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int newGame = Integer.parseInt(Console.readLine());
        return newGame;
    }

    public static boolean scoreCalculation(String input, List<Integer> computer) {
        return false;
    }

//    public static void inputException(String input)

}
