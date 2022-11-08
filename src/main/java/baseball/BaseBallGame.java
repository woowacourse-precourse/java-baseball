package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGame implements GameInterface {

    /**
     * 임의의 세 자리 수를 반환합니다.
     */
    public String getComputerNum() {
        List<Integer> computerNumList = new ArrayList<>();
        return getNumByDigit(computerNumList, 3);
    }

    /**
     * 9 이하 숫자, 빈 리스트를 받습니다. 중복되지 않은 3가지의 숫자로 이루어진 문자열을 반환합니다.
     */
    public String getNumByDigit(List<Integer> emptyList, Integer digit) {
        while (emptyList.size() < digit) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!emptyList.contains(randomNumber)) {
                emptyList.add(randomNumber);
            }
        }
        return emptyList.toString();
    }

}
