package bestpractice.baseball;

import bestpractice.baseball.domain.NumberGenerator;
import bestpractice.baseball.domain.Referee;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        List<Integer> computer = generator.createRandomNumbers();

        Referee referee = new Referee();

        String result = "";
        while (!"0볼 3스트라이크".equals(result)) {
            result = referee.compare(computer, askNumbers());
            System.out.println(result);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }

    public static List<Integer> askNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = Console.readLine();
        return input.chars().map(Character::getNumericValue).boxed().collect(Collectors.toList());
    }
}
