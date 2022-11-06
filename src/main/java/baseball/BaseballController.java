package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballController {
    // 숫자 야구 게임에서 사용할 숫자의 개수를 저장하는 변수
    private final int gameInputCount;
    // 숫자 야구게임의 Service 를 이용하기 위한 Service 객체
    private final BaseballService baseballService;

    /**
     * 게임에서 사용할 숫자의 개수를 지정하지 않을 경우 3으로 지정
     */
    public BaseballController() {
        this(3);
    }

    /**
     * 게임에서 사용할 숫자의 개수를 초기화 하고, baseballService 의 랜덤 숫자 리스트를 초기화 한다
     * @param gameInputCount : 게임에서 사용할 숫자의 개수
     */
    public BaseballController(int gameInputCount) {
        this.gameInputCount = gameInputCount;
        this.baseballService = new BaseballService(this.gameInputCount);
        baseballService.setAnswerNumberList();
    }

    /**
     * 플레이어가 입력한 숫자의 유효성을 검사하고 볼과 스트라이크의 개수를 반환한다
     * @param inputString : 사용자가 콘솔로 입력한 문자열
     * @return [ballCount, strikeCount] 형태의 배열
     */
    public List<Integer> getBallAndStrikeCount(String inputString) {
        if (inputString.length() != gameInputCount) {
            throw new IllegalArgumentException(gameInputCount + "자리의 숫자가 아님");
        }
        try {
            List<Integer> inputNumberList = stringToIntegerList(inputString);
            List<Integer> result = baseballService.getBallAndStrikeCounts(inputNumberList);

            return result;
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * 플레이어가 입력한 문자열에 중복된 숫자가 있는지 검사하고 숫자 배열로 변환한다
     * @param inputString : 사용자가 콘솔로 입력한 문자열
     * @return 문자열의 각 자리를 숫자로 바꾸어 리스트로 반환
     */
    private List<Integer> stringToIntegerList(String inputString) {
        List<Integer> result = new ArrayList<>();
        int number = Integer.valueOf(inputString);
        while (number > 0) {
            addUniqueDigitToBeginningOfList(extractLastDigit(number), result);
            number /= 10;
        }
        return result;
    }

    /**
     * 주어진 숫자의 1의 자리를 추출한다
     * @param number : 1의 자리를 추출할 숫자
     * @return : 추출한 1의자리 값
     */
    private int extractLastDigit(int number) {
        int result = number % 10;
        if (result == 0) {
            throw new RuntimeException("0을 입력함");
        }
        return result;
    }

    /**
     * 한 자리 숫자를 리스트의 맨 앞에 추가한다
     * @param digit : 추가할 한 자리 숫자
     * @param list : 한 자리 숫자를 추가할 리스트
     */
    private void addUniqueDigitToBeginningOfList(int digit, List<Integer> list) {
        if (list.contains(digit)) {
            throw new IllegalArgumentException();
        }
        list.add(0, digit);
    }

    /**
     * 게임 재시작 여부 명령어의 유효성을 검사하고 컴퓨터에게 새로운 숫자를 할당한다
     * @param inputCommand : 사용자가 콘솔로 입력한 재시작 여부 문자열
     * @return 재시작을 한다면 true, 재시작을 하지 않는다면 false
     */
    public boolean restartGame(String inputCommand) {
        return false;
    }
}
