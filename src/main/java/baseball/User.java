package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User extends Player {
    private static final String INPUT_MSG = "숫자를 입력해주세요 : ";

    public void scanUserNums() {
        System.out.print(INPUT_MSG);
        String inputNums = Console.readLine();
        List<Integer> inputNumsList = new ArrayList<>();

        if (checkInputNums(inputNums, inputNumsList)) {
            throw new IllegalArgumentException();
        }
        setNums(inputNumsList);
    }

    private boolean checkInputNums(String inputNums, List<Integer> inputNumsList) {
        if (inputNums.length() != 3) return true; //3개의 숫자가 들어오지 않은 경우
        for (int i = 0; i < 3; i++) {
            char eachNumC = inputNums.charAt(i);
            if (eachNumC < '1' || '9' < eachNumC) return true;// 숫자의 범위에 해당하지 않는경우, 숫자가 아닌경우
            int eachNumI = eachNumC - '0';
            if (inputNumsList.contains(eachNumI)) return true;
            inputNumsList.add(eachNumI);
        }
        return false;
    }


    @Override
    public String toString() {
        return "User" + super.toString();
    }
}
