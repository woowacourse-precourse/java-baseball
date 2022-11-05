package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class RandomNumberTest extends NsTest{
    @Test
    void randomArrayListSizeTest(){
        Application test = new Application();
        ArrayList<Integer> result = test.settingNumber();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void randomArrayListOverlapTest(){
        Application test = new Application();
        ArrayList<Integer> numList = test.settingNumber();
        Set<Integer> numSet = new HashSet<>(numList);
        assertThat(numList.size()).isEqualTo(numSet.size());
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
