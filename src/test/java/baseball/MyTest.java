package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyTest {
    @Test
    void isCorrectedInputTest() {
        String test1 = "1539"; //rise IllegalArgumentException
        String test2 = "a13b"; //rise IllegalArgumentException
        String test3 = "132"; //return true
        String test4 = "121"; //rise IllegalArgumentException
        String test5 = "032"; //rise IllegalArgumentException
        String test6 = "abd"; //rise IllegalArgumentException

        try {Application.isCorrectedInput(test1); fail();}
        catch (IllegalArgumentException ignored){}

        try {Application.isCorrectedInput(test2); fail();}
        catch (IllegalArgumentException ignored){}

        assertTrue(Application.isCorrectedInput(test3));

        try {Application.isCorrectedInput(test4); fail();}
        catch (IllegalArgumentException ignored){}

        try {Application.isCorrectedInput(test5); fail();}
        catch (IllegalArgumentException ignored){}

        try {Application.isCorrectedInput(test6); fail();}
        catch (IllegalArgumentException ignored){}
    }
}