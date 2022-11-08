package baseball;

import baseball.computer.Computer;
import baseball.verifier.VerifierInputToBaseballGame;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    private final VerifierInputToBaseballGame verifier = new VerifierInputToBaseballGame();
    private final Computer computer = new Computer();

    @Test
    void 랜덤_함수_숫자야구에_대한_적절한값_생성(){
        boolean result = true;
        for(int test = 1; test < 1000000 ; test++){
            computer.makeRandomNumber();
            result = verifier.validates(computer.getBaseballNumber().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining()));
            if(!result)
                break;
        }
        assertThat(true).isEqualTo(result);
    }
}
