package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 입력 관련 기능을 처리하는 클래스
 */
public class IOManager {

    /**
     * @return 입력으로 주어진 숫자를 반환
     * @throws IllegalArgumentException 숫자가 아닌 입력이 들어오는 경우 예외 발생
     */
    public static Integer getNextInt() throws IllegalArgumentException {
        try {
            return Integer.parseInt(Console.readLine());

        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
    }

    /**
     * @param integer
     * @return 입력으로 주어진 숫자를 각 자리별로 쪼갠 숫자 배열로 변환
     */
    public static Integer[] splitIntegerIntoIntegerArray(Integer integer) {
        String[] strings = String.valueOf(integer).split("");

        return Arrays.stream(strings).map(Integer::parseInt).collect(Collectors.toList())
                .toArray(new Integer[strings.length]);
    }

    public static void print(String string) {
        System.out.print(string);
    }

    public static void println(String string) {
        System.out.println(string);
    }
}
