package baseball.view;

public class View {

    public static final View view = new View();

    public View() {
    }

    public void printStartMenu() {
        Console.WELCOME.println();
    }

    public void printInputMenu() {
        Console.INPUT_NUMBER.print();
    }

    public String getNumberString() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    public void printGameResult(String result) {
        Display.print(result);
    }

    public void printEndMenu() {
        Console.WIN.println();
    }

    private enum Console implements Display {
        WELCOME("숫자 야구 게임을 시작합니다."),
        INPUT_NUMBER("숫자를 입력해주세요 : "),
        WIN("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
        ;

        private final String message;

        Console(String message) {
            this.message = message;
        }

        @Override
        public void print() {
            System.out.print(message);
        }

        @Override
        public void println() {
            System.out.println(message);
        }
    }

    private interface Display {

        void print();

        void println();

        static void print(String message) {
            System.out.println(message);
        }
    }
}
