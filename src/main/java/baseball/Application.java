package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true){
            List<Integer> computer = startGame();
        }
    }

    private static List<Integer> startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        return computerNumber();
    }

    private static List<Integer> computerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> userNumber() {
        String input = Console.readLine();
        List<Integer> user = new ArrayList<>();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < input.length(); i++){
            user.add(input.charAt(i) - '0');
        }

        return user;
    }
}
