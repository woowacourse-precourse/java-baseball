package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Input {

    public static String readString() {
        String inputString;
        inputString = Console.readLine();
        /*try {
            Constructor<Console> constructor = Console.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Console console = constructor.newInstance();

            Method readLine = Console.class.getDeclaredMethod("readLine");
            readLine.setAccessible(true);
            inputString = (String) readLine.invoke(console);

            Field scannerField = Console.class.getDeclaredField("scanner");
            scannerField.setAccessible(true);
            *//*Scanner scanner = (Scanner) scannerField.get(console);
            scanner.close();*//*
            scannerField.set(console, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
        return inputString;
    }

}
