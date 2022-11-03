package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserAnswerTest {

    UserAnswer userAnswer;
    @BeforeEach
    void setUp() {
        userAnswer = new UserAnswer();
    }
    @ParameterizedTest
    @ValueSource(strings = {"1234","1e1e","1i","11k","111","122"})
    void userAnswerTest(String input){
        assertThatThrownBy(()->{
            userAnswer.StringtoList(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}