package baseball.Service.impl;


import baseball.Model.NumberItem;
import baseball.Service.interfaces.NumberService;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.Model.StatusItem.NUMBER_SIZE;

public class NumberServiceImpl implements NumberService {

    @Override
    public Integer check_3_Digits_Number(List<Integer> numberList) throws IllegalArgumentException {
        if(numberList.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
        return 0;
    }

    @Override
    public Integer check_Each_Digit_Range(List<Integer> numberList) throws IllegalArgumentException {
        for(int index = 0 ; index < NUMBER_SIZE ; index++){
            if ( numberList.get(index) < 1 || numberList.get(index) > 9 ) {
                throw new IllegalArgumentException();
            }
        }
        return 0;
    }
    @Override
    public Integer check_Identical_Digit(
            List<Integer> numberList, int number) throws IllegalArgumentException {

        if(!(numberList.contains(number)))
            numberList.add(number);
        else {
            throw new IllegalArgumentException();
        }
        return 0;
    }

    @Override
    public NumberItem createComputerNumber() throws IllegalArgumentException{
        NumberItem computerNumberItem = new NumberItem();

        List<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        check_3_Digits_Number(computerNumberList);
        check_Each_Digit_Range(computerNumberList);

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
            check_Identical_Digit(userNumberList, userNumberOnebyOneInt);
        }

        check_3_Digits_Number(userNumberList);
        check_Each_Digit_Range(userNumberList);

        userNumberItem.setNumber(userNumberList);

        return userNumberItem;
    }
}
