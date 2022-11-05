package baseball.Service.impl;


import baseball.Model.NumberItem;
import baseball.Service.interfaces.NumberService;

import camp.nextstep.edu.missionutils.Randoms;

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
}
