package baseball.player;

import java.util.List;

/**
 * 게임에 참가하는 개체의 행위를 정의한다.
 */
public interface Playable {

    List<Integer> getAnswer();

    void inputAnswer();
}
