package baseball.user;

import baseball.exception.UserInputException;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserFunction {

    public List<Integer> createUserList(String input) {
        if (!inputLengthCheck(input)) {
            throw new UserInputException();
        }

        if (!inputCheckInt(input)) {
            throw new UserInputException();
        }

        int[] ints = inputToIntArr(input);

        if (!intArrValidation(ints)) {
            throw new UserInputException();
        }

        List<Integer> inputNumList = intArrToCollectionList(ints);

        if (!collectionListValidation(inputNumList)) {
            throw new UserInputException();
        }

        return inputNumList;
    }

    public String requestInputData() {
        return Console.readLine();
    }

    public boolean inputLengthCheck(String input) {
        if (input.length() == 3) {
            return true;
        }
        return false;
    }


    public boolean inputCheckInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public int[] inputToIntArr(String input) {
        return Stream.of(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }


    public boolean intArrValidation(int[] intArr) {
        for (int inputNum : intArr) {
            if (!(1 <= inputNum && inputNum <= 9)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> intArrToCollectionList(int[] intArr) {
        return Arrays
                .stream(intArr)
                .boxed()
                .collect(Collectors.toList());
    }


    public boolean collectionListValidation(List<Integer> list) {
        long checkDataSize = list
                .stream()
                .distinct()
                .count();
        if (list.size() != checkDataSize) {
            return false;
        }
        return true;
    }
}
