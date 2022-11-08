package baseball;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {
    @Test
    void createGameNumber_세자리_숫자_생성() {
        Computer computer1 = new Computer();
        List testList = new ArrayList<>(computer1.createGameNumber());
        assertThat(testList).hasSize(3);
    }
}
