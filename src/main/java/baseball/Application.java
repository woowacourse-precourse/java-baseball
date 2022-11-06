package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
            if (isNumberException(s) && !(s.equals("1") || s.equals("2"))) {
                throw new IllegalArgumentException();
            }
            if (s.equals(2)) {
                break;
            }
        }
    }

    private static boolean isNumberException(String s) {
        int number = Integer.parseInt(s);
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (set.contains(n)) { //  같은 숫자가 2개 이상 입력된 경우이다.
                return true;
            }
            set.add(n);
        }
        if (number > 987 || number < 123) {
            //987이 max, 123이 min
            return true;
        }
        return false;
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
