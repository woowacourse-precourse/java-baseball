package baseball;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TransformationTest {
    @Test
    void Integer_list_2_String_test() {
        List<Integer> number = List.of(1, 3, 5);

        String out = Transformation_function.Integer_list_2_String(number);
        assertThat(out).isEqualTo("135");
    }

    @Test
    void String_2_String_list_test() {
        String string = "135";
        List<String> result = List.of("1", "3", "5");

        List<String> out = Transformation_function.String_2_String_list(string);
        assertThat(out).isEqualTo(result);
    }
}
