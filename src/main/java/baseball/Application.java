package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Application {
    public static void main(String[] args) {
        startNumberBaseballGame();
    }

    static List<Integer> answerRandomNumber = new ArrayList<>();
    static void startNumberBaseballGame(){

    }
    static List<Integer> getAnswerRandomNumber(){
        // 랜덤 3자리 숫자 생성
        while(answerRandomNumber.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!answerRandomNumber.contains(randomNumber)){
                answerRandomNumber.add(randomNumber);
            }
            else{
                System.out.println("랜덤숫자 중복됨. 다시 부여.");
            }
        }
        return answerRandomNumber;
    }
    static Integer stringToInteger(String input){
        try{
            Integer answer = Integer.parseInt(input);
            return answer;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    static List<Integer> getListByInputNumber (String inputNumber){

        String number = inputNumber;

        Integer inputNumberStringToInteger = stringToInteger(number);

        List<Integer> listByInputNumber = new ArrayList<>();

        while(inputNumberStringToInteger!=0){
            if(listByInputNumber.contains(inputNumberStringToInteger%10)){
                throw new IllegalArgumentException();
            } else {
                listByInputNumber.add(inputNumberStringToInteger%10);
                inputNumberStringToInteger = inputNumberStringToInteger/10;
            }
        }

        if(listByInputNumber.size() != 3){
            throw new IllegalArgumentException();
        }

        Collections.reverse(listByInputNumber);

        System.out.println("입력 숫자 = "+listByInputNumber);

        return listByInputNumber;
    }
}
