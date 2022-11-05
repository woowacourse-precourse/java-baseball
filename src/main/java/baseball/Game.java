package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.Texts;

public class Game {
    Computer computer;
    User user;
    public Game() {
        computer = new Computer();
        user = new User();
    }
    public void run() {
        System.out.println(Texts.GAME_BEGIN);
        do {
            play();
            System.out.println(Texts.GAME_RESTART);
        } while (Console.readLine().equals("1"));
        System.out.println(Texts.GAME_END);
    }
    public void play() {
        computer.makeComputerNumber();
        user.makeUserNumber();
        System.out.println("---TestOut : computer: "+computer.getNumber()+" user: "+user.getNumber());
        user.getNumber().add(50);
        System.out.println("---TestOut : computer: "+computer.getNumber()+" user: "+user.getNumber());
    }
}
