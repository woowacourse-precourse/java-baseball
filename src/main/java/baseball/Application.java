package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while(true) {
            Game game = new Game();
            game.playgame();
            if (!game.gameRestart()) break;
        }
     }
    }










