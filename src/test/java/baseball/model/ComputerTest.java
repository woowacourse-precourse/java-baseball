package baseball.model;

import static baseball.model.Computer.COMPUTER;
import static baseball.model.Number.LENGTH;
import static baseball.model.Player.PLAYER;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Number 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class ComputerTest {

    List<Integer> computer;

    @BeforeEach
    void setUp() {
        computer = COMPUTER.number();
    }

    @Test
    public void 상대방_랜덤수_생성(){
        //given
        int expect = 3;

        //when
        int actual = computer.size();

        //then
        assertEquals(expect, actual);
    }


}