package baseball;

import java.util.regex.Pattern;

public class Validation {
    public void validateUserNumber(String userNumber){
        if(userNumber.length() != 3){
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요!");
        }

        for(char number : userNumber.toCharArray()){
            // 중복된 숫자가 있으면 예외
            if( userNumber.chars().filter(c -> c == number).count() > 1 ){
                throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다!");
            }

            // 숫자가 아니면 예외
            if(Character.isDigit(number)==false){
                throw new IllegalArgumentException("숫자 이외의 값을 입력하셨습니다!");
            }

            // 숫자의 범위는 1~9 즉 0은 포함되지 않는다.
            if(number == '0'){
                throw new IllegalArgumentException("각 자리 숫자의 범위는 1~9 입니다!");
            }
        }
    }

    public void validateGameCoin(String gameCoin) {
        // 1,2가 아니면 exception
        if(Pattern.matches("[1-2]",gameCoin) == false){
            throw new IllegalArgumentException("1,2 이외의 값을 입력하셨습니다!");
        }
    }
}
