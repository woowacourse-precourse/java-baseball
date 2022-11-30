package baseball.model;

import static baseball.model.Player.PLAYER;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Player 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp(){

//        player = new Player(new InputView().putReadLine());
    }

    public static InputStream setReadLine(String readLine) {

        return new ByteArrayInputStream(readLine.getBytes());
    }

    @ParameterizedTest
    @MethodSource("parametersProvider")
    public void 사용자_랜덤수_생성(String readLine, List<Integer> expect){
        //given
        System.setIn(setReadLine(readLine));

        //when
        List<Integer> actual = PLAYER.number();

        //then
        assertEquals(expect, actual);
    }

    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments("123", List.of(1,2,3)),
                arguments("456", List.of(4,5,6)),
                arguments("789", List.of(7,8,9))
        );
    }
}