package baseball;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Core T = new Core();
        Baseball game = new Baseball();
        System.out.println("숫자 야구 게임을 시작합니다.");
        //야구게임
        while(true){
            game.run();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInputOneOrTwo = readLine();
            T.validateUserInputOneOrTwo(userInputOneOrTwo);
            if(userInputOneOrTwo.equals("1")){
                continue;
            }
            if(userInputOneOrTwo.equals("2")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
