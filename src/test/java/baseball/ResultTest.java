package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    List<Integer> computerList = new ArrayList<>();
    @BeforeEach
    void 컴퓨터_리스트_시작_초기화(){
        computerList.add(7);
        computerList.add(1);
        computerList.add(3);
    }
    @Test
    void 스트라이크_볼_갯수_확인1(){
        Result result = new Result();
        List<Integer> userList = Arrays.asList(1,2,3);
        result.countStrikeAndBall(userList,computerList);
        assertThat(1).isEqualTo(result.strike);
        assertThat(1).isEqualTo(result.ball);
    }
    @Test
    void 스트라이크_볼_갯수_확인2(){
        Result result = new Result();
        List<Integer> userList = Arrays.asList(1,4,5);
        result.countStrikeAndBall(userList,computerList);
        assertThat(0).isEqualTo(result.strike);
        assertThat(1).isEqualTo(result.ball);
    }
    @Test
    void 스트라이크_볼_갯수_확인3(){
        Result result = new Result();
        List<Integer> userList = Arrays.asList(6,7,1);
        result.countStrikeAndBall(userList,computerList);
        assertThat(0).isEqualTo(result.strike);
        assertThat(2).isEqualTo(result.ball);
    }
    @Test
    void 스트라이크_볼_갯수_확인4(){
        Result result = new Result();
        List<Integer> userList = Arrays.asList(2,1,6);
        result.countStrikeAndBall(userList,computerList);
        assertThat(1).isEqualTo(result.strike);
        assertThat(0).isEqualTo(result.ball);
    }
    @Test
    void 스트라이크_볼_갯수_확인5(){
        Result result = new Result();
        List<Integer> userList = Arrays.asList(7,1,3);
        result.countStrikeAndBall(userList,computerList);
        assertThat(3).isEqualTo(result.strike);
        assertThat(0).isEqualTo(result.ball);
    }
    @AfterEach
    void 컴퓨터_리스트_종료_초기화(){
        computerList.clear();
    }
}