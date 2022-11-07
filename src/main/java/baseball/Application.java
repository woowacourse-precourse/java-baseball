package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static Boolean checkDigitInput(String input) throws IllegalArgumentException {
            for (int i = 0; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i))) throw new IllegalArgumentException();
            }
        return true;
    }
    public static Boolean checkNumberInput(String input) throws IllegalArgumentException {
        if (input.length() != 3) throw new IllegalArgumentException();
        return true;
    }

    public static Boolean checkInput(String input) {
        try {
            if (checkDigitInput(input) && checkNumberInput(input)) return true;
        } catch (IllegalArgumentException e) {
            System.err.println("올바르지 못한 입력값이 들어왔습니다");
            throw new IllegalArgumentException("에러");
        }
        return true;
    }

    public static List<Integer> makeUserCount(String input) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) list.add(input.charAt(i), i);
        return list;
    }
    public static void main(String[] args) {

        String input;
        Boolean replay = true;
        List <Integer> playerCount;

        while (replay) {
            input = Console.readLine();
            if (checkInput(input)) {
                playerCount = makeUserCount(input);
            }
            // 여기서 baseball 클래스에서 게임구현

        }
    }
}

class Baseball {
    List<Integer> baseballCount;
    public Baseball() {
        // 카운트 랜덤 생성
        baseballCount = new ArrayList<>();
        while (baseballCount.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballCount.contains(randomNumber)) {
                baseballCount.add(randomNumber);
            }
        }
    }
    // 같은지 다른지 체크하는 메소드
    // 스트라이크 볼 확인 메소드
    // 스트라이크 볼 출력 메소드
    /*public Boolean countCheck(List<Integer> player) {

    }*/
}