package baseball;

import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame implements AutoCloseable {

    State currentState;
    Trigger currentTrigger;
    static Map<List<Integer>, State> rules;

    static {
        rules = new HashMap<>();
        rules.put(List.of(State.ON_GAME.ordinal(),
                Trigger.INCORRECT_ANSWER.ordinal()),
                State.ON_GAME);
        rules.put(List.of(State.ON_GAME.ordinal(),
                 Trigger.INVALID_USER_INPUT.ordinal()),
                State.EXIT_GAME);
        rules.put(List.of(State.ON_GAME.ordinal(),
                        Trigger.CORRECT_ANSWER.ordinal()),
                State.FINISH_GAME);
        rules.put(List.of(State.FINISH_GAME.ordinal(),
                Trigger.EXIT.ordinal()),
                State.EXIT_GAME);
        rules.put(List.of(State.FINISH_GAME.ordinal(),
                        Trigger.RE_GAME.ordinal()),
                State.START_GAME);
    }
    protected List<Integer> answerNumber;

    public BaseBallGame(int hashcode) {
        currentState = State.START_GAME;
        currentTrigger = null;
    }

    @Override
    public void close() throws Exception {

    }

    public void run()  {
        while(true){
            List<Integer> input;
            System.out.printf("current State : %d" , currentState.ordinal());
            switch(currentState){
                case START_GAME:
                    System.out.println("숫자 야구 게임을 시작합니다.");
                    LocalDateTime now = LocalDateTime.now();
                    generateNumber(now.hashCode());
                    currentState = State.ON_GAME;
                    continue;
                case FINISH_GAME:
                case ON_GAME:
                    input = getUserInput();
                    getResultOfAnswer(input);
                    break;
                case EXIT_GAME:
                default :
                    return;

            }
            currentState = rules.get(List.of(currentState.ordinal(),currentTrigger.ordinal()));

        }
    }

    private void generateNumber(int randomSeed) {
        if (answerNumber == null) {
            answerNumber = new ArrayList<>();
        }
        if (!answerNumber.isEmpty()) {
            answerNumber.clear();
        }
        while (answerNumber.size() < 3) {
            int randomNumber = (Randoms.pickNumberInRange(1, 9) + randomSeed % 10) % 9 + 1;
            if (!answerNumber.contains(randomNumber)) {
                answerNumber.add(randomNumber);
            }
        }
    }

    private List<Integer> getUserInput() {

        Scanner cin = new Scanner(System.in);
        String inputString;

        switch (currentState){
            case ON_GAME:
                System.out.printf("숫자를 입력해주세요 :");
                inputString = cin.nextLine();
                return inputStringToList(inputString);
            case FINISH_GAME:
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                inputString = cin.nextLine();
                return inputStringToList(inputString);
            default:
                return Collections.emptyList();
        }
    }

    private List<Integer> inputStringToList(String inputString){
        if( !validateUserInput(inputString)){
            currentTrigger = Trigger.INVALID_USER_INPUT;
            throw new IllegalArgumentException();
        }
        int input = Integer.parseInt(inputString);
        List<Integer> result = new ArrayList<>();
        while(input >= 1){
            result.add(input %10);
            input = input / 10;
        }
        Collections.reverse(result);
        return result;
    }


    private boolean validateUserInput(String inputString) {
        switch (currentState){
            case ON_GAME:
                return Pattern.matches("[1-9]{3}",inputString);
            case FINISH_GAME:
                return Pattern.matches("[1-2]",inputString);
            default :
                return  false;
        }
    }

    private List<Integer> getResultOfAnswer(List<Integer> challengeNumber) {
        return Collections.emptyList();
    }

    private void printResult(List<Integer> result) {
    }

    enum State {
        START_GAME
        ,ON_GAME
        ,FINISH_GAME
        ,EXIT_GAME;

    }

    enum Trigger {
        INVALID_USER_INPUT,
        INCORRECT_ANSWER,
        CORRECT_ANSWER,
        RE_GAME,
        EXIT;
    }


}
