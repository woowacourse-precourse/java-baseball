package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameServerTest {
    @Test
    void 랜덤_번호_생성() {
        GameServer gameserver = new GameServer();
        gameserver.createRandomNumber();
        for (int i = 0; i < 3; i++) {
            assertThat(gameserver.computerNumbers).containsOnlyOnce(gameserver.computerNumbers.get(i));
        }
    }

    @Test
    void 출력결과확인_1() {
        GameServer gameserver = new GameServer();
        gameserver.computerNumbers = List.of(4, 2, 5);
        gameserver.setUserNumber("123");
        gameserver.checkUsersInputIsAnswer();
        assertThat(gameserver.strike).isEqualTo(1);
        assertThat(gameserver.ball).isEqualTo(0);
    }

    @Test
    void 출력결과확인_2() {
        GameServer gameserver = new GameServer();
        gameserver.computerNumbers = List.of(4, 2, 5);
        gameserver.setUserNumber("456");
        gameserver.checkUsersInputIsAnswer();
        assertThat(gameserver.strike).isEqualTo(1);
        assertThat(gameserver.ball).isEqualTo(1);
    }

    @Test
    void 출력결과확인_3() {
        GameServer gameserver = new GameServer();
        gameserver.computerNumbers = List.of(4, 2, 5);
        gameserver.setUserNumber("789");
        gameserver.checkUsersInputIsAnswer();
        assertThat(gameserver.strike).isEqualTo(0);
        assertThat(gameserver.ball).isEqualTo(0);
    }

    @Test
    void 사용자_입력_서로다른3자리수() {
        GameServer gameserver = new GameServer();
        assertThrows(IllegalArgumentException.class, () -> {
            gameserver.catchInputException("111");
        });
    }

    @Test
    void 사용자_입력_3자리수_아닌경우() {
        GameServer gameserver = new GameServer();
        assertThrows(IllegalArgumentException.class, () -> {
            gameserver.catchInputException("1234");
        });
    }

    @Test
    void 사용자_입력_숫자_아닌거포함() {
        GameServer gameserver = new GameServer();
        assertThrows(IllegalArgumentException.class, () -> {
            gameserver.catchInputException("a12");
        });
    }
    @Test
    void 사용자_입력_게임끝난경우_1() {
        GameServer gameserver = new GameServer();
        assertThrows(IllegalArgumentException.class, () -> {
            gameserver.decideRestart("3");
        });
    }
    @Test
    void 사용자_입력_게임끝난경우_2() {
        GameServer gameserver = new GameServer();
        assertThrows(IllegalArgumentException.class, () -> {
            gameserver.decideRestart("123");
        });
    }
}
