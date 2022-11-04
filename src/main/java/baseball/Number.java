package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Number {

    public static List<Integer> getRandomNumber(){

        List<Integer> number = new ArrayList<>();

        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }

        return number;
    }

    public static List<Integer> inputUserNumber(){

        String userNumberString = Console.readLine();
        List<Integer> userNumberList = Arrays.stream(userNumberString.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        checkUserNumberLength(userNumberList);
        checkUserNumberDuplicate(userNumberList);
        checkUserNumberRange(userNumberList);

        return userNumberList;
    }

    public static List<Integer> inputNumberForTest(String number){

        String userNumberString = number;
        List<Integer> userNumberList = Arrays.stream(userNumberString.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        checkUserNumberLength(userNumberList);
        checkUserNumberDuplicate(userNumberList);
        checkUserNumberRange(userNumberList);

        return userNumberList;
    }

    public static void checkUserNumberLength(List<Integer> userNumberList){

        if(userNumberList.size() != 3){
            throw new IllegalArgumentException();
        }
    }

    public static void checkUserNumberDuplicate(List<Integer> userNumberList){

        Set<Integer> numSet = new HashSet<>(userNumberList);

        if(numSet.size()!= userNumberList.size()){
            throw new IllegalArgumentException();
        }
    }

    public static void checkUserNumberRange(List<Integer> userNumberList){

        if (userNumberList.contains(0)){
            throw new IllegalArgumentException();
        }
    }
}
