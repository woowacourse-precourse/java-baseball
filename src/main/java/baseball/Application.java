package baseball;

import generator.GameNumberGenerator;
import io.IOProcessor;
import referee.Referee;

public class Application {
    public static void main(String[] args) {
        boolean isFinished = false; // 게임이 완전히 종료되었는 가?
        GameNumberGenerator generator = new GameNumberGenerator();
        Referee referee = new Referee();

        while(!isFinished) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            String answer = generator.getNumber(); // 정답 생성
            boolean finished = false;
            while(!finished) {
                String expected = IOProcessor.getUserInput();
                finished = referee.decision(expected, answer);
                System.out.println(referee.buildDecisionString());
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String status = IOProcessor.getUserInput();
            if(status.equals("2"))
                isFinished = true;
            else if(!status.equals("1"))
                throw new IllegalArgumentException("1 또는 2가 입력되어야 합니다.");
        }
    }
}
