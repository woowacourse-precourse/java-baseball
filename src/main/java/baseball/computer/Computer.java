package baseball.computer;

import java.util.List;

/**
 * 컴퓨터는 유저가 게임을 시작할 때 게임의 룰에 따라 작동
 *
 * @version 1.0.0
 * @author chlskreh2
 */
public interface Computer {

    /**
     * 서로 다른 숫자들을 생성
     */
    List<Integer> createOtherNumber();
}
