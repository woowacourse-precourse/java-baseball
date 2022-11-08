package baseball;


public class Application {

    public static void main(String[] args) {
        Game gameStart = new Game();
        gameStart.makeRandomValue();
        gameStart.compareRandomValue();
        gameStart.setPrediction();
        gameStart.isNotNumber();
        gameStart.setStrikeAndBall();
        gameStart.fourBall();
        gameStart.gameEndOrRestart();
    }


}