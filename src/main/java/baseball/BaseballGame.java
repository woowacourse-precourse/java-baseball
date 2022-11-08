package baseball;

import static baseball.Computer.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {
    private static final String START_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String INPUT_IS_NOT_INTEGER =
            "입력값에 숫자가 아닌 값이 포함되어 있습니다. 입력값의 범위 : 자연수";
    private static final String INPUT_SIZE_IS_NOT_THREE =
            "입력하신 숫자는 3자리 자연수가 아닙니다. 3자리 자연수를 입력해주세요.";
    private static final String INPUT_OVERLAPPING =
            "입력하신 숫자에 중복값이 포함되어 있습니다. 중복하지 않은 숫자 3자리를 입력해주세요.";
    private static final String INPUT_OUT_OF_RANGE =
            "입력하신 숫자가 범위를 초과하였습니다. 자연수 범위 : 1 ~ 9";

    private Computer computer;
    private int ball;
    private int strike;

    private List<Integer> userNumberList;

    public BaseballGame(Computer computer) {
        this.computer = computer;
        this.ball = 0;
        this.strike = 0;
    }

    /* 초기화 */
    public void init() {
        computer.init();
        ball = 0;
        strike = 0;
    }

    /* 게임 진행 */
    public void playBaseballGame() {
        while (strike < NUMBER_LENGTH) {
            // 숫자 입력
            System.out.print(START_MESSAGE);
            String userInput = readLine();

            // 숫자를 입력했는지 검증
            validInputDataType(userInput);

            // 입력한 숫자의 개수 및 중복 검증
            validNumberCountAndDuplication();

            // 입력한 숫자의 범위 검증
            validNumberRange();

            // 현재 상황 출력
            printCurrentStatus();
        }

        // 게임 종료 메세지
        System.out.println(SUCCESS_MESSAGE);
    }

    /* 숫자 입력 검증 */
    private void validInputDataType(String number){
        try {
            userNumberList = stringToIntegerList(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_IS_NOT_INTEGER);
        }
    }

    /* 개수 및 중복 검증 */
    private void validNumberCountAndDuplication(){
        if (userNumberList.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(INPUT_SIZE_IS_NOT_THREE);
        }

        if (userNumberList.stream().distinct().count() != userNumberList.size()) {
            throw new IllegalArgumentException(INPUT_OVERLAPPING);
        }
    }

    /* 범위 검증 */
    private void validNumberRange() {
        for (int userNumber : userNumberList) {
            if (userNumber < MIN_RANGE_NUMBER || userNumber > MAX_RANGE_NUMBER) {
                throw new IllegalArgumentException(INPUT_OUT_OF_RANGE);
            }
        }
    }

    /* 문자열을 정수 리스트로 변환 */
    private List<Integer> stringToIntegerList(String number) {
        String[] numberArray = number.split("");
        return Arrays
                .stream(numberArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    /* 현재 상태 출력 */
    private void printCurrentStatus() {
        StringBuilder stringBuilder = new StringBuilder();

        ball = computer.ballCount(userNumberList);
        strike = computer.strikeCount(userNumberList);

        if (ball > 0) {
            stringBuilder.append(ball)
                    .append(BALL_MESSAGE)
                    .append(" ");
        }

        if (strike > 0) {
            stringBuilder.append(strike)
                    .append(STRIKE_MESSAGE);
        }

        if (ball == 0 && strike == 0) {
            stringBuilder.append(NOTHING_MESSAGE);
        }

        System.out.println(stringBuilder);
    }
    
}
