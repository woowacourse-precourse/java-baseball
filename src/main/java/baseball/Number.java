package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

import static baseball.Validation.isCorrectType;
import static baseball.Validation.isDuplication;

public class Number {
    public Number(){
    }

    public static List<Integer> computerNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static List<Integer> userNumber(){
        List<Integer> li = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String str = Console.readLine();

        isCorrectType("^[1-9]{3}$", str);
        isDuplication(str);

        for(int i = 0; i < 3; i++){
            int tmp = str.charAt(i) - '0';
            li.add(tmp);
        }
        return li;
    }
}
