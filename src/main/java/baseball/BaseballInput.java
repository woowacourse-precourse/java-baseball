package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballInput {

    public static int nextBaseballNum() throws IllegalArgumentException {
        return nextBaseballNum(Console.readLine());
    }

    public static int nextSelect() throws IllegalArgumentException {
        return nextSelect(Console.readLine());
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

    public static int nextSelect(String line) throws IllegalArgumentException {

        try {
            int num = Integer.parseInt(line);

            if (num == 1 || num == 2)
                return num;
            throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

}
