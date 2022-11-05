package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GameTest {
    Game game;
    public GameTest(){
        this.game = new Game();
    }

//    @Test
//    void 스트라이크체크(){
//        int answer = 1;
//        int strike = game.isStrike(1,1);
//        Assertions.assertEquals(answer,strike);
//    }
//
//    @Test
//    void 볼체크(){
//        int answer = 1;
//        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3));
//        int index = 2;
//        int strike = game.isBall(numbers,answer,index);
//        Assertions.assertEquals(answer,strike);
//    }
//
//    @Test
//    void 게임에서이겼는지체크(){
//        int strike = 3;
//        boolean answer = true;
//        boolean iswin = game.isAnswer(strike);
//        Assertions.assertEquals(answer,iswin);
//    }
}
