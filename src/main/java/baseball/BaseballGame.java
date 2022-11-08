package baseball;

import static baseball.GameStatus.END;
import static baseball.GameStatus.START;
import static baseball.HitStatus.BALL;
import static baseball.HitStatus.NOTHING;
import static baseball.HitStatus.STRIKE;
import static baseball.Validation.validate;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BaseballGame {
    private List<Integer> computer;
    private List<Integer> player;
    private List<HitStatus> stepResult;


    private void initComputer() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private void initPlayer() {
        player = new ArrayList<>(Arrays.asList(0, 0, 0));
    }

    private void initCommand(){System.out.println("숫자 야구 게임을 시작합니다.");}
    private void initGame() {
        initComputer();
        initPlayer();
        initCommand();
    }


    private Map<HitStatus, Integer> countAllHitStatus() {
        int strike = 0, ball = 0, nothing = 0;
        for (int i = 0; i < 3; i++) {
            if (stepResult.get(i) == STRIKE) {
                strike++;
            } else if (stepResult.get(i) == BALL) {
                ball++;
            } else {
                nothing++;
            }
        }

        Map<HitStatus, Integer> result = new HashMap<>();
        result.put(STRIKE, strike);
        result.put(BALL, ball);
        result.put(NOTHING, nothing);
        return result;
    }

    private boolean userContinueGame() {
        boolean continueGame;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        if (userInput.equals(START.getCode())) {
            continueGame = true;
        } else if (userInput.equals(END.getCode())) {
            continueGame = false;
        } else {
            throw new IllegalArgumentException();
        }
        return continueGame;
    }
    private boolean checkThreeStrike(Map<HitStatus, Integer> result,List<String> resultForPlayer){
        final int THREE_STRIKE=3;
        boolean threeStrike=false;
        if (result.get(STRIKE) == THREE_STRIKE) {
            threeStrike = true;
            resultForPlayer.add("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        return threeStrike;
    }
    private boolean checkResult() {

        boolean threeStrike = false;
        List<String> resultForPlayer = new ArrayList<>();
        Map<HitStatus, Integer> result = countAllHitStatus();
        // 결과확인
        if (result.get(BALL) != 0) {
            resultForPlayer.add(result.get(BALL) + BALL.getName());
        }
        if (result.get(STRIKE) != 0) {
            resultForPlayer.add(result.get(STRIKE) + STRIKE.getName());
            threeStrike=checkThreeStrike(result,resultForPlayer);
        }
        if (result.get(NOTHING) == 3) {
            resultForPlayer.add(NOTHING.getName());
        }
        System.out.println(String.join(" ", resultForPlayer));
        return threeStrike;
    }

    private boolean analyzeResult() {
        boolean continueGame;
        boolean isThreeStrike = checkResult();
        if (isThreeStrike) {
            boolean wantContinueGame = userContinueGame();
            if (wantContinueGame) {
                continueGame = true;
                initGame();
            } else {
                continueGame = false;
            }
        } else {
            continueGame = true;
        }
        return continueGame;
    }


    private boolean checkIsBall(int index, int current) {
        return stepResult.get(index) != STRIKE && computer.contains(current);
    }

    private boolean checkIsStrike(int index, int current) {
        return computer.get(index) == current;
    }

    private void doHitLogic() {
        for (int i = 0; i < 3; i++) {
            int currentUserNumber = player.get(i);

            if (checkIsStrike(i, currentUserNumber)) {
                stepResult.set(i, STRIKE);
            }
            if (checkIsBall(i, currentUserNumber)) {
                stepResult.set(i, BALL);
            }
        }
    }


    private void setUserNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            player.set(i, Integer.parseInt(String.valueOf(number.charAt(i))));
        }
    }

    private void initPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        validate(number);
        setUserNumber(number);
    }

    private void initStepResult() {
        stepResult = new ArrayList<>(Arrays.asList(NOTHING, NOTHING, NOTHING));
    }

    private void initStep() {
        initPlayerInput();
        initStepResult();
    }


    public void play() {
        initGame();

        while (true) {
            initStep();
            doHitLogic();

            if (!analyzeResult()) {
                System.out.println("게임 종료");
                break;
            }
        }
    }
}