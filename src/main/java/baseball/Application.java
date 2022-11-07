package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 1. 컴퓨터가 1애서 9 사이 서로 다른 임의의 수 3개 선택
        Computer computer = new Computer();
        List<Integer> randoms = computer.randoms();

        // 2. 게임 시작 문구 출력
        System.out.println(computer.gameStart());

        // 3. 게임 플레이어는 숫자 3자리 입력
        List<Integer> nums = computer.stringToInteger(computer.inputNum());
    }
}
