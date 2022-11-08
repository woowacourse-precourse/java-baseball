package baseball.domain;
import baseball.validation.Validation;
import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;
import java.util.ArrayList;
public class User {

    public User() {}
    private final ArrayList<Integer> user_selectedNumbers = new ArrayList<>();

    public ArrayList<Integer> getUser_selectedNumbers() {
        return user_selectedNumbers;
    }

    public void pickANumber(){
        try {
            generateNumbers();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void generateNumbers() throws IOException {
        Validation validation = new Validation();
        while(user_selectedNumbers.size()<3){
            String[] numbers = Console.readLine().split("");
            validation.validationNumbers(numbers);
            putTheNumberDrawnByTheUser(numbers);
        }
    }

    private void putTheNumberDrawnByTheUser(String[] numbers) {
        for(String n : numbers){
            user_selectedNumbers.add(Integer.parseInt(n));
        }
    }
}
