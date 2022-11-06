package baseball.Model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> user = new ArrayList<>();
    private List<Integer> computer = new ArrayList<>();

    public void saveUserNumber(List<Integer> user) {
        this.user = user;
    }

    public void saveComputerNumber(List<Integer> computer) {
        this.computer = computer;
    }
}
