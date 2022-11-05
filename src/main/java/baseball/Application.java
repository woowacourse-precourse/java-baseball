package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> createRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static int getInputNumber (){
        String input;
        int number = 0;
        try {
            input = Console.readLine();
            number = Integer.parseInt(input);
            if (number<100 || number>999)
                throw new IllegalStateException();
        }
        catch (IllegalStateException e){
            e.printStackTrace();
            throw e;
        }
        return number;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
