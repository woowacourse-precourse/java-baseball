package baseball;

import java.util.Scanner;

public class View {
    private final Scanner scanner;

    public View(Scanner scanner) {
        this.scanner = scanner;
    }

    public String userRequestNumber(){
        System.out.println("숫자를 입력해주세요 : ");
        String input = scanner.nextLine();

    }

}
