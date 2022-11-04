package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Validate.*;

abstract public class NumberGame {
    protected String computer;

    abstract public void start();

    abstract public boolean play();

    abstract public boolean end();
}