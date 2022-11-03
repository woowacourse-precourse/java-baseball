package baseball;

import org.junit.jupiter.api.Test;

public class MyTest {
    @Test
    void initComputerTest() {
        //given(준비)
        Application application = new Application();

        //when(실행)
        application.initComputer();


        //then(검증)
        for(String number : Application.computer) {
            System.out.println(number);
        }
    }

}
