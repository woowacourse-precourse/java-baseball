package baseball;

import baseball.service.ExecuteService;

public class Application {
    public static void main(String[] args) {
        ExecuteService executeService = new ExecuteService();
        executeService.execute();
    }
}
