package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = new ArrayList<>();
        computer = createComputerNumber(computer);
        while (true) {
            startGame(computer);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String s = Console.readLine();
            if (isNumberException(s)) {
                throw new IllegalArgumentException();
            }
            if (s.equals(2)) {
                break;
            }
        }
    }

    private static void startGame(List<Integer> computer) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String s = "";
        HashMap<String, Integer> map = new HashMap<>();//ball, strike : 갯수
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            s = Console.readLine();
            if (isNumberException(s)) {
                throw new IllegalArgumentException();
            }
            map = compareNumber(computer,s);//비교하여 몇 볼, 몇 스트라이크인지 map으로 받음
            boolean result = printResult(map);//3스트라이크인지 확인 한 값 리턴
            if (result) {
                System.out.println("3개의 숫자를 모두  맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static List<Integer> createComputerNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
