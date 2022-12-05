package baseball;

import org.junit.jupiter.api.Test;

class ResultTest {
    @Test
    void 볼_스트라이크_문자열() {
        Result result = new Result();
        result.convertToString(3, 0);
        System.out.println(result.toString());
        result.convertToString(0, 3);
        System.out.println(result.toString());
        result.convertToString(1, 2);
        System.out.println(result.toString());
    }
}