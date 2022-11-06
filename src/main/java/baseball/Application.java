package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    static List<Integer> getInputNumber (){
        String input;
        int inputNumber = 0;
        try {
            input = Console.readLine();
            inputNumber = Integer.parseInt(input);
            if (inputNumber<100 || inputNumber>999)
                throw new IllegalArgumentException();
        }
        catch (IllegalStateException e){
            e.printStackTrace();
            throw e;
        }

        List<Integer> number = new ArrayList<>();
        int cnt=100;
        for (int i = 0; i < 3; i++) {
            number.add(inputNumber/cnt);
            inputNumber %= cnt;
            cnt/=10;
        }

        return number;
    }
    static int checkBall(int index,int value, List<Integer> computer){
        int Ball=0;
        for (int i = 0; i < 3; i++) {
            if(Objects.equals(value, computer.get(i)) && index!=i)
                Ball++;
        }
        return Ball;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
