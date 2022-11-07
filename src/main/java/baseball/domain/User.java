package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static constant.Constants.*;

public class User extends Player {

    public void scanUserNums() {
        System.out.print(INPUT_MSG);
        String inputNums = Console.readLine();
        checkingNums(inputNums);
        setNums(inputsToList(inputNums));
    }

    public boolean scanWantReplayingGame(){
        System.out.println(CHECKING_REPLAYING_MSG);
        int userStatus = Integer.parseInt(Console.readLine());

        if (userStatus == wantReplay) return true;
        else if (userStatus == wantEnd) return false;
        else throw new IllegalArgumentException();
    }

    public void checkingNums(String inputNums) {
        if (isErrorInputNums(inputNums)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isErrorInputNums(String inputNums) {
        List<Integer> inputNumsList = new ArrayList<>();
        //3개의 숫자가 들어오지 않은 경우
        if (inputNums.length() != ballSize) return true;
        for (int i = 0; i < ballSize; i++) {
            char eachNumC = inputNums.charAt(i);
            // 숫자의 범위에 해당하지 않는경우, 숫자가 아닌경우
            if (eachNumC < '1' || '9' < eachNumC) return true;

            int eachNumI = eachNumC - '0';
            //각각의 다른 숫자가 아닌경우
            if (inputNumsList.contains(eachNumI)) return true;
            inputNumsList.add(eachNumI);
        }
        return false;
    }

    public List<Integer> inputsToList(String inputNums) {
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
