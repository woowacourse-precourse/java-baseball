package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final int digitNumber = 3;

    // 플레이어 값 입력 메서드
    public List<Integer> inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();

        boolean isNumeric = number.chars().allMatch(Character::isDigit);

        if (number.length() == digitNumber && isNumeric == true && number.length() == digitNumber) {
            List<Integer> numberList = getNumberList(number, digitNumber);
            return numberList;
        } else {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }

    // 플레이어 값 List에 담기
    public List<Integer> getNumberList(String number, int digitNumber) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < digitNumber; i++) {
            char charNum = number.charAt(i);
            int num = Character.getNumericValue(charNum);
            if (!numberList.contains(num)) {
                numberList.add(num);
            }
        }
        return numberList;
    }
}
