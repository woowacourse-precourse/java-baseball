package baseball.util.setting;

public enum MenuSetting {
  RESTART_GAME(1),
  END_GAME(2);

  private final int menuNumber;

  MenuSetting(int menuNumber) {
    this.menuNumber = menuNumber;
  }

  public int getMenuNumber() {
    return menuNumber;
  }
}
