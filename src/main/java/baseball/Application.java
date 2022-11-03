package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> InputNumber() {
        String number = Console.readLine();
        List<Integer> playerNumber = new ArrayList<>();
        for (int i=0;i<3;++i) {
            playerNumber.add((int)number.charAt(i) - 48);
        }
        System.out.println(playerNumber);
        return playerNumber;
    }
    public static List<Integer> CreateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return (computer);
    }
    public static void main(String[] args) {
        InputNumber();
    }
}
