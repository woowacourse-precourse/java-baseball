package baseball.model;

import baseball.util.Message;

import java.util.ArrayList;
import java.util.List;
/*
숫자가 입력받았을때 확인할 예외들
 */
public class NumberCheckList {
    public final int MIN_RANGE_NUM = 1;
    public final int MAX_RANGE_NUM = 9;
    public final static int MAX_NUMBER_SIZE = 3;

    public static void isIntegerCheck(String Number){
        for(int i = 0; i < MAX_NUMBER_SIZE; i++){
            if(!Character.isDigit(Number.charAt(i))){
                throw new IllegalArgumentException(Message.NOT_NUMBER_MESSAGE);
            }
        }
    }

    public static void isSizeCheck(String Number) throws IllegalArgumentException{
        if(Number.length() != MAX_NUMBER_SIZE) {
            throw new IllegalArgumentException(Message.NOT_THREE_DIGIT_NUMBER_MESSAGE);
        }
    }

    public static void isOverLapCheck(String Number) throws IllegalArgumentException{
        List<Character> CheckList = new ArrayList<>();
        for(int i = 0; i < MAX_NUMBER_SIZE; i++){
            if(CheckList.contains(Number.charAt(i))){
                throw new IllegalArgumentException(Message.IS_OVER_LAP_NUMBER_MASSAGE);
            }
            CheckList.add(Number.charAt(i));
        }
    }

}
