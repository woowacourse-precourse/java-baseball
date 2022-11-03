package baseball.controller;

import baseball.utils.InputValidation;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class InputController {
    InputValidation inputValidation = new InputValidation();
    public List<Integer> insertComNumber() {
        List<Integer> insertNum = new ArrayList<>();
        while(insertNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!insertNum.contains(randomNumber)) {
                insertNum.add(randomNumber);
            }
        }
        return insertNum;
    }

    public List<Integer> insertUserNumber() {
        List<Integer> insertNum = new ArrayList<>();
        String input = Console.readLine();
        if(!inputValidation.userInputValidation(input)) {
            throw new IllegalArgumentException();
        }
        insertNum = stringToListNumber(input);
        return insertNum;
    }

    public List<Integer> stringToListNumber(String usernumber) {
        List<Integer> usernumtolist = new ArrayList<>();
        for(int i=0; i<usernumber.length(); i++) {
            int digit = usernumber.charAt(i) - '0';
            usernumtolist.add(digit);
        }
        return usernumtolist;
    }
}
