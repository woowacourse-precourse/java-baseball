package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static List<Integer> setComputerNumbers(List<Integer> computerNumbers){

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }

        return computerNumbers;
    }

public static void setUserNumbers(){
        String inputNumber;
        inputNumber = readLine();
        List<Integer> userNumbers = new ArrayList<>();
        userNumbers = changeIntUsernumbers(inputNumber);

        // int 변경 확인을 위한 테스트 출력
        System.out.println(userNumbers.get(1)+ userNumbers.get(2));
        System.out.println(userNumbers.get(0)+ userNumbers.get(1));
        System.out.println(userNumbers.get(1));
        System.out.println(userNumbers.get(2));
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

        setUserNumbers();
    }

    public static void main(String[] args) {
        playBaseball();
    }
}

