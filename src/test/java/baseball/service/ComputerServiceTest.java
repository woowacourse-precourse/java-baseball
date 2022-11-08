package baseball.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.service.ComputerService.generator;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ComputerServiceTest {

    @Test
    void 컴퓨터_랜덤_숫자_생성(){
        List<Integer> num = generator();
        System.out.println("num = " + num);
    }






}