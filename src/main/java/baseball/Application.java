package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        while(true) {
            List<Integer> answers = computer.randoms(); // 1. 컴퓨터가 1애서 9 사이 서로 다른 임의의 수 3개 선택

            while(true) {
                Message.startGameMessage(); // 2. 게임 시작 문구 출력

                Message.getNumsMessage(); // 3. 게임 플레이어는 숫자 3자리 입력
                List<Integer> numbers = computer.stringToInteger(Console.readLine());

                if(computer.baseballGame(answers, numbers)) break; // 4. 입력한 숫자에 대한 결과 출력
            }
            Message.retryGameMessage(); // 5. 게임 끝난 경우 재시작/종료 질문 및 동작
            if(!computer.retryGame(Console.readLine())) break;
        }
    }
}
