package baseball.player.playerInterface;

import baseball.player.playerMember.PlayerNumbers;
import baseball.uitls.Hints;

public interface JudgeAble {

    /**
     * 상대방의 숫자를 받아 자신의 숫자와 비교하여 힌트를 반환하는 메서드이다.
     * @param playerNumbers 상대방의 숫자이다.
     * @return 비교한 결과를 Hints 값 객체로 반환한다.
     */
    public Hints judge(PlayerNumbers playerNumbers);


}
