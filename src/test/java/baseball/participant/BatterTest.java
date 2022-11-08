package baseball.participant;

import baseball.participant.Batter;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class BatterTest {

    @Test
    void selectHitNumber() {
        // given
        Batter batter = new Batter();

        // when
        String randomNumber = batter.readyToHitNumberBall();
        Set<String> set = Arrays.stream(randomNumber.split("")).collect(Collectors.toSet());

        // then
        assertThat(set.size()).isEqualTo(3);
        assertThat(randomNumber.matches("[1-9]+")).isTrue();
    }
}