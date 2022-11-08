package baseball.game;

import baseball.entity.Computer;
import baseball.entity.User;
import baseball.number.NumberJudgment;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameService {
    private Computer computer = new Computer();
    private User user = new User();
    private NumberJudgment numberJudgment = new NumberJudgment();

    public void start() {
        int strikeCount = 0;

        while (strikeCount < 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInputNumber = Console.readLine();

            UserException.checkUserInputException(userInputNumber);
            user.setUserNumberList(userInputNumber);
            strikeCount = proceed();
        }
    }

    private int proceed() {
        List<Integer> userNumberList = user.getUserNumberList();
        List<Integer> computerNumberList = computer.getComputerNumberList();

        int strikeCount = 0;
        int sameNumberCount = numberJudgment.getSameNumberCount(computerNumberList, userNumberList);

        if (sameNumberCount == 0) {
            printHint();
        } else {
            strikeCount = numberJudgment.getSameIndexCount(userNumberList);
            int ballCount = sameNumberCount - strikeCount;
            printHint(ballCount, strikeCount);
        }
        return strikeCount;
    }

    private void printHint() {
        System.out.println(Hint.NOTHING.getName());
    }

    private void printHint( int ballCount, int strikeCount) {

        if (ballCount == 0) {
            System.out.println(strikeCount + Hint.STRIKE.getName());
        } else if (strikeCount == 0) {
            System.out.println(ballCount + Hint.BALL.getName());
        } else {
            System.out.println(ballCount + Hint.BALL.getName()+ " " + strikeCount + Hint.STRIKE.getName());
        }
    }

    public void over() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public enum Hint {
        STRIKE("스트라이크"),
        BALL("볼"),
        NOTHING("낫싱");

        private String name;
        Hint(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
