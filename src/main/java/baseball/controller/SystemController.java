package baseball.controller;

import baseball.model.SystemComputerModel;
import baseball.model.SystemScoreModel;
import baseball.model.SystemUserModel;
import baseball.view.SystemView;

import static baseball.model.SystemScoreModel.STRIKE;
import static baseball.model.SystemScoreModel.BALL;
import static baseball.model.SystemScoreModel.NOTHING;
public class SystemController {
    private static final int DIGIT_COUNT = 3;
    private static final String START = "숫자 야구 게임을 시작합니다.";
    private static final String THREE_STRIKE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final SystemView systemView = new SystemView();

    private boolean exit = false;

    private int strike = 0;
    private int ball = 0;

    public SystemController() {
    }

    public void baseball() {
        System.out.println(START);
        SystemComputerModel systemComputerModel = new SystemComputerModel();
        SystemUserModel systemUserModel = new SystemUserModel();

        systemComputerModel.setRandomNumber();

        while (!exit) {
            String input = systemView.startInput();
            systemUserModel.setDigits(input);

            resetScore();
            calculateScore(systemComputerModel, systemUserModel);
            printResult();

            if (strike == DIGIT_COUNT) {
                readyToExit(systemComputerModel);
            }
        }
    }

    public void calculateScore(SystemComputerModel systemComputerModel, SystemUserModel systemUserModel) {
        for (int i = 0; i < DIGIT_COUNT; i++) {
            SystemScoreModel systemScoreModel = systemComputerModel.getScore(systemUserModel.getDigit(i), i);
            increase_strike_or_ball(systemScoreModel);
        }
    }

    public void increase_strike_or_ball(SystemScoreModel systemScoreModel){
        if (systemScoreModel == BALL) {
            ball++;
        }
        if (systemScoreModel == STRIKE) {
            strike++;
        }
    }

    public void resetScore() {
        strike = 0;
        ball = 0;
    }

    public void readyToExit(SystemComputerModel systemComputerModel) {
        String input = systemView.restartInput();
        if (systemComputerModel.isReadyToExit(input)) {
            exit = true;
        }
        if(!systemComputerModel.isReadyToExit(input)){
            systemComputerModel.setRandomNumber();
        }
    }

    public void printResult() {
        System.out.println(SystemScoreModeltoString());
        if (strike == DIGIT_COUNT) {
            System.out.println(THREE_STRIKE);
        }
    }

    public String SystemScoreModeltoString() {
        if (strike == 0 && ball == 0) {
            return NOTHING.getScore();
        }
        return SystemScoreModeltoStringBuilder();
    }
}
