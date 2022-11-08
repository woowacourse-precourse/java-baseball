package baseball;


public class Application {

    public static void main(String[] args) {
        String computerRandomNumber = "";
        String userInputNumber ="";

       computerRandomNumber =  computerRandomNumber();
        gameStartMessage();
        userInputNumber = inputUserPickNumber();
        int strike = howManyStrike(userInputNumber,computerRandomNumber);
        int ball = howManyBall(userInputNumber,computerRandomNumber);
        int nothing = nothing(userInputNumber,computerRandomNumber);
        System.out.println("스트라이크: "+strike + "볼"+ ball);

    }

}



