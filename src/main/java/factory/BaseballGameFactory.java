package factory;

import controller.impl.BaseballGameController;
import domain.RandNumVO;
import util.Comparator;
import util.Inputer;
import util.impl.InputValueComparator;

public class BaseballGameFactory {

    public BaseballGameController getGame() {
        Inputer inputer = new Inputer();
        Comparator comparator = new InputValueComparator();
        RandNumVO randNumVO = new RandNumVO();

        return new BaseballGameController(randNumVO, comparator, inputer);
    }
}
