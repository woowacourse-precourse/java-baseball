package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = makeComputerEntity();
        Player player = makePlayerEntity();
    }

    private static Computer makeComputerEntity() {
        Computer computer = new Computer();
        computer.makeRandomNumber();

        return computer;
    }

    private static Player makePlayerEntity() {
        Player player = new Player();
        player.makeUserNumber();

        return player;
    }
}
