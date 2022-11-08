package baseball;

import generator.GameNumberGenerator;
import io.IOProcessor;
import referee.Referee;
import validator.Validator;

public class Application {
    public static void main(String[] args) {
        boolean isFirstGame = true; // 처음하는 게임인가?
        boolean isGameFinished = false; // 게임이 완전히 종료되었는 가?
        GameNumberGenerator generator = new GameNumberGenerator();
        Referee referee = new Referee();

        while (!isGameFinished) {
            if (isFirstGame) { // 첫번째 게임인 경우에만 시작 메시지를 출력함
                System.out.println("숫자 야구 게임을 시작합니다.");
            }
            String answer = generator.getNumber();

            // 사용자가 정답을 입력할 때 까지 다음을 반복함
            boolean isCollectNumber = false;
            while (!isCollectNumber) {
                String expected = IOProcessor.getUserInput("숫자를 입력해주세요 :", " ");
                Validator.validate(expected);
                isCollectNumber = referee.decision(expected, answer);
                System.out.println(referee.getDecisionResultString());
            }

            // 게임을 새로 시작할 지, 종료할 지 입력받음
            String status = IOProcessor.getUserInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", "\n");
            if (status.equals("2")) {
                isGameFinished = true;
            } else if (!status.equals("1")) {
                throw new IllegalArgumentException("1 또는 2가 입력되어야 합니다.");
            }
            isFirstGame = false;
        }
    }
}
