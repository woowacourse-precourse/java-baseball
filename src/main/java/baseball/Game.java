package baseball;

public class Game {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GUESS_ALL = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String END_GAME = "숫자 야구 게임을 종료합니다.";

    private static Status status;
    private static Result result;
    private static Computer computer;
    private static User user;

    private Game() {}

    public static void startGame() {
        System.out.println(START_GAME);
        status = Status.PROCEEDING;

        try {
            // 1. Status가 EXIT가 아닐 동안 반복되는 반복문 안에서 게임 진행
            while (status != Status.EXIT) {
                // 2. 게임 진행을 위한 초기화
                initGame();

                // 3. Computer와 User 정보를 이용해 Result가 THREESTRIKE가 아닐 동안 게임 진행
                proceedGameUntil3S(computer, user);
                System.out.println(GUESS_ALL);

                // 4. 사용자 입력에 따라 게임 재개 혹은 종료를 위한 Status 변경
                System.out.println(OPTION_MESSAGE);
                changeStatusByOption();
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            throw new IllegalArgumentException();
        }

        System.out.println(END_GAME);
    }

    /*
     * 게임 진행을 위한 초기화 작업
     * Computer, User 객체를 만들고, result 초기화
     *
     * @return void
     * */
    private static void initGame() {
        computer = new Computer();
        user = new User();
        result = Result.NOTHING;
    }

    /*
     * Computer와 User 정보를 받아 Result가 THREESTRIKE가 아닐 동안 게임 수행
     *
     * @return void
     * */
    private static void proceedGameUntil3S(Computer computer, User user) {
        while (result != Result.THREESTRIKE) {
            System.out.print(INPUT_MESSAGE);
            User.setGameNumber();

            result = Result.getResultByCode(Calculator.calculateScore(computer, user));
            System.out.println(result.getMessage());
        }
    }

    /*
     * 사용자의 입력으로 게임의 상태 변경
     *
     * @return void
     * */
    private static void changeStatusByOption() {
        User.setGameOption();
        status = Status.getStatusByGameOption(user.getGameOption());
    }
}
