package baseball;

public class Application {
    public static void main(String[] args) {
        sendMassage(GameMassage.START_MASSAGE);
    }

    private static void sendMassage(GameMassage massage){
        System.out.print(massage.getMassage());
    }
}
