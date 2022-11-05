package baseball.numbercomparator;

import java.util.List;
import java.util.Objects;

/**
 * 컴퓨터가 생성한 숫자와 사용자가 입력한 숫자를 비교하여 결과를 반환하는 로직과 관련된 클래스입니다.
 * @version 1.0.0
 * @author CHO MinHo
 */
public class NumberComparator {

    /**
     * 컴퓨터가 생성한 난수 리스트와 사용자가 입력한 숫자 리스트를 비교해, 스트라이크의 개수와 볼 개수를 반환하는 메서드입니다.
     * @param computerList 컴퓨터가 생성한 난수 3개를 가진 리스트
     * @param userList 사용자가 입력한 숫자 3개를 가진 리스트
     * @return 스트라이크 개수와 볼의 개수를 가지는 Score 클래스
     */
    public static Score calculateStrike(List<Integer> computerList, List<Integer> userList) {
        int strikeNum = 0;
        int ballNum = 0;
        for (int i = 0; i < 3; i++) {
            // 1. 같은 자리에 같은 수가 있는 경우
            if (Objects.equals(computerList.get(i), userList.get(i))) {
                strikeNum++;
            }
            // 2. 다른 자리에 같은 수가 있는 경우
            else if (computerList.contains(userList.get(i))) {
                ballNum++;
            }
        }
        return new Score(strikeNum, ballNum);
    }
}
