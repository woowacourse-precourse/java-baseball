package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Baseball {
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        running();
    }

    public void running() {
        List<Integer> computerValue = Computer.createNewValue();

        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            BaseballException.checkValidInputForBaseball(input);

            List<Integer> compareResult = Computer.compareWithInput(input, computerValue);
            String compareResultString = Computer.resultToString(compareResult);
            System.out.println(compareResultString);

            if (compareResultString.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        afterRound();
    }

    public void afterRound() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        switch (input) {
            case "1":
                running();
                break;
            case "2":
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
