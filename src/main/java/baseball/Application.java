package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Application {

    private static final int SIZE = 3;

    private static final int STRIKE = 0;
    private static final int BALL = 1;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }

    private static void playGame() throws IOException {

        printStart();
        List<Integer> computer = getTargetNumbers();

        while (true) {
            List<Integer> user = getToEnterNumbers();
            boolean error = checkUserError(user);

            if (error) {
                break;
            }

            List<Integer> counts = getEachCounts(computer, user);
            printBallStrike(counts);
        }
    }
    private static List<Integer> getEachCounts(List<Integer> computer, List<Integer> user) {

        List<Integer> counts = new ArrayList<>();

        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < SIZE; i++) {
            int computerNumber = computer.get(i);
            int userNumber = user.get(i);

            if (userNumber == computerNumber) {
                strikeCount++;
                continue;
            }
            if (computer.contains(userNumber)) {
                ballCount++;
            }
        }

        counts.add(strikeCount);
        counts.add(ballCount);

        return counts;
    }

    private static boolean checkUserError(List<Integer> user) {

        List<Integer> visitedList = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            int number = user.get(i);

            boolean isError = visitedList.contains(number);

            if (isError) {
                return true;
            }
        }
        return false;
    }

    private static List<Integer> getToEnterNumbers() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        List<Integer> user = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            char currentValue = input.charAt(i);
            Integer number = Integer.valueOf(currentValue);
            user.add(number);
        }

        return user;
    }

    private static List<Integer> getTargetNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // print 로 바꾸기
    private static void printBallStrike(List<Integer> counts) throws IOException {

        int nothing = 0;

        int strikeCount = counts.get(STRIKE);
        int ballCount = counts.get(BALL);

        if (ballCount > nothing && strikeCount > nothing) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        } else if (ballCount > nothing) {
            System.out.println(ballCount + "볼");
        } else if (strikeCount > nothing) {
            System.out.println(strikeCount + "스트라이크");
            checkSuccess(strikeCount);
        } else if (ballCount == nothing && strikeCount == nothing) {
            System.out.println("낫싱");
        }

        return;
    }

    private static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        return;
    }

    private static void checkSuccess(int strikeCount) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        if (strikeCount == SIZE) {
            System.out.println(SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            int toBeContinue = Integer.valueOf(br.readLine());
            checkAgainGame(toBeContinue);
        }

        return;
    }

    private static void checkAgainGame(int toBeContinue) throws IOException {

        int againGame = 1;
        int exitGame = 2;

        if (toBeContinue == againGame) {
            playGame();
        } else if (toBeContinue == exitGame) {
            // 게임 종료
        }
    }
}
