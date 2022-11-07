package baseball.enums;

public enum Announcement {
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    ASK_REPLAY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String announcement;
    Announcement(String announcement) {
        this.announcement = announcement;
    }

    public void printAnnouncement() {
        System.out.print(announcement);
    }
    public void printlnAnnouncement() {
        System.out.println(announcement);
    }

}
