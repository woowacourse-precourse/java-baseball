package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void 낫싱_판별(){
        Game game=new Game();
        User user=new User();
        Computer computer=new Computer();
        List<Integer> userNumber=new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> computerNumber=new ArrayList<>(Arrays.asList(4,5,6));

        user.isValidUserNumber(userNumber);
        computer.setComputerNumber(computerNumber);
        game.calGame(game.computerNumberToString(computerNumber), game.userNumberToString(userNumber));

        assertThat(game.getStrike()).isEqualTo(0);
        assertThat(game.getBall()).isEqualTo(0);
    }

    @Test
    void 스트라이크_판별(){
        Game game=new Game();
        User user=new User();
        Computer computer=new Computer();
        List<Integer> userNumber=new ArrayList<>(Arrays.asList(4,5,3));
        List<Integer> computerNumber=new ArrayList<>(Arrays.asList(4,5,6));

        user.isValidUserNumber(userNumber);
        computer.setComputerNumber(computerNumber);
        game.calGame(game.computerNumberToString(computerNumber), game.userNumberToString(userNumber));

        assertThat(game.getStrike()).isEqualTo(2);
        assertThat(game.getBall()).isEqualTo(0);
    }

    @Test
    void 볼_판별(){
        Game game=new Game();
        User user=new User();
        Computer computer=new Computer();
        List<Integer> userNumber=new ArrayList<>(Arrays.asList(4,5,3));
        List<Integer> computerNumber=new ArrayList<>(Arrays.asList(5,4,1));

        user.isValidUserNumber(userNumber);
        computer.setComputerNumber(computerNumber);
        game.calGame(game.computerNumberToString(computerNumber), game.userNumberToString(userNumber));

        assertThat(game.getStrike()).isEqualTo(0);
        assertThat(game.getBall()).isEqualTo(2);
    }
    @Test
    void 스트라이크_볼_판별(){
        Game game=new Game();
        User user=new User();
        Computer computer=new Computer();
        List<Integer> userNumber=new ArrayList<>(Arrays.asList(4,5,1));
        List<Integer> computerNumber=new ArrayList<>(Arrays.asList(5,4,1));

        user.isValidUserNumber(userNumber);
        computer.setComputerNumber(computerNumber);
        game.calGame(game.computerNumberToString(computerNumber), game.userNumberToString(userNumber));

        assertThat(game.getStrike()).isEqualTo(1);
        assertThat(game.getBall()).isEqualTo(2);
    }
}