package baseball;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class BaseballGameTest{

    BaseballGame baseballGame = new BaseballGame();

    @Test
    public void 컴퓨터_랜덤숫자_생성() {

        //given
        List<Integer> computer = baseballGame.makeComputerNumber();

        //when
        Set<Integer> computerValidationSet = new HashSet<>(computer);

        //then
        assertThat(computerValidationSet.size()).isEqualTo(3);

    }

}