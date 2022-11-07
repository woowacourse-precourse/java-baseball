package baseball.Domain;

public class ThrowBall {
    private char firstCount;
    private char secondCount;
    private char thirdCount;

    public ThrowBall(String readLine) {
        firstCount = readLine.charAt(0);
        secondCount = readLine.charAt(1);
        thirdCount = readLine.charAt(2);
    }

}
