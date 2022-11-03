## Console API 학습 기록

### import
```java
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Scanner;
```
<br>

### 클래스 상수
```java
private static Scanner scanner;
```
```java
public static String readLine() {
    return getInstance().nextLine();
}

// readLine 함수에서 반환하는 getInstance().nextLine()
private static Scanner getInstance() {
    if (Objects.isNull(scanner) || isClosed()) {
    scanner = new Scanner(System.in);
    }
    return scanner;
}
```
- Scanner가 null이거나 닫혀있다면 새로운 Scanner 객체를 생성하여 반환

<br>

### 학습 내용

- nextLine()은 '\n'을 포함하는 한 라인을 읽고 '\n'을 버린 나머지만 리턴
- 즉, 엔터를 치기 전까지 입력한 모든 문자가 입력