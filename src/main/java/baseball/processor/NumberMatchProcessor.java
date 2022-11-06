package baseball.processor;

import java.util.List;

public interface NumberMatchProcessor {

    /**
     * game의 숫자와 user의 숫자를 입력받아
     * 스트라이크, 볼 갯수를 리턴한다.
     * 입력값이 3자리 숫자가 아닌경우 예외를 리턴한다.
     * @param gameNum - 현재 게임의 숫자
     * @param userNum - 유저 입력의 숫자
     * @return Integer List - [스트라이크 갯수, 볼 갯수]
     */
    List<Integer> compare(List<Integer> gameNum, List<Integer> userNum);


    /**
     * 스트라이크와 볼의 개수를 스트링형태로 파싱해준다.
     * @param targetList - 스트라이크와 볼의 개수가 들어있는 크기 2의 리스트
     */
    String printHint(List<Integer> targetList);

}
