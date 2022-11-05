package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UnitTest {

    @Test
    public void printStartGame_정상_테스트(){
        //given
        Application application = new Application();

        //when
        application.printStartGame();

        //then
    }

    @Test
    public void makeRandomNumber_정상_테스트(){
        //given
        Application application = new Application();

        //when
        int result = application.makeRandomNumber();
        boolean state = checkIfEachDifferent(result);

        //then
        Assertions.assertThat(result).isGreaterThanOrEqualTo(100);
        Assertions.assertThat(result).isLessThanOrEqualTo(999);
        Assertions.assertThat(state).isEqualTo(true);
    }

    private boolean checkIfEachDifferent(int result){
        int i1 = result/100;
        int i2 = (result % 100) / 10;
        int i3 = (result%10);
        return (i1 != i2) && (i2 != i3) && (i1 != i3);
    }
}