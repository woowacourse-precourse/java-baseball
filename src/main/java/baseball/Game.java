package baseball;

public interface Game {
    String answer = null;
    void start();
    void play();
    void end();
    void score(int strikePoint, int ballPoint);
}
