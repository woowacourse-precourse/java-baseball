package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.*;
import java.util.regex.Pattern;


public class Application {
    public static final String STRIKE = "strike";
    public static final String BALL = "ball";

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
        validateAnswer(input);

        List<Integer> inputList = new ArrayList<>();
        for (String number : input.split("")){
            inputList.add(Integer.parseInt(number));
        }
        return inputList;
    }
    public static void validateAnswer(String answer) {
        String regexNumber = "^[1-9]*$";
        if(!Pattern.matches(regexNumber, answer)){
            throw new IllegalArgumentException("1~9까지의 숫자만 입력할 수 있습니다.");
        }
        if(answer.length() != 3){
            throw new IllegalArgumentException("3자리 숫자만 입력하여 주십시오.");
        }
        if(!isDuplication(answer)){
            throw new IllegalArgumentException("각 자리 수는 중복이 될 수 없습니다.");
        }
    }
    public static boolean isDuplication(String input) {
        List<String> duplicationCheckList = Arrays.asList(input.split(""));
        return duplicationCheckList.size() == duplicationCheckList.stream().distinct().count();
    }

    public static Map<String, Integer> createRefereeCount(List<Integer> baseballNumberList, List<Integer> inputNumberList) {
        Map<String, Integer> count = new HashMap<>(){{
            put(STRIKE,0);
            put(BALL,0);
        }};

        for (int i = 0; i < baseballNumberList.size(); i++) {
            int baseballNumber = baseballNumberList.get(i);
            int inputNumber = inputNumberList.get(i);
            if(baseballNumber == inputNumber){
                count.put(STRIKE, count.get(STRIKE) + 1);
            }
            if(baseballNumber != inputNumber && baseballNumberList.contains(inputNumber)){
                count.put(BALL, count.get(BALL) + 1);
            }
        }
        return count;
    }

}
