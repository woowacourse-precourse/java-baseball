package baseball.Model;


import baseball.Util.CheckUtil;

public class User {
    public boolean inputCheck(String userInput) {
        CheckUtil.isInteger(userInput);
        CheckUtil.lengthCheck(userInput);
        CheckUtil.isDuplicate(userInput);
        return true;
    }

}
