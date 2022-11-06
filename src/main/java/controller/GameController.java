package controller;

import model.Computer;
import model.UseFunc;
import model.User;

public class GameController {

    User user;
    Computer computer;

    public GameController() {
        this.user = User.getInstanceUser();
        this.computer = Computer.getInstanceUser();
    }

    public void startGame() {
        computer.initComputer();
        computer.initCntStrikeBall();
    }

    public void callInputNumOfUser() {
        this.user.inputNumOfUser();
    }

    public void reStartGame() {
        computer.initComputer();
        computer.initCntStrikeBall();
    }

    public void initCntStrikeBallOfComputer() {
        computer.initCntStrikeBall();
    }

    public boolean isRightNumOfUser2Computer() {
        int numInputOfUser = user.getNumSelecUser();
        if (computer.isRealRightNumOfUser(numInputOfUser)) {
            return true;
        }
        return false;
    }

    public boolean isEndGame() {
        if (computer.isEndTheGame()) {
            return true;
        }
        return false;
    }

    public String getHintOfComputer() {
        int numInputOfUser = user.getNumSelecUser();
        return computer.giveHint2User(numInputOfUser);
    }

    public static GameController getInstanceGameController() {
        return (new GameController());
    }

    final int NUM_RESTART_GAME = 1;
    final int NUM_END_GAME = 2;

    final String MSG_GAME_END = "게임종료";

    public boolean isEndgameInputOfUser(int numInputOfUser) {
        if (isEndGameUserWant(numInputOfUser)) {
            return true;
        }
        isReGameUserWant(numInputOfUser);
        return false;
    }

    private boolean isEndGameUserWant(int numInputOfUser) {
        if (UseFunc.isEqualIntOfTwo(numInputOfUser, NUM_END_GAME)) {
            System.out.println(MSG_GAME_END);
            return true;
        }
        return false;
    }

    private boolean isReGameUserWant(int numInputOfUser) {
        if (UseFunc.isEqualIntOfTwo(numInputOfUser, NUM_RESTART_GAME)) {
            reStartGame();
            return true;
        }
        return false;
    }

}
