package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.*;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @DisplayName("플레이어가 입력하는 값이 저장되는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"134", "167", "189", "159", "163", "789", "698"})
    void EnterNumberOfPlayerTest(String inputData) {
        // Given
        Player player = new Player();
        InputStream input = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(input);

        // When
        player.EnterNumberOfPlayer();

        // Then
        assertThat(player.playersNumber).isEqualTo(Arrays.asList(inputData.split("")));
    }
}
