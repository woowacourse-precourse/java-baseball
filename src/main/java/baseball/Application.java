package baseball;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<Integer> answer = Game.MakeAnswer();

    }
}

class Game {
    static List<Integer> MakeAnswer() {
        List<Integer> answer = new ArrayList<>();

        while(answer.size() < 3) {
            int num = (int) (Math.random() * 9 + 1);
            if(!(answer.contains(num))) {
                answer.add(num);
            }
        }

        return answer;
    }
}