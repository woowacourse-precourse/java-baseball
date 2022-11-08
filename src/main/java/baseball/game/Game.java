package baseball.game;

import baseball.controller.RandomInRange;

/**
 * 컨트롤러에서 작동시킬 수 있는 게임의 interface입니다
 * 컨트롤러에서는 Game의 play 메서드를 호출합니다
 */
public interface Game {

    void play(RandomInRange randomGenerator);
}
