package baseball.enums;

public enum AsciiCodeStatus {
    ASCII_ZERO(48),
    ASCII_ONE(49),
    ASCII_NINE(57);

    private final int asciiNumber;

    AsciiCodeStatus(int asciiNumber) {
        this.asciiNumber = asciiNumber;
    }

    public int getAsciiNumber() {
        return asciiNumber;
    }
}
