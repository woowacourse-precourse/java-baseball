package baseball;

import baseball.Validation;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberChoice {
    public static List<Integer> computerPick() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> userPick() {
        System.out.println("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        if (Validation.isValid(inputNum)) {
            String[] tempNum = inputNum.split("");
            List<Integer> user = new ArrayList<>();
            for (int i = 0; i < tempNum.length; i++) {
                user.add(Integer.valueOf(tempNum[i]));
            }
            return user;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
