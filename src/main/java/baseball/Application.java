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

        status = Status.PROCEEDING;
        try {
            // TODO: 1. Status가 EXIT가 아닐 동안 반복되는 반복문 안에서 게임 진행
            while (status != Status.EXIT) {
                // TODO: 2. 게임 진행을 위한 초기화
                computer = new Computer();
                user = new User();
                result = Result.NOTHING;

                // TODO: 3. Computer와 User 정보를 이용해 Result가 THREESTRIKE가 아닐 동안 게임 진행
                while (result != Result.THREESTRIKE) {
                    System.out.print(INPUT_MESSAGE);
                    User.setGameNumber();

                    // TODO: 4. Computer와 User의 숫자를 가지고 게임 결과 생성
                    Map<Character, Integer> numberIndexMap = computer.getNumberIndexMap();
                    String userGameNumber = user.getGameNumber();
                    int score = 0;

                    for (int index = 0; index < userGameNumber.length(); index++) {
                        char currentUserNumber = userGameNumber.charAt(index);
                        if (numberIndexMap.containsKey(currentUserNumber)) {
                            if (numberIndexMap.get(currentUserNumber) == index) {
                                score += 10;
                            } else {
                                score += 1;
                            }
                        }
                    }

                    result = Result.getResultByCode(score);
                    System.out.println(result.getMessage());
                }

                // TODO: 5. 사용자 입력에 따라 게임 재개 혹은 종료를 위한 Status 변경
                System.out.println(OPTION_MESSAGE);
                User.setGameOption();

                status = Status.getStatusByGameOption(user.getGameOption());
            }
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException();
        }
    }
}
