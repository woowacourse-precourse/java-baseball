package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerificationTest {


    Verification verification = new VerificationImpl();

    @Nested
    class OnlyNumberVerification{
        @Test
        void 한글이_존재하면_예외를_던지는지_확인() {
            //given
            String input = "테스트";

            //then
            assertThrows(IllegalArgumentException.class,()->{
                verification.onlyNumberVerification(input);
            });
        }

        @Test
        void 숫자만_존재하면_예외를_던지지_않는지_확인(){
            //given
            String input = "123";

            //then
            assertDoesNotThrow(()->{
                verification.onlyNumberVerification(input);
            });
        }
    }

    @Nested
    class LengthVerification{

        @Test
        void 입력받은_것이_3개가_아니면_예외를_던진다(){
            String input = "1234";

            assertThrows(IllegalArgumentException.class,()->{
                verification.lengthVerification(input);
            });
        }
        @Test
        void 입력받은_것이_3개면_예외를_던지지_않는다(){
            String input = "987";

            assertDoesNotThrow(()->{
                verification.lengthVerification(input);
            });
        }
    }

    @Nested
    class RangeVerification{

        @Test
        void 유효한_범위의_숫자들로_이루어져_있지_않으면_예외를_던진다() {

            String input = "000";

            assertThrows(IllegalArgumentException.class,()->{
                verification.rangeVerification(input);
            });
        }
        @Test

        void 유효한_범위의_숫자들로_이루어져_있으면_예외를_던지지_않는다() {

            //1~9 사이
            String input = "987";

            assertDoesNotThrow(()->{
                verification.rangeVerification(input);
            });
        }
    }

    @Nested
    class UniqueNumberVerification{

        @Test
        void 서로_다른_숫자가_아니면_예외를_던진다(){
            String input = "999";
            assertThrows(IllegalArgumentException.class,()->{
                verification.uniqueNumberVerification(input);
            });
        }
    }
}