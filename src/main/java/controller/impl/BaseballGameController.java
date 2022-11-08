package controller.impl;

import controller.GameController;
import domain.RandNumVO;
import util.Comparator;
import util.Inputer;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameController implements GameController {
    private int conut = 0;
    private RandNumVO randnumVO;
    private Comparator comparator;
    private List<Integer> input;
    private List<Integer> sig;
    private Inputer inputer;

    public BaseballGameController(RandNumVO randnumVO, Comparator comparator) {
        this.randnumVO = randnumVO;
        this.comparator = comparator;
        this.sig = new ArrayList<Integer>(List.of(0,0,0));
        this.inputer = new Inputer();
    }

    @Override
    public void doGame() {

    }
}
