package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static final int numberOfDigits = 3;
    static final int minNumber = 1;
    static final int maxNumber = 9;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 랜덤한 숫자 받아온 후 컴퓨터 리스트에 값 추가
        List<Integer> computer = addToRandomNumberList();

        while (true) {
            List<Integer> user = new ArrayList<>();
            // 사용자에게 숫자 입력받기
            String user_number = getTheUserToInputNumber();
            // 사용자의 숫자가 3자리가 아닌 경우 예외 처리
            exceptionIfNumberIsNotThreeDigits(user_number.length());
        }
    }

    // 랜덤한 숫자 받아온 후 컴퓨터 리스트에 값 추가
    public static List<Integer> addToRandomNumberList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < numberOfDigits) {
            int randomNumber = Randoms.pickNumberInRange(minNumber, maxNumber);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    // 사용자에게 숫자 입력받기
    public static String getTheUserToInputNumber() {
        System.out.println("숫자를 입력해 주세요");
        return Console.readLine();
    }
    // 사용자의 숫자가 3자리가 아닌 경우 예외 처리
    public static void exceptionIfNumberIsNotThreeDigits(int len) {
        if (len != numberOfDigits) {
            throw new IllegalArgumentException("숫자를 제대로 입력하시지 않았습니다.");
        }
    }
}