package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static boolean endGame(List<Integer> countBallStrike) {
         return countBallStrike.get(1) == 3;
    }
    public static int countBall(int playerNumber, List<Integer> randomNumber, int i) {
        int ball = 0;
        for (int j=0;j<3;++j)
            if (i != j && playerNumber == randomNumber.get(j))
                ball += 1;
        return ball;
    }
    public static boolean printBallStrike(List<Integer> countBallStrike) {
        boolean end = endGame(countBallStrike);
        if (countBallStrike.get(0) == 0 && countBallStrike.get(1) == 0)
            System.out.println("낫싱");
        else if (countBallStrike.get(0) != 0 && countBallStrike.get(1) != 0)
            System.out.println(countBallStrike.get(0) + "볼 " + countBallStrike.get(1) + "스트라이크");
        else if (countBallStrike.get(0) != 0 && countBallStrike.get(1) == 0)
            System.out.println(countBallStrike.get(0) + "볼");
        else if (countBallStrike.get(0) == 0 && countBallStrike.get(1) != 0)
            System.out.println(countBallStrike.get(1) + "스트라이크");
        return end;
    }
    public static List<Integer> createCountArray(int ball, int strike) {
        List<Integer> countBallStrike = new ArrayList<>();
        countBallStrike.add(ball);
        countBallStrike.add(strike);
        return countBallStrike;
    }
    public static boolean compareNumber(List<Integer> playerNumber, List<Integer> randomNumber) {
        int ball = 0;
        int strike = 0;
        for (int i=0;i<3;++i) {
            if (Objects.equals(playerNumber.get(i), randomNumber.get(i)))
                strike += 1;
            else
                ball += countBall(playerNumber.get(i), randomNumber, i);
        }
        return printBallStrike(createCountArray(ball, strike));
    }
    public static boolean errorPlayerNumber(String playerNumber) {
        boolean error = (playerNumber.length() == 3);
        for (int i=0;i<playerNumber.length();++i)
            if (playerNumber.charAt(i) < '1' || playerNumber.charAt(i) > '9') {
                error = false;
                break;
            }
        if (playerNumber.length() == 3 && ((playerNumber.charAt(0) == playerNumber.charAt(1))
                || (playerNumber.charAt(0) == playerNumber.charAt(2))
                || (playerNumber.charAt(1) == playerNumber.charAt(2))))
            error = false;
        return error;
    }
    public static List<Integer> arrayPlayerNumber(String number) {
        List<Integer> playerNumber = new ArrayList<>();
        for (int i=0;i<number.length();++i)
            playerNumber.add((int)number.charAt(i) - 48);
        return playerNumber;
    }
    public static String inputPlayerNumber() {
        String number = Console.readLine();
        checkError(errorPlayerNumber(number));
        return number;
    }
    public static List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
        return (computer);
    }
    public static void inputGame(boolean end, List<Integer> randomNumber) {
        while (!end) {
            System.out.print("숫자를 입력해주세요 : ");
            end = compareNumber(arrayPlayerNumber(inputPlayerNumber()), randomNumber);
        }
    }
    public static void restartGame(boolean restart) {
        if (restart)
            playGame();
    }
    public static boolean checkErrorRestartNumber(String number) {
        boolean error = true;
        if (number.length() != 1)
            error = false;
        else if (number.charAt(0) != '1' && number.charAt(0) != '2')
            error = false;
        return error;
    }
    public static boolean restartQuestion() {
        boolean restart = false;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String number = Console.readLine();
        checkError(checkErrorRestartNumber(number));
        if (number.charAt(0) == '1')
            restart = true;
        return restart;
    }
    public static void playGame() {
        List<Integer> randomNumber = createRandomNumber();
        boolean end = false;
        inputGame(end, randomNumber);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        restartGame(restartQuestion());
    }
    public static void startApplication() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }
    public static void checkError(boolean check) {
        if (!check)
            throw new IllegalArgumentException();
    }
    public static void main(String[] args) {
        startApplication();
    }
}
