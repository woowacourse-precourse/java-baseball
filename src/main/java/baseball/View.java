package baseball;

public class View {
    public static void printMessage(Message message) {
        print(message.getMessage());
    }

    public static void print(String hinString) {
        System.out.print(hinString);
    }
}
