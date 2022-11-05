package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    static List<Integer> userNumbers;

    public static void inputMessage(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void setUserNumbers(){
        String inputNumber;
        inputMessage();
        inputNumber = readLine();
        userNumbers = new ArrayList<>();
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
}
