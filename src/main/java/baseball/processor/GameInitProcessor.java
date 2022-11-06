package baseball.processor;


import java.util.List;

public interface GameInitProcessor {

    /**
     * @param size
     * @return size 자리수의 숫자를 리턴한다.
     */
    List<Integer> randomNumber(Integer size);

    /**
     * 유저 입력을 받는 메소드
     * @return 입력값을 Integer 리스트로 반환한다.
     */
    List<Integer> userInput();

}
