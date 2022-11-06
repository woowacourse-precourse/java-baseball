package baseball;


import static baseball.Answer.compareAnswer;

public class Application {
    public static void playBaseball(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        Computer computerNumber = new Computer();
        computerNumber.setComputerNumbers();

        User userNumber = new User();
        userNumber.setUserNumbers();

        compareAnswer(computerNumber.computerNumbers,userNumber.userNumbers);

        System.out.println();
        System.out.println("computer");
        for(int a : computerNumber.computerNumbers) System.out.print(a+" ");
        System.out.println();
        System.out.println("user");
        for(int a : userNumber.userNumbers) System.out.print(a+" ");
    }

    public static void main(String[] args) {
        playBaseball();
    }
}

