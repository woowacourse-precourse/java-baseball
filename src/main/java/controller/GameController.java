package controller;

import model.Computer;
import model.User;

public class GameController {

    User user;
    Computer computer;

    public GameController() {
        this.user = new User();
        this.computer = new Computer();
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
}
