package baseball;

import baseball.Model.Computer.Answer;
import baseball.Model.Player.BaseBallNumber;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AnswerTest {

    @Nested
    @DisplayName("Answer Class")
    class AnswerKoTest {

        @Nested
        @DisplayName("compare method is")
        class DescribeCompare {

            private ByteArrayOutputStream outContent;

            @BeforeEach
            public void setUpStreams() {
                outContent = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outContent));
            }

            @Test
            @DisplayName("Nothing")
            void compareNoting() {
                Answer answer = new Answer(List.of('1', '2', '3'));
                answer.compare(new BaseBallNumber(List.of('4', '5', '6')));
                Assertions.assertThat(outContent.toString().trim()).isEqualTo("낫싱");
            }

            @Nested
            @DisplayName("Ball of")
            class DescribeBall {

                @Test
                @DisplayName("1볼")
                void compareOneBall() {
                    Answer answer = new Answer(List.of('1', '2', '3'));
                    answer.compare(new BaseBallNumber(List.of('4', '3', '6')));
                    Assertions.assertThat(outContent.toString().trim()).isEqualTo("1볼");
                }

                @Test
                @DisplayName("2볼")
                void compareTwoBall() {
                    Answer answer = new Answer(List.of('1', '2', '3'));
                    answer.compare(new BaseBallNumber(List.of('2', '3', '6')));
                    Assertions.assertThat(outContent.toString().trim()).isEqualTo("2볼");
                }

                @Test
                @DisplayName("3볼")
                void compareThreeBall() {
                    Answer answer = new Answer(List.of('1', '2', '3'));
                    answer.compare(new BaseBallNumber(List.of('3', '1', '2')));
                    Assertions.assertThat(outContent.toString().trim()).isEqualTo("3볼");
                }
            }

            @Nested
            @DisplayName("Strike of")
            class DescribeStrike {

                @Test
                @DisplayName("1스트라이크")
                void compareOneBall() {
                    Answer answer = new Answer(List.of('1', '2', '3'));
                    answer.compare(new BaseBallNumber(List.of('1', '4', '5')));
                    Assertions.assertThat(outContent.toString().trim()).isEqualTo("1스트라이크");
                }

                @Test
                @DisplayName("2스트라이크")
                void compareTwoBall() {
                    Answer answer = new Answer(List.of('1', '2', '3'));
                    answer.compare(new BaseBallNumber(List.of('1', '2', '4')));
                    Assertions.assertThat(outContent.toString().trim()).isEqualTo("2스트라이크");
                }

                @Test
                @DisplayName("3스트라이크")
                void compareThreeBall() {
                    Answer answer = new Answer(List.of('1', '2', '3'));
                    answer.compare(new BaseBallNumber(List.of('1', '2', '3')));
                    Assertions.assertThat(outContent.toString().trim()).isEqualTo("3스트라이크");
                }
            }

            @Nested
            @DisplayName("Mixture of")
            class DescribeMixture {

                @Test
                @DisplayName("1볼 1스트라이크")
                void compareOneBall() {
                    Answer answer = new Answer(List.of('1', '2', '3'));
                    answer.compare(new BaseBallNumber(List.of('1', '3', '5')));
                    Assertions.assertThat(outContent.toString().trim()).isEqualTo("1볼 1스트라이크");
                }

                @Test
                @DisplayName("2볼 1스트라이크")
                void compareThreeBall() {
                    Answer answer = new Answer(List.of('1', '2', '3'));
                    answer.compare(new BaseBallNumber(List.of('2', '1', '3')));
                    Assertions.assertThat(outContent.toString().trim()).isEqualTo("2볼 1스트라이크");
                }
            }
        }
    }
}
