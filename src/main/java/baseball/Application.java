package baseball;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        Controller controller = new Controller();
        controller.run();
//        try{
//            controller.run();
//        } catch (IllegalArgumentException e){
//            System.out.println("입력 값 오류입니다");
//        }
    }
}
