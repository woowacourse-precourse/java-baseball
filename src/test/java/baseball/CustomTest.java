package baseball;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomTest {

    @Nested
    public class CustomGenerateNumberTest {

        LocalDateTime now = LocalDateTime.now();
        BaseBallGame bg = new BaseBallGame(now.hashCode());


        @Test
        @DisplayName("생성된 숫자가 없거나 비어있는 리스트인지 확인")
        void generatedNumberisEmptyOrNull() {
            assertThat(bg.answerNumber).isNotNull().isNotEmpty();
        }

        @Test
        @DisplayName("생성된 숫자가 valid 한지 확인")
        void genreatedNumberisValid() {
            List<Integer> an = bg.answerNumber;
            for(int i : an){
                assertThat(an.parallelStream().filter(v->v==i).count() == 1).isTrue();
            }

        }
    }

}
