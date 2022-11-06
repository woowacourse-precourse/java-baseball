package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    final int digitNumber = 3;

    // 플레이어의 숫자 입력 및 숫자 이외 예외처리
    public List<Integer> inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();

        boolean isNumeric = number.chars().allMatch(Character::isDigit);

        if (number.length() == digitNumber && isNumeric) {
            return getNumberList(number, digitNumber);
        } else {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
    }

    // 플레이어의 숫자 리스트에 담기 및 중복 숫자 예외 처리
    public List<Integer> getNumberList(String number, int digitNumber) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < digitNumber; i++) {
            char charNum = number.charAt(i);
            int num = Character.getNumericValue(charNum);
            if (!numberList.contains(num)) {
                numberList.add(num);
            }
            else{
                throw new IllegalArgumentException("잘못된 값입니다.");
            }
        }
        return numberList;
    }
}
