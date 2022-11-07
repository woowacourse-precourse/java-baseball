package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        while(true) {
            // 1. 컴퓨터가 1애서 9 사이 서로 다른 임의의 수 3개 선택
            List<Integer> randoms = computer.randoms();

            while(true) {
                // 2. 게임 시작 문구 출력
                System.out.println(computer.gameStart());

                // 3. 게임 플레이어는 숫자 3자리 입력
                List<Integer> nums = computer.stringToInteger(computer.inputNum());

                // 4. 입력한 숫자에 대한 결과 출력
                if(computer.baseballGame(randoms, nums)) break;
            }
            // 5. 게임 끝난 경우 재시작/종료 질문 및 동작
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            if(!computer.retryGame(input)) break;
        }
    }
}
