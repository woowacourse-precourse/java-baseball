package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

enum BaseballResult {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");

    private final String korName;

    BaseballResult(String korName) {
        this.korName = korName;
    }

    public String getKorName() {
        return korName;
    }
}

public class Application {

    private static final int MAX_DIGIT = 3;
    public static void main(String[] args) {
        printGameStartMessage();

        while (true) {
            List<Integer> computerNumber = getComputerNumber();
            System.out.println(computerNumber);

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String userBaseballNumberInput = Console.readLine();
                System.out.println(userBaseballNumberInput);
                validateBaseballNumber(userBaseballNumberInput);

                List<Integer> userNumber = splitStrNumberToList(userBaseballNumberInput);


                HashMap<BaseballResult, Integer> gameResultMap = new HashMap<>();
                for (int i = 0; i < userNumber.size(); i++) {
                    BaseballResult currentIdxGameResult = getCurrentIdxGameResult(i, userNumber, computerNumber);
                    gameResultMap.put(currentIdxGameResult, gameResultMap.getOrDefault(currentIdxGameResult, 0) + 1);
                }
                System.out.println(getGameResult(gameResultMap));

                if (gameResultMap.getOrDefault(BaseballResult.STRIKE, 0) == MAX_DIGIT) {
                    System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", MAX_DIGIT);
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int gameRestartUserSelection = Integer.parseInt(Console.readLine());

            if (!isRestartGame(gameRestartUserSelection)) {
                break;
            }
        }
    }

    private static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static List<Integer> getComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public static List<Integer> splitStrNumberToList(String strNumber) {
        List<Integer> userNumberList = new ArrayList<>();

        userNumberList.add(Character.getNumericValue(strNumber.charAt(0)));
        userNumberList.add(Character.getNumericValue(strNumber.charAt(1)));
        userNumberList.add(Character.getNumericValue(strNumber.charAt(2)));

        return userNumberList;
    }

    public static BaseballResult getCurrentIdxGameResult(int currentIdx, List<Integer> userNumber, List<Integer> computerNumber) {
        if (isEqualInts(userNumber.get(currentIdx), computerNumber.get(currentIdx))) {
            return BaseballResult.STRIKE;
        }

        for (int i = 0; i < userNumber.size(); i++) {
            if (isEqualInts(userNumber.get(currentIdx), computerNumber.get(i))) {
                return BaseballResult.BALL;
            }
        }

        return BaseballResult.NOTHING;
    }

    private static boolean isEqualInts(int number, int comparingNumber) {
        return number == comparingNumber;
    }

    private static String getGameResult(HashMap<BaseballResult, Integer> gameResult) {
        StringBuilder sb = new StringBuilder();

        Optional<Integer> nothingCnt = Optional.ofNullable(gameResult.get(BaseballResult.NOTHING));
        if (nothingCnt.isPresent() && nothingCnt.get() == 3) {
            sb.append(BaseballResult.NOTHING.getKorName()).append('\n');
            return sb.toString();
        }

        Optional<Integer> ballCnt = Optional.ofNullable(gameResult.get(BaseballResult.BALL));
        ballCnt.ifPresent(integer -> sb.append(integer).append(BaseballResult.BALL.getKorName()).append(" "));

        Optional<Integer> strikeCnt = Optional.ofNullable(gameResult.get(BaseballResult.STRIKE));
        strikeCnt.ifPresent(integer -> sb.append(integer).append(BaseballResult.STRIKE.getKorName()).append(" "));

        return sb.toString();
    }

    private static boolean isRestartGame(int userSelect) {
        return userSelect == 1;
    }
}
