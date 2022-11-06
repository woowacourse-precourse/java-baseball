package baseball;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Arrays.stream(HintInfo.values()).filter(s->s.getBallCount()==2 && s.getStrikeCount()==0).forEach(s-> System.out.println(s.getTitle()));
    }
}
