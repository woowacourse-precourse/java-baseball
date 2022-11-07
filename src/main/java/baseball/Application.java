package baseball;

import static baseball.CompareAnswer.*;

public class Application {
    static int ERROR =1;

    public static void playBaseball() {
        boolean finish = false;

        System.out.println("숫자 야구 게임을 시작합니다.");

        Computer computerNumber = new Computer();
        computerNumber.setComputerNumbers();

        User userNumber = new User();

        while (finish == false) {
            userNumber.setUserNumbers();
            if(ERROR == 2) return;
            finish = compareAnswer(computerNumber.getComputerNumbers(), userNumber.getUserNumbers());

/*            System.out.println();
            System.out.println("computer");
            for (int a : computerNumber.getComputerNumbers()) System.out.print(a + " ");
            System.out.println();
            System.out.println("user");
            for (int a : userNumber.getUserNumbers()) System.out.print(a + " ");*/
        }
    }
    public static void main(String[] args) {
        playBaseball();
    }
}