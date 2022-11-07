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
        int gameNumberOfUser = validateUserNumber(gameValueOfUser);
        List<Integer> userNumber = ConvertUserNumber(gameNumberOfUser);
    }

    private int validateUserNumber(String gameValueOfUser) {
        try {
            int gameNumberOfUser = Integer.parseInt(gameValueOfUser);
            checkNumberRange(gameNumberOfUser);
            checkNumberNotSame(gameNumberOfUser);
            return gameNumberOfUser;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값 입력", e);
        }
    }

    private List<Integer> ConvertUserNumber(int gameNumberOfUser) {
        int hundredPlace = gameNumberOfUser / 100;
        int tenPlace = gameNumberOfUser / 10 % 10;
        int onePlace = gameNumberOfUser % 10;
        List<Integer> userNumber = List.of(hundredPlace, tenPlace, onePlace);
        return userNumber;
    }

    private void checkNumberRange(int gameNumberOfUser) {
        if (gameNumberOfUser < 100 || gameNumberOfUser > 999) {
            throw new IllegalArgumentException("3자리 미만이거나 3자리 초과 숫자 입력");
        }
    }

    private void checkNumberNotSame(int gameNumberOfUser) {
        int hundredPlace = gameNumberOfUser / 100;
        int tenPlace = gameNumberOfUser / 10 % 10;
        int onePlace = gameNumberOfUser % 10;
        if (hundredPlace == tenPlace || hundredPlace == onePlace || tenPlace == onePlace) {
            throw new IllegalArgumentException("3자리 숫자 중 중복되는 숫자 입력");
        }
    }
}
