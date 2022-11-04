package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.*;
import java.util.regex.Pattern;


public class Application {

    public static void main(String[] args) {

    }

    public static List<Integer> createBaseballNumberList() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }

    public static List<Integer> createInputNumberList(String input) {
        List<Integer> inputList = new ArrayList<>();
        for (String number : input.split("")){
            inputList.add(Integer.parseInt(number));
        }
        return inputList;
    }

}
