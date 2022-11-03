package baseball.service;

import baseball.repository.GameStartRepository;
import baseball.util.UserUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameStartService {
    public static void saveUserNumber() {
        String userNumberString = UserUtil.getUserNumberString();
        List<String> userNumberList = transferToList(userNumberString);
        GameStartRepository.save(userNumberList);
    }

    private static List<String> transferToList(String userNumberString) {
        List<String> userNumberList = new ArrayList<>(Arrays.asList(userNumberString.split("")));
        return userNumberList;
    }


}
