package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game;
    List<Integer> computerNum;

    @BeforeEach
    void setUp(){
        //Given
        Game game = new Game();

        //When
         computerNum= game.getComputerNum();
    }
    @Test
    @DisplayName("3자리 수인지 테스트")
    void check_3_digit(){


        //Then
        //3자리 수인지
        assertThat(computerNum.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("중복있는지 테스트")
    void check_duplication(){
        //Given
        Game game = new Game();

        //When
        List<Integer> computerNum = game.getComputerNum();

        //Then
        assertThat(computerNum.stream()
                .distinct()
                .count()).isEqualTo(3);

    }

    @Test
    @DisplayName("숫자 범위가 1~9인지 테스트")
    void isInRange(){
        //Given
        Game game = new Game();

        //When
        List<Integer> computerNum = game.getComputerNum();

        //Then
        //숫자 범위가 1~9인지
        assertThat(computerNum
                .stream()
                .allMatch(n -> n >=1 && n <= 9)).isTrue();
    }

}