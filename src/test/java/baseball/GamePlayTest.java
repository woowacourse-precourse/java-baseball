package baseball;

import baseball.domain.ComputerNumber;
import baseball.domain.UserNumber;
import baseball.excpetion.NumberException;
import org.assertj.core.internal.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class GamePlayTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;
    final GamePlay gamePlay = new GamePlay();
    final ComputerNumber computerNumber = new ComputerNumber();
    final UserNumber userNumber = new UserNumber();
    final NumberException numberException = new NumberException();

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    void tearDown(){
        System.setOut(standardOut);
    }

    @Test
    void 결과_값이_스트라이크() {
        // given
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(1,7,4));
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(1,7,8));

        // when
        gamePlay.getResult(userNumber,computerNumber);

        // then
        Assertions.assertEquals("2스트라이크",outputStreamCaptor.toString().trim());
    }

    @Test
    void 결과_값이_볼(){
        // given
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(2,5,9));
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(5,9,2));

        // when
        gamePlay.getResult(userNumber,computerNumber);

        // then
        Assertions.assertEquals("3볼",outputStreamCaptor.toString().trim());

    }
    @Test
    void 결과_값이_볼과_스트라이크(){
        // given
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(3,6,8));
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(3,8,9));

        // when
        gamePlay.getResult(userNumber,computerNumber);

        // then
        Assertions.assertEquals("1볼 1스트라이크",outputStreamCaptor.toString().trim());

    }
    @Test
    void 결과_값이_올_스트라이크(){
        // given
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(3,5,7));
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(3,5,7));

        // when
        boolean result = gamePlay.getResult(userNumber,computerNumber);

        // then
        Assertions.assertEquals(false,result);
    }
    @Test
    void 결과_값이_낫싱(){
        // given
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(1,5,9));
        List<Integer> userNumber = new ArrayList<>(Arrays.asList(2,4,8));

        // when
        gamePlay.getResult(userNumber,computerNumber);

        // then
        Assertions.assertEquals("낫싱",outputStreamCaptor.toString().trim());
    }
    @Test
    void 컴퓨터의_숫자가_3자리(){
        // given, when
        List<Integer> computerNumberList = computerNumber.generateNumber();
        //then
        assertThat(computerNumberList.size()).isEqualTo(3);
    }
    @Test
    void 컴퓨터의_숫자가_중복(){
        // given
        List<Integer> computerNumberList = computerNumber.generateNumber();
        // when
        Set<Integer> uniqueList = new HashSet<>(computerNumberList);
        //then
        assertThat(uniqueList.size()).isEqualTo(3);
    }
    @Test
    void 컴퓨터의_숫자가_숫자로만_구성(){
        // given
        List<Integer> computerNumberList = computerNumber.generateNumber();
        String numbers = "1234567989";
        // when
        for(int i=0;i<computerNumberList.size();i++){
            //then
        }
        //then
    }
    @Test
    void 사용자의_숫자가_3자리(){
        // given
        String userInput = "15834";
        // when
        assertThatThrownBy(()-> numberException.validNumberLength(userInput))
                // then
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 사용자의_숫자가_중복(){

    }
    @Test
    void 사용자의_숫자가_숫자로만_구성(){

    }

}
