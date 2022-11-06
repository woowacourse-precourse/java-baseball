package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Pitch {

    List<Integer> pitchNumbers = new ArrayList<>();

    /**
     * 사용자에게 입력을 받은 수를 저장합니다.
     * @throws IllegalArgumentException 개수가 3개가 아닐 때
     * @throws IllegalArgumentException 숫자가 아닌 값이 입력됐을 때
     */
    public Pitch() {
        String inputNumber = Console.readLine();
        if(inputNumber.length() != 3)
            throw new IllegalArgumentException();
        for(int i = 2; i >= 0 ; i--){
            if(!Character.isDigit(inputNumber.charAt(i)))
                throw new IllegalArgumentException();
            pitchNumbers.add(inputNumber.charAt(i)-'0');
        }
    }

}
