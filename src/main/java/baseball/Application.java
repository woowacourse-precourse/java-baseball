package baseball;


import java.util.*;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.init();
    }
}

class Game {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_NOT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    private static final int NUM_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int RESTART_ANSWER = 1;
    private static final int QUIT_ANSWER = 2;

    static List<Integer> intInput = new ArrayList<>();
    static List<Integer> computer = new ArrayList<>();
    static int nStrike, nBall = 0;
    static int restartAnswer = RESTART_ANSWER;

    public static void init() {
        System.out.println(START_MESSAGE);
        for (int i = 0; i < NUM_LENGTH; i++)
            intInput.add(0);
        gameStart();
    }

    public static void gameStart() {
        if (restartAnswer == RESTART_ANSWER) {
            computer = pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUM_LENGTH);
            //System.out.println("computer --- " + computer);
            startToGetNumFromUser();
        }
    }

    public static void startToGetNumFromUser() {
        getNumber();
        printAnswer(computer);
    }

    public static void getNumber() {
        initNum();
        String input;
        Scanner sc = new Scanner(System.in);
        System.out.println(INPUT_MESSAGE);
        input = sc.nextLine();

        checkInputError(input);
        stringToInteger(input);
    }

    public static void initNum() {
        nStrike = 0;
        nBall = 0;
    }

    public static void printAnswer(List<Integer> computer) {
        checkAnswer(computer);

        if (isNothing()) {
            System.out.println(NOTHING);
        } else if (isSuccess()) {
            wannaRestart();
            gameStart();
        } else {
            System.out.println(nBall + BALL + " " + nStrike + STRIKE);
        }
        if(restartAnswer == RESTART_ANSWER)
            startToGetNumFromUser();
    }

    public static void checkAnswer(List<Integer> computer) {
        isEqual(computer);
        isNothing();
    }

    public static void isEqual(List<Integer> computer) {
        for (int i = 0; i < NUM_LENGTH; i++)
            if (intInput.contains(computer.get(i)))
                strikeOrBall(computer.get(i), i);
    }

    public static void strikeOrBall(int checkNum, int index) {
        if (intInput.get(index) == checkNum)
            nStrike++;
        else
            nBall++;
    }

    public static boolean isNothing() {
        if (nStrike == 0 && nBall == 0)
            return true;
        else return false;
    }

    public static boolean isSuccess() {
        if (nStrike == NUM_LENGTH) {
            System.out.println(NUM_LENGTH + STRIKE);
            System.out.println(SUCCESS);
            return true;
        }
        return false;
    }

    public static int wannaRestart() {
        System.out.println(RESTART_OR_NOT);
        Scanner sc = new Scanner(System.in);
        int restartOrNot = sc.nextInt();

        if (restartOrNot == 1) {
            restartAnswer = RESTART_ANSWER;
            gameStart();
            return RESTART_ANSWER;
        }
        else if (restartOrNot == 2) {
            restartAnswer = QUIT_ANSWER;
            return QUIT_ANSWER;
        } else
            throw new IllegalArgumentException();
    }

    public static void stringToInteger(String input) {
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            intInput.set(i, c - '0');
        }
    }

    public static void checkInputError(String input) {
        checkLength(input);
        checkRange(input);
        checkDuplicate(input);
    }

    public static void checkLength(String input) {
        if (input.length() != NUM_LENGTH)
            throw new IllegalArgumentException();
    }

    public static void checkRange(String input) {
        for (int i = 0; i < input.length(); i++)
            if (input.charAt(i) == '0')
                throw new IllegalArgumentException();
    }

    public static void checkDuplicate(String input) {
        if (input.charAt(0) == input.charAt(1))
            throw new IllegalArgumentException();
        else if (input.charAt(0) == input.charAt(2))
            throw new IllegalArgumentException();
        else if (input.charAt(1) == input.charAt(2))
            throw new IllegalArgumentException();
    }
}