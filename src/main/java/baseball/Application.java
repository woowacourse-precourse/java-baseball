package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computerNumberList = createComputerNumberList();
        startGame();
        putUserNumber();
    }

    private static void putUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String numbers = Console.readLine();
    }

    public static List<Integer> createComputerNumberList() {
        List<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
