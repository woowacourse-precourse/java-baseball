package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> user = new ArrayList<>();
        String input = Console.readLine();
        for (String number : input.split("")) {
            user.add(Integer.parseInt(number));
        }
        if (user.size() != 3)
            throw new IllegalArgumentException("오류가 발생했습니다.");
        if (user.stream().noneMatch(x -> x % 10 > 0))
            throw new IllegalArgumentException("오류가 발생했습니다.");
        return user;
    }

    private static List<Integer> makeAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
