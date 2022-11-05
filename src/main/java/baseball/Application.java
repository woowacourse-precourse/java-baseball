package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

public static void setUserNumbers(){
        String inputNumber;
        inputNumber = readLine();
        List<Integer> userNumbers = new ArrayList<>();
        userNumbers = changeIntUsernumbers(inputNumber);
}

public static List<Integer> changeIntUsernumbers(String inputNubmers){
        String[] splitNumber = inputNubmers.split("");
        int[] splitIntNumber = new int[3];
        List<Integer> userNumbers = new ArrayList<>();

        for(int i =0;i<splitNumber.length;i++){
            splitIntNumber[i] = Integer.parseInt(splitNumber[i]);
            userNumbers.add(splitIntNumber[i]);
        }

        return userNumbers;
}

    public static void playBaseball(){
        /*List<Integer> computerNumbers = new ArrayList<>();
        computerNumbers = setComputerNumbers(computerNumbers);
        for(int numbers : computerNumbers) System.out.println(numbers); //난수 출력 확인.*/
        Computer computerNumber = new Computer();
        computerNumber.setComputerNumbers();

        for (Integer a : computerNumber.computerNumbers) {
            System.out.println(a);
        }

//        setUserNumbers();
    }

    public static void main(String[] args) {
        playBaseball();
    }
}

