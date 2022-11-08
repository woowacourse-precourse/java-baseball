package baseball.enums;

public enum Menu {
    REPLAY("1"),
    QUIT("2");

    private final String menuNumber;

    Menu(String menuNumber) {
        this.menuNumber = menuNumber;
    }

    public String getMenuNumber() {
        return menuNumber;
    }
}
