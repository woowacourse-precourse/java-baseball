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
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 입력을 받는 부분
        String input;
        Boolean replay = true;
        List <Integer> playerCount = new ArrayList<>();
        // 인풋 판별, 이것은 app 단에서 static 메소드로 구현
        // 그 이후에 정상이면 input을 게임 구현한 클래스에서 돌리자
        while (replay) {
            input = Console.readLine();
            if (checkInput(input)) {

            }
            System.err.println("hi~");
            // 여기서 baseball 클래스에서 게임구현
replay = false;
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