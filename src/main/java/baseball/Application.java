package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        playGame();

    }
    public static void playGame() {
        List<Integer> computerNumber = makeRandom();
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            System.out.print("숫자를 입력해주세요 : ");
            int userNumber = Integer.parseInt(Console.readLine());
            if (!checkException(userNumber)) {
                throw new IllegalArgumentException();
            }
            //낫싱, 볼, 스트라이크
        }
        while () {
            //게임 종료
        }
    }
    public static List<Integer> makeRandom() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public static boolean checkException(int num) {
        String numString = Integer.toString(num);
        if (numString.length() != 3) {
            return false;
        }
        if (numString.contains("0")) {
            return false;
        }
        if (!containSameNumber(numString)) {
            return false;
        }
        return true;
    }
    public static boolean containSameNumber(String numString) {
        HashMap<Character, Integer> checkSameNumber = new HashMap<>();
        for (int i = 0; i < numString.length(); i++) {
            if (checkSameNumber.containsKey(numString.charAt(i))) {
                return false;
            }
            checkSameNumber.put(numString.charAt(i), i);
        }
        return true;
    }

}
