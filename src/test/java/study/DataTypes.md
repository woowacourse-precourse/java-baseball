- 객체지향프로그래밍
    - 객체(부품)를 만들고 이 객체를 서로 연결해서 더 큰 프로그램을 완성하는 기법

1. 타입 변환

   숫자타입: byte < short < int < long < float < double

    - 자동 변환: int intValue = byteValue;
    - 강제 변환: char charValue = (char) intValue;

      cf. 정수타입 → byte, short, char, int, long

    - 예시
        - Sting → int

            ```java
            String str = "300000";
            int value = Integer.parseInt(str);
            ```

        - int → String

            ```java
            String str = String.valueOf(intValue);
            ```

2. String 값 비교

    ```java
    boolean res = inputData.equals("비교문자열");
    ```

3. Random number 받아오기

    ```java
    int num = (int) (Math.random() * n) + start;
    
    // 주사위 번호 하나 뽑기
    int num = (int) (Math.random() * 6) + 1;
    // 로또 번호 하나 뽑기
    int num = (int) (Math.random() * 45) + 1;
    ```

4. 반복문
    1. for

        ```java
        // for(초기화식; 조건식; 증감식){ } 
        
        // 두개 이상의 초기화식 가능
        for (int i=0, j=100; i<=50 && j>=50; i++, j--){ } 
        ```

    2. break, continue

       공통점: 반복문을 break하며 if문 안에 넣어 사용하는 것이 일반적

       break는 당장 반복문을 탈출함

       continue는 현재 진행중인 루프의 아래를 실행하지 않지만 다시 증감식으로 올라가서 다음루프를 실행함

5. 기본타입 vs 참조타입
    1. 기본타입(정수, 실수, 논리)은 실제 값을 변수 안에 저장
    2. 참조타입(배열, 열거, 클래스, 인터페이스)은 메모리의 번지를 변수 안에 저장하며 번지를 통해 객체를 참조함
    3. String 또한 참조 타입이기 때문에

       String name = “조은기” 와 String name = new String(”조은기”) 는 다르다

       같은 객체이건 아니건 관계 없이 비교하기 위해서는 equals( ) 메소드를 사용해야 함

6. 배열
    1. 생성

    ```java
    // 방법 1
    String[] names = {"조은기", "조현기", "조초키", "조배키"};
    names[3] = "삐옥이" // 수정 가능
    // 주의사항: 중괄호를 사용한 배열 생성은 선언 당시에만 가능
    
    // 나중에 중괄호로 값을 지정하는 압법
    String names = null;
    // names = {"조은기", "조현기", "조초키", "조배키"}; => 컴파일 에러
    names = new String[] {"조은기", "조현기", "조초키", "조배키"};
    
    // 방법 2
    int[] intArray = new int[5]; // int는 모두 0, String은 모두 null로 초기화
    ```

   b. 길이 ⇒ 배열이름.length; (읽기 전용, 수정 불가)