package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerNumber = makeRandomNumber();

        while(true) {

            String userNumber = Console.readLine();

            //제한사항 체크
            try {
                validate(userNumber);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e);
            }

            // 맞춘다면 반복문 빠져나오기
            if (computerNumber.equals(userNumber)) break;
        }
    }

    public static List<Integer> makeRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) { //중복 방지
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static String inputUserNumber(){
        System.out.println("숫자를 입력해주세요 :");
        String userNumber = Console.readLine();

        return userNumber;
    }

    public static void validate(String userNumber){
        for(char number : userNumber.toCharArray()){
            // 중복된 숫자가 있으면 예외
            if( userNumber.chars().filter(c -> c == number).count() > 1 ){
                throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다!");
            }

            // 숫자가 아니면 예외
            if(Character.isDigit(number)==false){
                throw new IllegalArgumentException("숫자 이외의 값을 입력하셨습니다!");
            }
        }
    }

}
