package baseball.enums;

public enum Announcement {
    INPUT_NUMBER("숫자를 입력해주세요 : ");

    private final String announcement;
    Announcement(String announcement) {
        this.announcement = announcement;
    }

    public void printAnnouncement() {
        System.out.print(announcement);
    }
}
