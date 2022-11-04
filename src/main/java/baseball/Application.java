package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        User user;
        do {
            List<Integer> computerNumberList = new Computer().computerNumberList;
            user = new User(computerNumberList);
            user.main();
        } while (user.keepGame);
    }
}

