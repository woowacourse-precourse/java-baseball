package baseball.model;

import java.util.LinkedHashSet;
import java.util.Set;



public class Nums {
    public Integer[] inputNums;

    public Nums(String inputData) {
        if (!isNotNumber(inputData)) throw new IllegalArgumentException("숫자가 아닌 문자 포함");
        Set<Integer> sets = inputToSet(inputData);
        if (!isValidSetSize(sets)) throw new IllegalArgumentException("중복된 숫자 존재");
        this.inputNums = sets.toArray(new Integer[3]);
    }
    public static boolean isNotNumber(String input) {
        for (int i = 0; i <input.length() ; i++) {
            char tempCharacter = input.charAt(i);
            if(!(tempCharacter>='0'&&tempCharacter<='9')) return false;
        }
        return true;
    }
    public static boolean isValidSetSize(Set set) {
        return set.size() == 3;
    }
    public static Set<Integer> inputToSet(String userInput) {
        String[] splitUserInput = userInput.split("");
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            set.add(Integer.parseInt(splitUserInput[i]));
        }
        return set;
    }
}
