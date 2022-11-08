package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Baseball;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;


public class BaseballTest {
    @Test
    void test_여러개의_야구공이_생성되었을_때_값이_다르게_선택되는지(){
        Baseball b1=new Baseball();
        Baseball b2=new Baseball();

        boolean result= b1.baseballEqual(b2);
        assertThat(result).isFalse();
    }

    @Test
    void test_Baseball_생성시_값을_입력하면_그대로_객체생성이_되는지(){
        Baseball baseball=new Baseball(1);
        String result=baseball.toString();

        assertThat(result).isEqualTo("1");
    }

    @Test
    void test_Baseball_객체_값_비교(){
        Baseball b1=new Baseball(1);
        Baseball b2=new Baseball(1);

        boolean result=b1.baseballEqual(b2);

        assertThat(result).isTrue();

    }

    @Test
    void test_Baseball_객체_리스트_포함_검사(){
        Baseball b1=new Baseball(1);
        Baseball b2=new Baseball(2);
        List<Baseball> baseballs= Arrays.asList(b1,b2);
        Baseball target=new Baseball(1);

        boolean result=target.baseballContain(baseballs);
        assertThat(result).isTrue();

    }

}
