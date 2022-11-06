package baseball.computer;


import baseball.utils.appConfig.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerNumbersGeneratorTest {
    ComputerNumbersGenerator computerNumbersGenerator = AppConfig.createComputerNumbersGenerator();

    @Test
    void 자동으로_3개의_숫자를_생각() {

        int numbersLength = computerNumbersGenerator.autoCreateNumbers().size();
        assertThat(numbersLength).isEqualTo(3);
    }
}