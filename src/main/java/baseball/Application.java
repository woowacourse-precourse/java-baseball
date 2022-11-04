package baseball;

public class Application {
    public static void main(String[] args) {

        String numberComputer = Input.computer();
        System.out.println(numberComputer);

        String numberPlayer = Input.player();
        System.out.println(numberPlayer);

        PlayingBaseball round = new PlayingBaseball(numberComputer, numberPlayer);
        System.out.println(round.countStrikes());


        }
    }
