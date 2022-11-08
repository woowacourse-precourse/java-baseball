package baseball;

import java.util.*;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame {

    State currentState;
    Trigger currentTrigger;
    Scanner cin;
    static Map<List<Integer>, State> rules;

    static {
        rules = new HashMap<>();
        rules.put(List.of(State.ON_GAME.ordinal(), Trigger.INCORRECT_ANSWER.ordinal()), State.ON_GAME);
        rules.put(List.of(State.ON_GAME.ordinal(), Trigger.INVALID_USER_INPUT.ordinal()), State.EXIT_GAME);
        rules.put(List.of(State.ON_GAME.ordinal(), Trigger.CORRECT_ANSWER.ordinal()), State.FINISH_GAME);
        rules.put(List.of(State.FINISH_GAME.ordinal(), Trigger.EXIT.ordinal()), State.EXIT_GAME);
        rules.put(List.of(State.FINISH_GAME.ordinal(), Trigger.RE_GAME.ordinal()), State.START_GAME);
        rules.put(List.of(State.START_GAME.ordinal(), Trigger.COMPLETE_INITIATION.ordinal()), State.ON_GAME);
    }

    protected List<Integer> answerNumber;

    public BaseBallGame() {
        currentState = State.START_GAME;
        currentTrigger = null;
        cin = new Scanner(System.in);
    }


    public void run() {
        while (true) {
            doStateRoutine();
            if (currentState == State.EXIT_GAME)
                return;
            currentState = rules.get(List.of(currentState.ordinal(), currentTrigger.ordinal()));

        }
    }

    private void doStateRoutine() {
        List<Integer> input;
        switch (currentState) {
            case START_GAME:
                System.out.println("숫자 야구 게임을 시작합니다.");
                generateNumber();
                currentTrigger = Trigger.COMPLETE_INITIATION;
                return;
            case FINISH_GAME:
            case ON_GAME:
                input = getUserInput();
                getResultOfInput(input);
                break;
        }
    }

    private void generateNumber() {
        if (answerNumber == null) {
            answerNumber = new ArrayList<>();
        }
        if (!answerNumber.isEmpty()) {
            answerNumber.clear();
        }
        while (answerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumber.contains(randomNumber)) {
                answerNumber.add(randomNumber);
            }
        }
    }

    private List<Integer> getUserInput() {
        List<Integer> result;

        String inputString;

        switch (currentState) {
            case ON_GAME:
                System.out.printf("숫자를 입력해주세요 :");
                inputString = cin.nextLine();
                System.out.println(inputString);
                result = inputStringToList(inputString);
                break;
            case FINISH_GAME:
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                inputString = cin.nextLine();
                result = inputStringToList(inputString);
                break;
            default:
                result = Collections.emptyList();
        }
        return result;
    }

    private List<Integer> inputStringToList(String inputString) {
        if (!validateUserInput(inputString)) {
            currentTrigger = Trigger.INVALID_USER_INPUT;
            throw new IllegalArgumentException();
        }
        int input = Integer.parseInt(inputString);
        List<Integer> result = new ArrayList<>();
        while (input >= 1) {
            result.add(input % 10);
            input = input / 10;
        }
        Collections.reverse(result);
        return result;
    }


    private boolean validateUserInput(String inputString) {
        switch (currentState) {
            case ON_GAME:
                return Pattern.matches("[1-9]{3}", inputString);
            case FINISH_GAME:
                return Pattern.matches("[1-2]", inputString);
            default:
                return false;
        }
    }

    private void getResultOfInput(List<Integer> input) {
        switch (currentState) {
            case ON_GAME:
                getResultAndPrint(input);
                return;
            case FINISH_GAME:
                selectRestartOrNot(input);
                return;
            default:
                return;
        }
    }

    private void getResultAndPrint(List<Integer> input) {

        int strike = 0, ball = 0;

        for (int i : answerNumber) {
            if (!input.contains(i)) continue;
            if (input.indexOf(i) == answerNumber.indexOf(i)) strike++;
            else ball++;
        }
        printResult(ball, strike);

        if (strike == 3) currentTrigger = Trigger.CORRECT_ANSWER;
        else currentTrigger = Trigger.INCORRECT_ANSWER;

    }

    private void printResult(int ball, int strike) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if (ball != 0 && strike == 0) {
            System.out.printf("%d볼\n", ball);
        } else if (ball != 0) {
            System.out.printf("%d볼 ", ball);
        }
        if (strike != 0) {
            System.out.printf("%d스트라이크\n", strike);
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private void selectRestartOrNot(List<Integer> input) {
        if (input.get(0) == 1) {
            currentTrigger = Trigger.RE_GAME;
        } else {
            currentTrigger = Trigger.EXIT;
        }
    }


    enum State {
        START_GAME, ON_GAME, FINISH_GAME, EXIT_GAME;

    }

    enum Trigger {
        INVALID_USER_INPUT, INCORRECT_ANSWER, CORRECT_ANSWER, RE_GAME, EXIT, COMPLETE_INITIATION;
    }


}
