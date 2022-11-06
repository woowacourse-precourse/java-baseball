package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerNum implements Number {


    @Override
    public void verifyNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException();
            } else if (numbers.size() != 3 || numbers.size() != numbers.stream().distinct().count() ) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public List<Integer> createNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> number = Arrays.asList(Integer.parseInt(input));
        return number;
    }

    public void verifyInput(String input){
        char arr[] = input.toCharArray();
        for(int i =0; i < arr.length; i++){
            if(Character.isDigit(arr[i]) == true){
                continue;
            }else{
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> transformInput(String input){
        List<Integer> number = new ArrayList<>();;
        number.add(Integer.parseInt(input) / 100);
        number.add((Integer.parseInt(input) % 100) / 10);
        number.add((Integer.parseInt(input) % 100) % 10);
        return number;
    }

}
