package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> myInputNumber = new ArrayList<>();

    public void inputNumber() throws IllegalArgumentException {
        myInputNumber.clear();

        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        System.out.println(inputNum);

        // 3자리 숫자가 아닌경우 예외
        if (inputNum.length() != 3) throw new IllegalArgumentException();
        for (int i = 0; i < 3; i++) {
            char charNum = inputNum.charAt(i);

            // 숫자가 아닐 경우 예외
            int ascii = (int)charNum;
            if (ascii<48 || ascii>57) throw new IllegalArgumentException();

            int num = Character.getNumericValue(charNum);

            // 중복된 숫자가 있을경우 예외
            if(myInputNumber.contains(num)) throw new IllegalArgumentException();

            myInputNumber.add(num);
        }
    }

}
