package baseball;

import baseball.Coin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CoinTest{
    @Test
    @DisplayName("정상 값")
    void getInput() {
        //given
        //when
        Coin coin = new Coin("1");
        //then
        assertThat(coin.getCoin()).isEqualTo("1");
        coin = new Coin("2");
        //then
        assertThat(coin.getCoin()).isEqualTo("2");
    }

    @Test
    @DisplayName("잘못된 길이")
    void CheckLength() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Input("0"));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Input("3"));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Input("-"));
    }
}