package baseball.Model;


import baseball.Util.CheckUtil;
import baseball.Util.Constant;

public class User {
    public boolean inputCheck(String userInput) {
        CheckUtil.isInteger(userInput);
        CheckUtil.lengthCheck(userInput, Constant.MAX_LENGTH);
        CheckUtil.isDuplicate(userInput);
        return true;
    }

    public void restartInputCheck(String userInput) {
        CheckUtil.isInteger(userInput);
        CheckUtil.lengthCheck(userInput, Constant.MIN_LENGTH);
    }

}
