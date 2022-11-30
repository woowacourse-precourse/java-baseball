package baseball.model;

import static baseball.model.Number.LENGTH;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("Number 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class NumberTest {

    List<Integer> computer;

    @BeforeEach
    void setUp() {
        computer = Number.generateNumber();
    }
    public static List<Integer> generateExpectList() {
        List<Integer> expectList = new ArrayList<>();

        while (expectList.size() < LENGTH.getNumber()){
            expectList.add(Randoms.pickNumberInRange(1,9));
        }
        return expectList;
    }



    @Test
    public void 상대방_랜덤수_생성(){
        //given

        int expect = 3;
        int actual = computer.size();

        //then
        assertEquals(expect, actual);
    }

    @Test
    public void 랜덤수_비교() throws Exception{
        //given
        List<Integer> expect = generateExpectList();

        //then
        assertEquals(expect, computer);
    }

}