package baseball.service;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class GameServiceTest {

    GameService gameService;

    @BeforeEach
    void initializeClass(){
        gameService = new GameService();
    }

    @Test
    void 인덱스값에서_스트라이크면_참(){
        gameService.setComputer(makeComputer(new int[]{1, 2, 3}));
        gameService.setPlayer(makePlayer("135"));
        assertThat(gameService.isStrike(0)).isTrue();
    }

    @Test
    void 인덱스값에서_스트라이크_아니면_거짓(){
        gameService.setComputer(makeComputer(new int[]{1, 2, 3}));
        gameService.setPlayer(makePlayer("235"));
        assertThat(gameService.isStrike(0)).isFalse();
    }

    @Test
    void 인덱스값에서_볼이면_참(){
        gameService.setComputer(makeComputer(new int[]{1, 2, 3}));
        gameService.setPlayer(makePlayer("135"));
        assertThat(gameService.isBall(1)).isTrue();
    }

    @Test
    void 인덱스값에서_볼이_아니면_거짓(){
        gameService.setComputer(makeComputer(new int[]{1, 2, 3}));
        gameService.setPlayer(makePlayer("235"));
        assertThat(gameService.isBall(2)).isFalse();
    }


    Computer makeComputer(int[] arr){
        Computer computer = new Computer();
        computer.putNumber(arr[0]);
        computer.putNumber(arr[1]);
        computer.putNumber(arr[2]);
        return computer;
    }

    Player makePlayer(String numbers){
        Player player = new Player();
        player.setNumbers(numbers);
        return player;
    }

}
