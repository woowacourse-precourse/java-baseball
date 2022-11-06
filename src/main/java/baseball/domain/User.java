package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static constant.Constants.INPUT_MSG;
import static constant.Constants.ballSize;

public class User extends Player {

    public void scanUserNums() {
        System.out.print(INPUT_MSG);
        String inputNums = Console.readLine();
        checkingNums(inputNums);
        List<Integer> inputNumsList = inputToList(inputNums);
        setNums(inputNumsList);
    }

    public void checkingNums(String inputNums) {
        if (isErrorInputNums(inputNums)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isErrorInputNums(String inputNums) {
        List<Integer> inputNumsList = new ArrayList<>();

        if (inputNums.length() != ballSize) return true; //3개의 숫자가 들어오지 않은 경우
        for (int i = 0; i < ballSize; i++) {
            char eachNumC = inputNums.charAt(i);
            if (eachNumC < '1' || '9' < eachNumC) return true;// 숫자의 범위에 해당하지 않는경우, 숫자가 아닌경우

            int eachNumI = eachNumC - '0';
            if (inputNumsList.contains(eachNumI)) return true; //각각의 다른숫자가 아닌경우
            inputNumsList.add(eachNumI);
        }
        return false;
    }


    public List<Integer> inputToList(String inputNums) {
        List<Integer> inputNumsList = new ArrayList<>();
        for (int i = 0; i < ballSize; i++) {
            int eachNumI = inputNums.charAt(i) - '0';
            inputNumsList.add(eachNumI);
        }
        return inputNumsList;
    }


    @Override
    public String toString() {
        return "User" + super.toString();
    }
}
