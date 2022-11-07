package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballInput {

    /**
     * 중복 없는 3자리 수를 입력받는다.
     * @return 3자리 정수
     * @throws IllegalArgumentException 사용자의 입력에 숫자 형식이 잘못되었거나, 중복이 있을 경우 예외가 발생한다.
     */
    public static int nextBaseballNum() throws IllegalArgumentException {
        return nextBaseballNum(Console.readLine());
    }

    /**
     * 1 또는 2를 입력받는다.
     * @return 1을 입력 받으면 true / 2를 입력 받으면 false
     * @throws IllegalArgumentException 사용자가 1, 2 외의 다른 입력을 한 경우 예외가 발생한다.
     */
    public static boolean nextGameSelect() throws IllegalArgumentException {
        return nextGameSelect(Console.readLine());
    }

    public static int nextBaseballNum(String line) throws IllegalArgumentException {

        try {
            int num = Integer.parseInt(line);

            // 생성자를 이용해 입력 형식 테스트
            BaseballNum parseInput = new BaseballNum(num);

            return num;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        } catch (BaseballNum.NotBaseballNumException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    public static boolean nextGameSelect(String line) throws IllegalArgumentException {

        try {
            int num = Integer.parseInt(line);

            if (num == 1)
                return true;
            else if (num == 2)
                return false;

            throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

}
