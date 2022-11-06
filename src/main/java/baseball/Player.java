package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String inputNum;

    public Player() {
        this.inputNum = "";
    }

    public void setInputNum(String inputNum) {
        this.inputNum = inputNum;
    }

    public List<Integer> getPlayerNum() {
        List<Integer> convertList = new ArrayList<>();
        for (int i = 0; i < this.inputNum.length(); i++) {
            int convert_int = Integer.parseInt(String.valueOf(this.inputNum.charAt(i)));
            convertList.add(convert_int);
        }

        return convertList;
    }
}
