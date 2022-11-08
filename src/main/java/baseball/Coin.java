package baseball;

public class Coin {
    public static final String COIN_TO_GAME = "1";
    public static final String COIN_TO_FINISH = "2";
    private String coin;

    public Coin() {
        this.coin = COIN_TO_GAME;
    }

    public Coin(String coin) {
        checkCoin(coin);
        this.coin = coin;
    }

    public boolean isCoin() {
        if (this.coin.equals(COIN_TO_GAME)) return true;
        return false;
    }

    public String getCoin() {
        return this.coin;
    }

    private void checkCoin(String coin) {
        if (!coin.equals(COIN_TO_GAME) && !coin.equals(COIN_TO_FINISH)) throw new IllegalArgumentException();
    }

}
