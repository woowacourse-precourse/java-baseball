package baseball;

public enum Messages {

    INIT("숫자 야구 게임을 시작합니다."),
    INPUT("숫자를 입력해주세요 : "),
    END("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(this.message);
    }

    public static void printScore(int balls, int strikes) {
        StringJoiner baseString = new StringJoiner(" ");
        if (balls != 0) {
            baseString.add(String.format("%d볼", balls));
        }
        if (strikes != 0) {
            baseString.add(String.format("%d스트라이크", strikes));
        }
        if (baseString.length() == 0) {
            baseString.add("낫싱");
        }
        System.out.println(baseString);
    }

    public static void main(String[] args) {
        Messages.INPUT.printMessage();
        Messages.END.printMessage();
        Messages.ASK.printMessage();
    }
}
