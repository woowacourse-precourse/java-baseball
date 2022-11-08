package baseball;

import java.util.ArrayList;
import java.util.List;
import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    private List<Integer> userNumbers = new ArrayList<>();

    public void inputMessage(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void setUserNumbers(){
        String inputNumber;
        inputMessage();
        inputNumber = readLine();
        checkException(inputNumber);
    }
    public List<Integer> getUserNumbers(){
        return userNumbers;
    }

    public void checkException(String inputNumber){
        try{
            checkWrongNumber(inputNumber);
            checkNumbersLength(inputNumber);
            checkOverlapNumber(inputNumber);
            //예외가 발생하지 않는다면 suerNumbers를 Integer값으로 변경한다.

            userNumbers = changeIntUsernumbers(inputNumber);

        } catch (IllegalArgumentException e){
            System.out.println(e.toString());
            ERROR = 2;
            return ;
        }
    }

    public void checkNumbersLength(String inputNumber){
        if(inputNumber.length() != 3 ) {
            ERROR = 2;
            throw new IllegalArgumentException("3개의 정수를 입력 해야합니다.");
        }
    }

    public void checkOverlapNumber(String inputNumber){
        String checkOverlap ="";

        for(char number : inputNumber.toCharArray()){
            String checkNumber = String.valueOf(number);
            if(checkOverlap.contains(checkNumber)) throw new IllegalArgumentException("중복된 숫자가 입력됐습니다.");
            checkOverlap += checkNumber;
        }
    }

    public void checkWrongNumber(String inputNumber){
        if(inputNumber.contains("0")) throw new IllegalArgumentException("0을 선택할 수 없습니다.");
    }

    public List<Integer> changeIntUsernumbers(String inputNubmers){
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
