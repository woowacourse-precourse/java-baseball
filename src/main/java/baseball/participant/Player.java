package baseball.participant;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String predictNumber() {
        return Console.readLine();
    }
}
