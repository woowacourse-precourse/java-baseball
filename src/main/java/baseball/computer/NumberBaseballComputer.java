package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * 숫자 야구 게임 컴퓨터는 유저가 게임을 시작할 때 숫자 생성
 * 입력 값이 올바른지 적합성 판단
 * 스트라이크, 볼 여부 확인
 *
 * @version 1.0.0
 * @author chlskreh2
 */
public class NumberBaseballComputer implements Computer{

    /**
     * 서로 다른 임의의 수 3개를 생성
     */
    @Override
    public List<Integer> createOtherNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    /**
     * 사용자값을 확인하여 예외발생 시 종료 아닐 시
     * 볼, 스트라이크, 낫싱 출력
     */
    @Override
    public void printCorrectResult(String gameValueOfUser) {
        validateNumber(gameValueOfUser);
    }

    private int validateNumber(String gameValueOfUser) {
        try {
            int gameNumberOfUser = Integer.parseInt(gameValueOfUser);
            return gameNumberOfUser;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 잘못됐습니다.", e);
        }
    }
}
