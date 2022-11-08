package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {

        } catch (IllegalArgumentException ie) {
            throw ie;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}