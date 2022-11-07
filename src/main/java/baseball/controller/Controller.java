package baseball.controller;

import java.util.List;

import baseball.model.Computer;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;

import exception.Exceptions;

public class Controller {
    private boolean GAME_END = true;
    private boolean GAME_NOT_END = false;
    private static final String END_MESSAGE = "2";
    private static final String RESTART_MESSAGE = "1";
    private static final int END_STRIKE_COUNT = 3;
    private static final String END_EXCEPTION_MESSAGE = "입력이 잘못되었어요";
    private List<Integer> userNumber;
    private List<Integer> computerNumber;
    private boolean isGameEnd = false;
    private int strike = 0;
    private int ball = 0;

    Computer computer;
    User user;

    public Controller() {
        computer = new Computer();
        user = new User();

    }
    
    static boolean isStrikeNumber(List<Integer> computerNumber, int userNumber, int userNumberIndex) {
        for (int i = 0; i < computerNumber.size(); i++) {
            if (computerNumber.get(i) == userNumber && i == userNumberIndex) {
                return true;
            }
        }
        return false;
    }


}
