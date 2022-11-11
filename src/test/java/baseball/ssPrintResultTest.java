package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ssPrintResultTest {

    public static ssPrintResult print = new ssPrintResult();
    private static final String FINAL = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    @Test
    void 사용자가_보는_출력물_확인() {

        assertAll(
                () -> assertEquals(print.printResult(2, 1), "1볼2스트라이크"),
                () -> assertEquals(print.printResult(0, 1), "1볼"),
                () -> assertEquals(print.printResult(1, 0), "1스트라이크"),
                () -> assertEquals(print.printResult(3, 0), "3스트라이크" + "\n" + FINAL),
                () -> assertEquals(print.printResult(0, 0), "낫싱")
        );

    }

    @Test
    void 다시게임_물어보기_및_예외사항_확인() {

        assertAll(
                () -> assertTrue(print.inputExit("2")),
                () -> assertTrue(print.inputExit("1")),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    print.inputExit("3");
                }),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    print.inputExit("a");
                })

        );

    }

}