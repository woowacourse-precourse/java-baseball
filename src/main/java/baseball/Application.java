package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        while(true){
            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.print("숫자를 입력해주세요 :");
            String input = Console.readLine();
            validation(input);


        }

    }

    public static void validation(String input){
        if(input.length() != 3)  throw new IllegalArgumentException();
        Long number = input.chars().filter(c->(c >= '1' && c <= '9')).count();
        if(number != 3) throw new IllegalArgumentException();

    }
    public static List<Integer> convert(String input){
        List<Integer> convertResult = new ArrayList<>();
        for(int i = 0;i<input.length();i++){

            Integer element = Integer.parseInt(input.substring(i, i + 1));
            convertResult.add(element);
        }
        return convertResult;
    }


}
