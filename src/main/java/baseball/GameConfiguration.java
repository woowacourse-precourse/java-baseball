package baseball;

public interface GameConfiguration {
    SingleDigitForGame getSingleDigit(int number);
    MultiDigitNumberForGame getMultiDigit(int number);
    Game getGame();
    IOManager getInputReader();
}
