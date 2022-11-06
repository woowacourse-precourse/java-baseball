package baseball.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

public class IsCollectionTest {

    @Test
    void 범위_안에_숫자_비교(){
        boolean result = IsCollection.isInputNumbersInRange("123",1,5);
        assertThat(result).isTrue();

        result = IsCollection.isInputNumbersInRange("126",1,5);
        assertThat(result).isFalse();
    }

    @Test
    void 숫자를_포함_하는지_검사(){
        boolean result = IsCollection.hasNumber(Arrays.asList(1,3,5),3);
        assertThat(result).isTrue();

        result = IsCollection.hasNumber(Arrays.asList(1,3,5),4);
        assertThat(result).isFalse();
    }

    @Test
    void 중복_유무_검사(){
        boolean result = IsCollection.isDuplication(Arrays.asList(1,3,3));
        assertThat(result).isTrue();

        result = IsCollection.isDuplication(Arrays.asList(1,3,4));
        assertThat(result).isFalse();
    }

}
