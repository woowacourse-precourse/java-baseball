package baseball.Service.interfaces;

import baseball.Model.NumberItem;

import java.util.List;

public interface NumberService {

    Integer check_3_Digits_Number(List<Integer> numberList) throws IllegalArgumentException;

    Integer check_Each_Digit_Range(List<Integer> numberList) throws IllegalArgumentException;

    Integer check_Identical_Digit(List<Integer> numberList, int number) throws IllegalArgumentException;

    NumberItem createComputerNumber() throws IllegalArgumentException;

    NumberItem createUserNumber() throws IllegalArgumentException;


}
