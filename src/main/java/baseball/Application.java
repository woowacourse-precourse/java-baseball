package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
public class Application {
    public static void main(String[] args) {

    }
}

class Computer {
    List<Integer> pickRandomNumber(){
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3){
            int number = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(number)){
                answer.add(number);
            }
        }
        return answer;
    }
}

class User {
    public static int getInputNumber(){
        String input = Console.readLine();
        int inputNumber = Integer.parseInt(input);
        System.out.println(inputNumber);
        return inputNumber;
    }
}
