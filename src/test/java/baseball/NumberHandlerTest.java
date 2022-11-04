package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class NumberHandlerTest {

    @Test
    void 랜덤난수생성() {
        NumberHandler numberHandler = new NumberHandler();
        ArrayList<Integer> computerNumber = numberHandler.getComputerNumber();

        for (Integer number : computerNumber) {
            System.out.print(number);
        }
        System.out.println();
    }


}