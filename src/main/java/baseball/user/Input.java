package baseball.user;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자의 입력을 받는 기능
 * 입력받은 숫자의 유효성을 파악하는 기능
 * 을 가진 클래스입니다.
 */
public class Input {

    public Input(){}

    /**
     * 문자열로 받은 입력값을 숫자 리스트로 반환하는 메소드
     * @param inputString 문자열로 입력받은 값
     * @return 입력받은 숫자를 넣은 리스트
     */
    public List<Integer> inputDigit(String inputString){
        List<Integer> inputDigit = new ArrayList<>();

        for(int inputStringIdx=0; inputStringIdx<inputString.length(); inputStringIdx++){
            inputDigit.add(inputString.charAt(inputStringIdx) - '0');
        }

        return inputDigit;
    }


}
