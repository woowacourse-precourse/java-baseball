package baseball;

import generator.GameNumberGenerator;
import io.IOProcessor;
import referee.Referee;

public class Application {
    public static void main(String[] args) {
        boolean isFirstGame = true; // 처음하는 게임인가?
        boolean isFinished = false; // 게임이 완전히 종료되었는 가?
        GameNumberGenerator generator = new GameNumberGenerator();
        Referee referee = new Referee();

        while(!isFinished) {
            if(isFirstGame)
                System.out.println("숫자 야구 게임을 시작합니다.");
            String answer = generator.getNumber(); // 정답 생성
            System.out.println("answer = " + answer);
            boolean finished = false;
            while(!finished) {
                String expected = IOProcessor.getUserInput("숫자를 입력해주세요 :", " ");
                finished = referee.decision(expected, answer);
                System.out.println(referee.buildDecisionString());
            }
            String status = IOProcessor.getUserInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", "\n");
            if(status.equals("2"))
                isFinished = true;
            else if(!status.equals("1"))
                throw new IllegalArgumentException("1 또는 2가 입력되어야 합니다.");
            isFirstGame = false;
        }
    }
}
