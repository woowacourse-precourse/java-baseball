package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

}
