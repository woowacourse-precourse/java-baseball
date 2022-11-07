package baseball;

import baseball.util.Util;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Integer> computer = Util.makeRandomNumbers();
        String input;
        System.out.println("숫자 야구 게임을 시작합니다.");

        outer:
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            input = Console.readLine();
            List<Integer> inputNumbers = Util.toIntegerArray(input);
            String comment = takeTurn(inputNumbers);

            break outer;
        }
    }

    private static String takeTurn(List<Integer> inputNumbers) {
        String comment = "";
        // Todo: 볼, 스트라이크 판단
        return comment;
    }
}
