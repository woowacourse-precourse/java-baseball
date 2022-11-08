package baseball;

import java.util.ArrayList;
import java.util.List;

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
}
