package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CoinTest {
    @Test
    void checkCoin_validInput_1and2() {
        //given
        //when
        Coin coin = new Coin("1");
        //then
        assertThat(coin.getCoin()).isEqualTo("1");
        //when
        coin = new Coin("2");
        //then
        assertThat(coin.getCoin()).isEqualTo("2");
    }

    @Test
    void checkCoin_InvalidInput_ExceptionThrown() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Users("0"));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Users("3"));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Users("-"));
    }

    @Test
    void getCoin_CoinIs1_1() {
        //given
        //when
        Coin coin = new Coin("1");
        //then
        assertThat(coin.getCoin()).isEqualTo("1");
    }
    @Test
    void getCoin_CoinIs2_2() {
        //given
        //when
        Coin coin = new Coin("2");
        //then
        assertThat(coin.getCoin()).isEqualTo("2");
    }
    @Test
    void isCoin_CoinIsTrue() {
        //given
        //when
        Coin coin = new Coin("1");
        //then
        assertThat(coin.isCoin()).isEqualTo(true);
    }

    @Test
    void isCoin_CoinIsFalse() {
        //given
        //when
        Coin coin = new Coin("2");
        //then
        assertThat(coin.isCoin()).isEqualTo(false);
    }
}