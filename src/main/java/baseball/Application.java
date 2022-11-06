package baseball;

import java.util.Map;

public class Application {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INVALID_INPUT = "잘못된 입력입니다.";
    private static final String GUESS_ALL = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String END_GAME = "숫자 야구 게임을 종료합니다.";

    private static Status status;
    private static Result result;
    private static Computer computer;
    private static User user;

    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        System.out.println(START_GAME);
        status = Status.PROCEEDING;

        try {
            // TODO: 1. Status가 EXIT가 아닐 동안 반복되는 반복문 안에서 게임 진행
            while (status != Status.EXIT) {
                // TODO: 2. 게임 진행을 위한 초기화
                initGame();

                // TODO: 3. Computer와 User 정보를 이용해 Result가 THREESTRIKE가 아닐 동안 게임 진행
                proceedGameUntil3S(computer, user);
                System.out.println(GUESS_ALL);

                // TODO: 5. 사용자 입력에 따라 게임 재개 혹은 종료를 위한 Status 변경
                System.out.println(OPTION_MESSAGE);
                changeStatusByOption();
            }
        } catch (IllegalArgumentException exception) {
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
        try {
            while (result != Result.THREESTRIKE) {
                System.out.print(INPUT_MESSAGE);
                User.setGameNumber();

                result = Result.getResultByCode(calculateScore(computer, user));
                System.out.println(result.getMessage());
            }
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException();
        }
    }

    /*
     * 사용자의 입력으로 게임의 상태 변경
     *
     * @return void
     * */
    private static void changeStatusByOption() {
        try {
            User.setGameOption();
            status = Status.getStatusByGameOption(user.getGameOption());
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException();
        }
    }

    /*
     * 컴퓨터와 사용자의 정보를 받아 점수를 계산한다.
     * 스트라이크 10점, 볼 1점, 낫싱 0점
     *
     * @return int
     * */
    private static int calculateScore(Computer computer, User user) {
        Map<Character, Integer> numberIndexMap = computer.getNumberIndexMap();
        String userGameNumber = user.getGameNumber();
        int score = 0;

        for (int index = 0; index < userGameNumber.length(); index++) {
            char currentUserNumber = userGameNumber.charAt(index);
            if (numberIndexMap.containsKey(currentUserNumber)) {
                score += computeScoreIndex(numberIndexMap.get(currentUserNumber), index);
            }
        }

        return score;
    }

    /*
     * 컴퓨터 숫자별 인덱스 정보 Map에서 가져온 numberIndex와 사용자의 현재 숫자를 받아, 점수를 반환
     * 같다면 10점, 다르다면 1점
     *
     * @return int
     * */
    private static int computeScoreIndex(int numberIndex, int index) {
        if (numberIndex == index) {
            return 10;
        }
        return 1;
    }
}
