package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Pitch {

    private final List<Integer> pitchNumbers = new ArrayList<>();

    /**
     * 입력된 값에서 특정 자리의 값을 반환합니다.
     * @param index 인덱스
     * @return 해당 인덱스의 값
     */
    public int getNumber(int index){
        return pitchNumbers.get(index);
    }
    /**
     * 사용자에게 입력을 받은 수를 저장합니다.
     * @throws IllegalArgumentException 개수가 3개가 아닐 때
     * @throws IllegalArgumentException 숫자가 아닌 값이 입력됐을 때
     */
    public Pitch() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        if(inputNumber.length() != 3)
            throw new IllegalArgumentException();
        for(int i = 0; i < 3 ; i++){
            if(!Character.isDigit(inputNumber.charAt(i)))
                throw new IllegalArgumentException();
            pitchNumbers.add(inputNumber.charAt(i)-'0');
        }
    }

}
