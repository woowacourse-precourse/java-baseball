package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    // 1. 컴퓨터의 수 생성
    public static List<Integer> computerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }


    // 2. 유저에게 숫자 받기
    public static String userNumber() {
        return Console.readLine();
    }


    // 3. 유저가 입력한 값이 유효한지 확인
    public static List<Integer> userNumberIsValid (String userNumber) {
        // 1. 세자리가 맞는지
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        // 2. 숫자만 들어왔는지
        char firstNum = userNumber.charAt(0);
        char secondNum = userNumber.charAt(1);
        char thirdNum = userNumber.charAt(2);
        if (48 >= (int)firstNum || (int)firstNum > 57) {
            throw new IllegalArgumentException();
        } else if (48 >= (int)secondNum || (int)secondNum > 57) {
            throw new IllegalArgumentException();
        } else if (48 >= (int)thirdNum || (int)thirdNum > 57) {
            throw new IllegalArgumentException();
        }

        // 3. 세 수가 모두 다른값인지
        HashSet<Character> userNumberSet = new HashSet<>();
        userNumberSet.add(firstNum);
        userNumberSet.add(secondNum);
        userNumberSet.add(thirdNum);
        if (userNumberSet.size() != 3) {
            throw new IllegalArgumentException();
        }

        List<Integer> userNumberList = new ArrayList<>();
        userNumberList.add((int)firstNum-48);
        userNumberList.add((int)secondNum-48);
        userNumberList.add((int)thirdNum-48);

        return userNumberList;
    }
}


