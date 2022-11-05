package baseball.Service.impl;


import baseball.Model.NumberItem;
import baseball.Service.interfaces.NumberService;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class NumberServiceImpl implements NumberService {

    @Override
    public NumberItem createComputerNumber() throws IllegalArgumentException{
        NumberItem computerNumberItem = new NumberItem();

        List<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }

        computerNumberItem.setNumber(computerNumberList);

        return computerNumberItem;
    }

    @Override
    public NumberItem createUserNumber() throws IllegalArgumentException{
        NumberItem userNumberItem = new NumberItem();

        List<Integer> userNumberList = new ArrayList<>();

        String userNumberStr = Console.readLine();
        for(int index = 0; index < userNumberStr.length() ; index++){
            String userNumberOnebyOneChar = userNumberStr.substring(index,index+1);
            int userNumberOnebyOneInt = Integer.parseInt(userNumberOnebyOneChar);
            userNumberList.add(userNumberOnebyOneInt);
        }

        userNumberItem.setNumber(userNumberList);

        return userNumberItem;
    }
}
