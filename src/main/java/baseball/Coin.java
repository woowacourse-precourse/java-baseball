package baseball;

public class Coin {
    public static final String ABLE_COIN_TO_GAME = "1";
    private String coin;

    public Coin() {
        this.coin = ABLE_COIN_TO_GAME;
    }

    public Coin(String coin) {
        checkCoin(coin);
        this.coin = coin;
    }

    public boolean isCoin() {
        if(this.coin.equals(ABLE_COIN_TO_GAME)) return true;
        return false;
    }

    public String getCoin() {
        return this.coin;
    }

    private void checkCoin(String coin) {
        if (!coin.equals("1") && !coin.equals("2")) throw new IllegalArgumentException();
    }

}
