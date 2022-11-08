package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    private List<Integer> ThreeDifferentNumber;

    public User() {
        ThreeDifferentNumber = inputThreeNumber();
    }

    private List<Integer> inputThreeNumber() {
        System.out.println("숫자를 입력해 주세요 : ");

        String userInput = Console.readLine();
    }

}
