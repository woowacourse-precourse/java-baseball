package baseball;

import static baseball.HitStatus.BALL;
import static baseball.HitStatus.NOTHING;
import static baseball.HitStatus.STRIKE;
import static baseball.Validation.validate;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private void initGame() {
        initComputer();
        initPlayer();
    }


    private void setUserNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            player.set(i, Integer.parseInt(String.valueOf(number.charAt(i))));
        }
    }
    private void initPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String number= Console.readLine();
        validate(number);
        setUserNumber(number);
    }
    private void initStepResult(){
        stepResult = new ArrayList<>(Arrays.asList(NOTHING, NOTHING, NOTHING));
    }
    private void initStep() {
        initPlayerInput();
        initStepResult();
    }


    private boolean checkIsBall(int index, int current) {
        return stepResult.get(index) != STRIKE && computer.contains(current);
    }
    private boolean checkIsStrike(int index, int current){
        return computer.get(index) == current;
    }
    private void doHitLogic() {
        for (int i = 0; i < 3; i++) {
            int currentUserNumber = player.get(i);

            if (checkIsStrike(i,currentUserNumber)) {
                stepResult.set(i, STRIKE);
            }
            if (checkIsBall(i, currentUserNumber)) {
                stepResult.set(i, BALL);
            }
        }
    }


    public void play() {
        initGame();

        // TODO: 게임 진행
        while(true){
            initStep();
            doHitLogic();
            break;
            //TODO: 결과 분석 및 결과에 따른 행동 수행 요구
        }


    }
}