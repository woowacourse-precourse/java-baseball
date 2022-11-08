package baseball;

import baseball.serviceImpl.GameService;
import baseball.domain.game.Digits;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest extends NsTest {
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
    public void 유저_세자리_입력_테스트() {
        List<Integer> user = gameService.getUserDigits("123");
        int size = user.size();
        assertThat(size).isEqualTo(3);
    }

    @Test
    public void 유저_자리수_범위_예외_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gameService.getUserDigits("1234");
        });
    }

    @Test
    public void 유저_난수_중복_없음_테스트() {
        List<Integer> user = gameService.getUserDigits("489");
        boolean isDuplicated = isDuplicateDigit(user);
        assertThat(isDuplicated).isEqualTo(false);
    }

    @Test
    public void 유저_난수_중복_예외_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gameService.getUserDigits("113");
        });
    }

    @Test
    public void 허용되지_않는_숫자_예외_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gameService.getUserDigits("017");
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
}