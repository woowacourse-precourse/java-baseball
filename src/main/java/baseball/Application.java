package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static List<Integer> generateNumber(){
        List<Integer> num = new ArrayList<>();
        while (num.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!num.contains(randomNumber)) {
                num.add(randomNumber);
            }
        }
        return num;
    }
    public static void checkInput(String s){
        if (s.length() != 3){
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
        List<Integer> digits = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int digit = 0; digit < s.length(); digit++){
            if (!digits.contains(Character.getNumericValue(s.charAt(digit)))){
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
        }
        if ((s.charAt(0) == s.charAt(1)) || (s.charAt(0) == s.charAt(2)) || (s.charAt(1) == s.charAt(2))){
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해주세요.");
        }
    }
    public static List<Integer> getInput(){
        String num = Console.readLine();
        checkInput(num);
        List<Integer> number = new ArrayList<>();
        for (int digit = 0; digit < num.length(); digit++){
            number.add(Character.getNumericValue(num.charAt(digit)));
        }
        return number;
    }
    public static List<Integer> countAnswer(List<Integer> answer, List<Integer> input){
        List<Integer> result = new ArrayList<>(List.of(0, 0));
        for (int digit = 0; digit < 3; digit++){
            if (answer.get(digit).equals(input.get(digit))){
                result.set(1, result.get(1) + 1);
            }
            if ((answer.contains(input.get(digit))) && (!answer.get(digit).equals(input.get(digit)))){
                result.set(0, result.get(0) + 1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> input = getInput();
        List<Integer> test = countAnswer(answer, input);
        System.out.print(test);
    }
}
