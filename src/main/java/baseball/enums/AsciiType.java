package baseball.enums;

public enum AsciiType {
    ASCII_ZERO(48),
    ASCII_ONE(49),
    ASCII_NINE(57);

    private final int asciiNumber;

    AsciiType(int asciiNumber) {
        this.asciiNumber = asciiNumber;
    }

    public int getAsciiNumber() {
        return asciiNumber;
    }
}
