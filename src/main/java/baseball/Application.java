package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = makeComputerEntity();
    }
    private static Computer makeComputerEntity() {
        Computer computer = new Computer();
        computer.makeRandomNumber();

        return computer;
    }
}
