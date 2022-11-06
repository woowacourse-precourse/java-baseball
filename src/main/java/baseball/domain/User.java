package baseball.domain;


import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.exception.InputUserNumberException;
import java.util.ArrayList;
import java.util.List;

public class User {

    private static List<Integer> selectNumber = new ArrayList<>();
    private static InputUserNumberException inputUserNumberException = new InputUserNumberException();

    public List<Integer> getSelectNumber() {
        return selectNumber;
    }

    public void setSelectNumber() {
        String InputNumber = readLine();
        inputUserNumberException.findUserNumberException(InputNumber);
        initList();
        for (int index = 0; index < InputNumber.length(); index++) {
            selectNumber.add(InputNumber.charAt(index) - '0');
        }
    }

    public void initList() {
        selectNumber = new ArrayList<>();
    }
}
