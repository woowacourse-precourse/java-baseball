package baseball.player;

import java.util.List;

public interface JudgeAble {

    /**
     * 상대방의 숫자를 받아 자신의 숫자와 비교하여 힌트를 반환하는 메서드이다.
     * @param playerNumbers 상대방의 숫자이다.
     * @return 비교한 결과를 List 형식으로 반환하고 첫 번째가 Ball 그리고 두 번째가 Strike다.
     */
    public List<Integer> judge(PlayerNumbers playerNumbers);


}
