package baseball;

public class Application {

    public static void main(String[] args) {

        try {
            BaseballManagement baseballManagement = new BaseballManagement();
            baseballManagement.proceedBaseball();
        } catch (IllegalArgumentException exceptionMessage) {
            System.out.println(exceptionMessage.getMessage());
        } catch (Exception exceptionMessage) {
            System.out.println("예기치 못한 에러가 발생하였습니다.");
        }
    }

}
