package baseball.Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ComputerTest {
    Computer com = new Computer();

    @Test
    public void 컴퓨터_숫자_생성_테스트(){ 
        com.makeRandomNumbers();
        assertNotNull(com.getGameNumbers());
    }

    @Test
    public void 컴퓨터_숫자_생성_길이_테스트2(){
        com.makeRandomNumbers();
        assertEquals(com.getGameNumbers().size(), NumberGenerator.GAME_NUM_LENGTH);
    }

    @Test
    public void 컴퓨터_숫자_생성_중복_테스트3(){
        com.makeRandomNumbers();
        assertEquals(com.getGameNumbers().stream().distinct().count(), NumberGenerator.GAME_NUM_LENGTH);

    }
}
