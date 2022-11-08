package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Application{
    public static List<String> input_valid_set = Arrays.asList("1","2","3","4","5","6","7","8","9");
    public static List<String> terminate_valid_set = Arrays.asList("1","2");
    private List<Integer> answer;
    private String input_text;

    public Application() {
        this.answer = new ArrayList<>();
    }

    public void pickRandomNumber() {
        while (this.answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.answer.contains(randomNumber)) {
                this.answer.add(randomNumber);
            }
        }
    }

    public boolean checkValidInput(List<String> valid_set) {
        int input_len = this.input_text.length();

        for (int i = 0; i < input_len; i++) {
            if (!valid_set.contains(this.input_text.substring(i,i+1)))
                return false;
        }

        return true;
    }

    public void readLine(boolean onGame){
        this.input_text = Console.readLine();
        if(onGame) {
            if(checkValidInput(input_valid_set))
                throw new IllegalArgumentException();
        }
        else{
            if(checkValidInput(terminate_valid_set))
                throw new IllegalArgumentException();
        }
    }

    public void playGame() {

    }

    public static void main(String[] args) {
        Application app = new Application();

        System.out.println("숫자 야구 게임을 시작합니다.");
        try {
            while (true) {
                app.playGame();
            }
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Invalid Input.");
            System.exit(0);
        }
    }
}
