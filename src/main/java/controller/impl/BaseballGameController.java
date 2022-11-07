package controller.impl;

import controller.Controller;

public class BaseballGameController implements Controller {
    private int conut = 0;
    private RandnumVO randnumVO;
    private Comparator comparator;

    public BaseballGameController(RandnumVO randnumVO, Comparator comparator) {
        this.randnumVO = randnumVO;
        this.comparator = comparator;
    }

    @Override
    public void doGame() {

    }
}
