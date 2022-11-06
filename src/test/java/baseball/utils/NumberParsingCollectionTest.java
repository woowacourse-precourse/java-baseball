package baseball.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class NumberParsingCollectionTest {

    @Test
    void 입력받은_숫자들을_Integer형_리스트에_하나씩_저장(){
        List<Integer> result = NumberParsingCollection.changeStringToIntegers("2345");

        assertThat(result).isEqualTo(Arrays.asList(2,3,4,5));
    }

    @Test
    void 원하는_개수와_범위로_숫자를_생성_후_Integer형_리스트에_하나씩_저장(){
        List<Integer> result = NumberParsingCollection.createRandomNumbersInRange(3,1,4);
        String resultString = (Arrays.toString(result.toArray())).replaceAll("[^0-9]","");

        assertThat(IsCollection.isEqualToSetLength(resultString,3)).isTrue();
        assertThat(IsCollection.isInputNumbersInRange(resultString,1,4)).isTrue();

    }

}
