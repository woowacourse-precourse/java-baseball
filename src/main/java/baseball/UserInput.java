package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public List<Integer> inputNumber(){
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumbers = Console.readLine();
        validateNumber(inputNumbers);

        return stringToList(inputNumbers);
    }

    private List<Integer> stringToList(String numbers){
        List<Integer> numberList = new ArrayList<>();

        for (char number : numbers.toCharArray())
            numberList.add(number - '0');
        return numberList;
    }
    private void validateNumber(String numbers) {
        if(numbers.length() != 3){
            throw new IllegalArgumentException("3자리 수를 입력하세요.");
        }
        for (char number : numbers.toCharArray()) {
            if(number <'1' || number > '9') throw new IllegalArgumentException("범위가 틀립니다. 1~9 사이의 수를 입력하세요");
        }
        List<Character> check = new ArrayList<>();
        for (char number : numbers.toCharArray()) {
            if(check.contains(number)) throw new IllegalArgumentException("중복된 숫자입니다.");
            check.add(number);
        }
    }
}
