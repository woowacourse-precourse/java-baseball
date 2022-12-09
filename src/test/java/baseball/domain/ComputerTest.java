package baseball.domain;

import baseball.BaseBallGenerator;
import baseball.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ComputerTest {

    private final RandomNumberGenerator randomNumberGenerator = new BaseBallGenerator();
    private final int BASEBALL_ANSWER_LENGTH = 3;

    Computer computer = new Computer(randomNumberGenerator);

    @Test
    void generate_메소드는_길이가_3인_Answer객체를_반환한다() {
        Answer answer = computer.generate();
        Assertions.assertThat(answer.size()).isEqualTo(BASEBALL_ANSWER_LENGTH);
    }


}