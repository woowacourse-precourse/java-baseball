package baseball;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user = new User();

    @Test
    void 유저가_입력한_문자열_범위를_확인하는_첫번째_케이스() {
        boolean exceptionTest = false;
        try {
            String test = "1234";
            user.checkValidate(test);
        } catch (IllegalArgumentException e) {
            exceptionTest = true;
        }
        assertTrue(exceptionTest);
    }

    @Test
    void 유저가_입력한_문자열_범위를_확인하는_두번째_케이스() {
        boolean exceptionTest = false;
        try {
            String test = "23";
            user.checkValidate(test);
        } catch (IllegalArgumentException e) {
            exceptionTest = true;
        }
        assertTrue(exceptionTest);
    }

    @Test
    void 유저가_입력한_문자열_범위를_확인하는_세번째_케이스() {
        boolean exceptionTest = false;
        try {
            String test = "234";
            user.checkValidate(test);
        } catch (IllegalArgumentException e) {
            exceptionTest = true;
        }
        assertFalse(exceptionTest);
    }

    @Test
    void 유저가_입력한_문자열에_0이_포함되었는지_확인_첫번째_케이스() {
        boolean exceptionTest = false;
        try {
            String test = "130";
            user.checkValidate(test);
        } catch (IllegalArgumentException e) {
            exceptionTest = true;
        }
        assertTrue(exceptionTest);
    }

    @Test
    void 유저가_입력한_문자열에_0이_포함되었는지_확인_두번째_케이스() {
        boolean exceptionTest = false;
        try {
            String test = "891";
            user.checkValidate(test);
        } catch (IllegalArgumentException e) {
            exceptionTest = true;
        }
        assertFalse(exceptionTest);
    }

    @Test
    void 유저가_입력한_문자열_중에_중복된_수를_확인하는_첫번째_케이스() {
        boolean exceptionTest = false;
        try {
            String test = "911";
            user.checkValidate(test);
        } catch (IllegalArgumentException e) {
            exceptionTest = true;
        }
        assertTrue(exceptionTest);
    }

    void 유저가_입력한_문자열_중에_중복된_수를_확인하는_두번째_케이스() {
        boolean exceptionTest = false;
        try {
            String test = "912";
            user.checkValidate(test);
        } catch (IllegalArgumentException e) {
            exceptionTest = true;
        }
        assertFalse(exceptionTest);
    }



}

