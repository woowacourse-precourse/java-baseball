package baseball;

import baseball.domain.NumberComparison;
import baseball.domain.NumberGenerator;
import baseball.domain.Player;
import baseball.domain.Referee;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String result = "";
        int reStart = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        Player player = new Player();
        Referee referee = new Referee();
        NumberGenerator numberGenerator = new NumberGenerator();

        while (reStart == 1) {
            result = "";
            List<Integer> computer = numberGenerator.createRandomNumbers();

            while (!(result.equals("3스트라이크"))) {
                System.out.print("숫자를 입력해주세요 : ");
                String readLine = Console.readLine();

                List<Integer> playerInput = player.getInput(readLine);
                result = referee.resultJudgment(computer, playerInput);
                System.out.println(result);
            }
            reStart = getReStart();

        }
    }

    private static int getReStart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String reStart = Console.readLine();
        int checkResult = Integer.parseInt(reStart);
        if (!(checkResult > 0 && checkResult <= 2)) {
            throw new IllegalArgumentException();
        }
        return checkResult;
    }
}
