package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import baseball.model.Computer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class ComputerTest extends NsTest  {
    @Test
    void 기능3_컴퓨터_3자리수_설정_테스트(){
        Computer computer = new Computer();
        List<Integer> number = computer.getRandom3Digits();
        assertThat(number.get(0) != number.get(1));
        assertThat(number.get(1) != number.get(2));
        assertThat(number.get(0) != number.get(2));

        assertThat(number.get(0) >= 1 && number.get(0) <= 9);
        assertThat(number.get(1) >= 1 && number.get(1) <= 9);
        assertThat(number.get(2) >= 1 && number.get(2) <= 9);

        System.out.println("test3 : Computer setting Number : " + (number.get(0) * 100 + number.get(1) * 10 + number.get(2)));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
    
}