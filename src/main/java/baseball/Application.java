package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        printInitMessage();
        getUserAnswer();
    }

    private static void printInitMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void getUserAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        Console.readLine();
    }

    public static List<Integer> pickThreeNumbers() {
        List<Integer> result = new ArrayList<>();
        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }
        return result;
    }
}
