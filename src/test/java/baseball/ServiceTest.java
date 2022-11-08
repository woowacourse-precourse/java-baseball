package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Input;
import baseball.service.Service;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class ServiceTest extends NsTest {
    @Test
    void test_Service_GenerateHint_3strike(){
        Service service = new Service();
        String answer = getAnswerString(service);
        Input input = new Input(answer);
        assertThat(service.generateHint(input).toString())
                .isEqualTo("3스트라이크");
    }

    @Test
    void test_Service_GenerateHint_2Ball_1Strike(){
        Service service = new Service();
        String answer = getAnswerString(service);
        char[] charInput = answer.toCharArray();
        char swapNum = charInput[2];
        charInput[2] = charInput[0];
        charInput[0] = swapNum;
        String inputChar = new String(charInput);
        Input input = new Input(inputChar);
        assertThat(service.generateHint(input).toString())
                .isEqualTo("2볼 1스트라이크");
    }


    private String getAnswerString(Service service){
        return service.getAnswer()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
