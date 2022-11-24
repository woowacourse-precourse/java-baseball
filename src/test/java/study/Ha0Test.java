package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
요구사항 1
        "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
        "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다
*/

public class Ha0Test {

    @Test
    public void 테스트1_1(){
        String str="1,2";
        String[] arr=str.split(",");
        assertThat(arr).containsExactly("1","2");
    }

    @Test
    public void 테스트1_2(){
        String str="1";
        String[] arr=str.split(",");
        assertThat(arr).containsExactly("1");
    }

    /*
    요구사항 2
"(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환
하도록 구현한다.
     */
    @Test
    public void 테스트2(){
        String str="(1,2)";
        String substr=str.substring(1,4);

        assertThat(substr).isEqualTo("1,2");
    }

    /*
    요구사항 3
"abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습
테스트를 구현한다.
String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */

    @Test
    public void 테스트3(){
        String str="abc";
        String substr=str.substring(1,3);

        assertThat(str.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> str.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }
}
