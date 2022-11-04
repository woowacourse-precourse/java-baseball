package baseball;

public class Coin {
    private String coin;

    public Coin(String coin) {
        checkCoin(coin);
        this.coin = coin;
    }

    public String getCoin() {
        return this.coin;
    }


    private void checkCoin(String coin) {
        if(!coin.equals("1") && !coin.equals("2")) throw new IllegalArgumentException();
    }

}
