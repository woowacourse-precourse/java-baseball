package baseball;

import baseball.serviceImpl.ComputerDigitGeneratorService;
import baseball.serviceImpl.GameService;
import baseball.domain.game.Digits;
import baseball.domain.game.GameMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ComputerServiceTest extends NsTest {
    private static GameService gameService;

    @BeforeAll
    public static void beforeAll() {
        gameService = new GameService();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    public void 시작_메시지_테스트() {
        String input = GameMessage.START_MASSAGE.getMassage();
        OutputStream out = checkMessage(input);
        gameService.sendMassage(GameMessage.START_MASSAGE);
        assertThat(input).isEqualTo(out.toString());
    }

    @Test
    public void 시작_메시지_예외_테스트() {
        String input = GameMessage.START_MASSAGE.getMassage() + "exception";
        OutputStream out = checkMessage(input);
        gameService.sendMassage(GameMessage.START_MASSAGE);
        Assertions.assertThrows(org.opentest4j.AssertionFailedError.class, () -> {
            assertThat(input).isEqualTo(out.toString());
        });
    }

    @Test
    public void 컴퓨터_세자리_난수_테스트() {
        List<Integer> computer = gameService.getComputerDigits(new ComputerDigitGeneratorService());
        int size = computer.size();
        assertThat(size).isEqualTo(3);
    }

    @Test
    public void 컴퓨터_자리수_범위_예외_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gameService.getComputerDigits(() -> "1234");
        });
    }

    @Test
    public void 컴퓨터_난수_중복_없음_테스트() {
        List<Integer> computer = gameService.getComputerDigits(new ComputerDigitGeneratorService());
        boolean isDuplicated = isDuplicateDigit(computer);
        assertThat(isDuplicated).isEqualTo(false);
    }

    @Test
    public void 컴퓨터_난수_중복_예외_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gameService.getComputerDigits(() -> "113");
        });
    }

    @Test
    public void 허용되지_않는_숫자_예외_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gameService.getComputerDigits(() -> "017");
        });
    }

    private boolean isDuplicateDigit(List<Integer> digits) {
        int[] visited = new int[Digits.LAST.getDigit() + 1];
        for (Integer digit : digits) {
            if (visited[digit] == 1) return true;
            visited[digit]++;
        }
        return false;
    }

    private OutputStream checkMessage(String input) {
        input = GameMessage.START_MASSAGE.getMassage();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        return out;
    }
}