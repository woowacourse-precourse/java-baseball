package baseball;

import java.util.List;

public class Game {
    private static Computer computer=new Computer();
    public static User user=new User();
    public static void start() {
        user.register(computer);
        while (true){
            computer.makeRandomNumber();
            startUnitGame();
        }
    }

    private static void startUnitGame() {
        while (true){
            user.makeBaseBallNumber();
            List<Hint> hintList = user.compareToComputer();
            Long ballCount = hintList.stream().filter(h -> h.equals(Hint.BALL)).count();
            Long strikeCount = hintList.stream().filter(h -> h.equals(Hint.STRIKE)).count();

            List<String> hintStringList=genHintList(ballCount, strikeCount);

            String hinString = String.join(" ", hintStringList);
            print(hinString);
        }
    }

    private static List<String> genHintList(Long ballCount, Long strikeCount) {
        if(isNothing(ballCount, strikeCount)){
            return List.of(Hint.NOTHING.hintString(1L));
        }

        return List.of(Hint.BALL.hintString(ballCount),Hint.STRIKE.hintString(strikeCount));
    }

    private static boolean isNothing(Long ballCount, Long strikeCount) {
        return ballCount == 0 && strikeCount == 0;
    }

    private static void print(String hinString) {
        System.out.println(hinString);
    }
}
