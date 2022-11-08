package baseball.Service;

import baseball.Domain.Computer;
import baseball.Domain.Hint;
import baseball.Domain.NumberGenerator;
import baseball.Domain.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameServiceTest {

    Computer com = new Computer();
    Player player = new Player();
    Hint hint = new Hint();

    GameService gameService = new GameService();
    @BeforeEach
    public void setUp(){
        gameService.gameStart(com, player, hint);
    }
    @Test
    public void 게임서비스_게임_시작_테스트() {
        assertThat(gameService.getComputer().getClass()).isEqualTo(Computer.class);
        assertThat(gameService.getPlayer().getClass()).isEqualTo(Player.class);
        assertThat(gameService.getHint().getClass()).isEqualTo(Hint.class);

    }

    @Test
    public void 게임서비스_컴퓨터숫자_생성_테스트() {
        gameService.makeComputerNum();
        assertEquals(gameService.getComputer().getGameNumbers().size(), NumberGenerator.GAME_NUM_LENGTH);
    }

    @Test
    public void 게임서비스_힌트확인_테스트() {
        gameService.getComputer().setGameNumbers(List.of(1, 7, 8));
        gameService.getPlayer().setPlayerGameNumbers(List.of(2, 7, 8));
        gameService.countResult();
        assertThat(gameService.getHint().getGameResult()).isEqualTo(List.of(2, 0));

    }

    @Test
    public void 게임서비스_힌트확인_테스트2() {
        gameService.getComputer().setGameNumbers(List.of(1, 2, 3));
        gameService.getPlayer().setPlayerGameNumbers(List.of(3, 7, 8));
        gameService.countResult();
        assertThat(gameService.getHint().getGameResult()).isEqualTo(List.of(0,1));

    }

    @Test
    public void 게임서비스_정답여부_테스트(){
        gameService.getHint().setGameResult(List.of(3,0));
        assertTrue(gameService.checkIsAnswer());

    }
}