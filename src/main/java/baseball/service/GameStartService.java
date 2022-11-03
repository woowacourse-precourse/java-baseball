package baseball.service;

import baseball.util.UserUtil;

import java.util.List;

public class GameStartService {
    public static String saveUserNumber() {
        String userNumberString = UserUtil.getUserNumberString();
        return userNumberString;
    }



}
