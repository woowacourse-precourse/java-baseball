# JUnit과 test code study

### assertRandomNumberInRangeTest
	@Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

+ run( ): 사용자 입력 값
+ output(): 콘솔에 출력하는 값
+ 1, 3, 5, 5, 8, 9: 컴퓨터가 생성한 숫자 (랜덤)

---

       public static void assertRandomNumberInRangeTest(
        final Executable executable,
        final Integer value,
        final Integer... values
    ) {
        assertRandomTest(
            () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
            executable,
            value,
            values
        );
    }
+ parameters: executable, integer values(정해지지 않은 개수를 받아 배열로 변환)
+ assertRandomTest 실행

---
    private static <T> void assertRandomTest(
    final Verification verification,
    final Executable executable,
    final T value,
    final T... values
    ) {
    assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
    try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
    mock.when(verification).thenReturn(value, Arrays.stream(values).toArray());
    executable.execute();
    }
    });
    }

+ assertTimeoutPreemptively: Assert that execution of the supplied executable completes before the given timeout is exceeded.
+ 설정한 시간(RANDOM_TEST_TIMEOUT) 이내에 완료하지 않으면 타이암웃 에러를 발생시킴
+ RANDOM_TEST_TIMEOUT: 전역변수로 Duration.ofSeconds(10L)임 
  + Duration.ofSeconds( ): 시간을 초단위로 설정하는 메소드

---