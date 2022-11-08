package baseball.game.service;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;


class ComputerNumberTest {

    @Test
    void 세자리_여부 () {
        List<Integer> computerNumber = ComputerNumber.generate();

        Assertions.assertThat(computerNumber.size()).isEqualTo(3);
    }

    @Test
    void 중복_숫자_여부 () {
        List<Integer> computerNumber = ComputerNumber.generate();
        Set<Integer> computerNumberSet = new HashSet<>(computerNumber);
        boolean isDuplicate = computerNumberSet.size() != 3;

        assertFalse(isDuplicate);
    }



}