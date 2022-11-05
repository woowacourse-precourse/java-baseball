package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static List<Integer> makeNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static List<Integer> inputNumber(){
        List<Integer> inputNumber = new ArrayList<>();
        String input = new String();
        input= Console.readLine();
        for(int i=0; i<input.length();i++){
            inputNumber.add(input.charAt(i)-'0');
        }
        return inputNumber;
    }
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        List<Integer> myNum = new ArrayList<>();
        computer = makeNumber();
        myNum = inputNumber();
        System.out.println(computer);
        System.out.println(myNum);

        }
    }

