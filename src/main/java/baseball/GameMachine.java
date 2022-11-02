package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameMachine {
    boolean gaming;
    List<Integer> computer;
    List<Integer> gamer;

    GameMachine() {
        gaming = false;
        computer = Collections.emptyList();
        gamer = Collections.emptyList();
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> random = new ArrayList<>();
        while(random.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!random.contains(randomNumber)) {
                random.add(randomNumber);
            }
        }

        return random;
    }

    public List<Integer> convertGamerNumber(String input) throws RuntimeException {
        if(input.length() != 3) {
            throw new IllegalArgumentException();
        }

        List<Integer> number = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if(!('1' <= ch && ch <= '9')) {
                throw new IllegalArgumentException();
            }

            int n = Character.getNumericValue(ch);
            number.add(n);
        }

        return number;
    }

    public boolean restart(String input) throws  RuntimeException {
        if(!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException();
        }

        return input.equals("1");
    }

    public List<Integer> strikeAndBall() {
        int strike = 0, ball = 0;

        for(int i = 0; i < 3; i++) {
            if(computer.get(i).equals(gamer.get(i))) {
                strike++;
            }
        }

        for(int i = 0; i < 3; i++) {
            if(computer.contains(gamer.get(i))) {
                ball++;
            }
        }

        ball -= strike;

        return Arrays.asList(strike, ball);
    }
}
