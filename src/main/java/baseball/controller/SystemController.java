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
}
