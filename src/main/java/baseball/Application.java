package baseball;

import java.util.List;
import camp.nextstep.edu.missionutils.*;
import java.util.Scanner;

public class Application {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void getComputersRandomNumber(List<Integer> computersNumber) {
        while (computersNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computersNumber.contains(randomNumber)) {
                computersNumber.add(randomNumber);
            }
        }
    }

    public static void getUsersInputNumber(List<Integer> usersNumber) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = sc.next();
        if (input.length() > 3) {
            throw new IllegalArgumentException();
        }
        //각 자리수를 옮겨담는다.
        for (int i = 0; i < 3; i++) {
            char eachDigit = input.charAt(i);
            usersNumber.add((Character.getNumericValue(eachDigit)));
        }
    }
}
