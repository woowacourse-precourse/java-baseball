package baseball;

import java.util.*;

public class Checker {

    private Checker() {

    }

    public static void getResult(List computerList, List userList) {

        // should update userList as user inputs more
        // maybe should make recursion or repetitive function if needed

        if (computerList.equals(userList)) {
            System.out.println("the same");
        }
    }
}
