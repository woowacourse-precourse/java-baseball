package baseball;

import baseball.domain.NumberGenerator;
import baseball.domain.Referee;

import java.util.Arrays;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> computer = numberGenerator.createRandomNumbers();
        Referee referee = new Referee();

        String message = "";
        while (!message.equals("3스트라이크")) {
            message = referee.compare(computer, askNumbers());
            System.out.println(message);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static List<Integer> askNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");

        String input = readLine();

        return Arrays.stream(Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList());
    }
}
