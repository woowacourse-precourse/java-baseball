package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static List<Integer> getNumberOfComputer(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void main(String[] args) {

        // 1. 상대방(컴퓨터)의 숫자를 설정한다.
        List<Integer> computer = new ArrayList<>();
        computer = getNumberOfComputer(computer);
        System.out.println("computer = " + computer); // 테스트 출력

        // 2. 사용자에게서 숫자를 입력받는다.
        List<Integer> user = new ArrayList<>();
        user = getNumberOfUser(user);
        System.out.println("user = " + user); // 테스트 출력
    }

    private static List<Integer> getNumberOfUser(List<Integer> user) {
        String numOfUserString = Console.readLine();
        if (!isValid(numOfUserString)) {
            return null; // 어차피 비정상값이면 Exception 일으키고 return 하지도 못함
        }
        user = stringToList(numOfUserString);
        return user;
    }

    private static List<Integer> stringToList(String numOfUserString) {
        List<Integer> user = new ArrayList<>();
        int numOfUserInteger = Integer.parseInt(numOfUserString);
        user.add(numOfUserInteger / 100);
        user.add((numOfUserInteger % 100) / 10);
        user.add(numOfUserInteger % 10);
        return user;
    }

    private static boolean isValid(String numOfUserString) {

        int num = 0;

        // 1. 정수가 아닌 값을 입력했을 시 오류를 발생시킨다.
        try {
            num = Integer.parseInt(numOfUserString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        // 2. 세 자리의 수가 아닌 경우 오류를 발생시킨다.
        if (num > 1000 || num < 100) {
            throw new IllegalArgumentException();
        }

        // 3. 서로 다른 세 자리의 수가 아닌 경우 오류를 발생시킨다.
        int hundreds = num / 100;
        int tens = (num % 100) / 10;
        int ones = num % 10;
        if (hundreds == tens || hundreds == ones || tens == ones) {
            throw new IllegalArgumentException();
        }

        return true;
    }
}