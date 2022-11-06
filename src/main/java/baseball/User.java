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
        checkException(inputNumber);
    }

    public static void checkException(String inputNumber){
        try{
            checkWrongNumber(inputNumber);
            checkNumbersLength(inputNumber);
            checkOverlapNumber(inputNumber);
            //예외가 발생하지 않는다면 suerNumbers를 Integer값으로 변경한다.
            userNumbers = new ArrayList<>();
            userNumbers = changeIntUsernumbers(inputNumber);

        } catch (IllegalArgumentException e){
            System.out.println(e.toString());
            return ;
        }
    }

    public static void checkNumbersLength(String inputNumber){
        if(inputNumber.length() != 3 ) throw new IllegalArgumentException("3개의 정수를 입력 해야합니다.");
    }

    public static void checkOverlapNumber(String inputNumber){
        String checkOverlap ="";

        for(char number : inputNumber.toCharArray()){
            String checkNumber = String.valueOf(number);
            if(checkOverlap.contains(checkNumber)) throw new IllegalArgumentException("중복된 숫자가 입력됐습니다.");
            checkOverlap += checkNumber;
        }
    }

    public static void checkWrongNumber(String inputNumber){
        if(inputNumber.contains("0")) throw new IllegalArgumentException("0을 선택할 수 없습니다.");
    }

    public static List<Integer> changeIntUsernumbers(String inputNubmers){
        String[] splitNumber = inputNubmers.split("");
        int[] splitIntNumber = new int[splitNumber.length];
        List<Integer> userNumbers = new ArrayList<>();

        for(int i =0;i<splitNumber.length;i++){
            splitIntNumber[i] = Integer.parseInt(splitNumber[i]);
            userNumbers.add(splitIntNumber[i]);
        }

        return userNumbers;
    }

}
