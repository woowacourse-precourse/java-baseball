# 기능목록

----

## 목차
- [프로그램 시작](#프로그램-시작)
- [문제 생성](#문제-생성)
- [문제 해결](#문제-해결)
  - [산정방식](#산정방식)
  - [출력방식](#출력방식)
- [해결 이후](#해결-이후)
- [플로우차트](#플로우차트)
- [구현시 유의사항](#구현시-유의사항)
  - [라이브러리](#라이브러리)

----

## 프로그램 시작

- 최초 시작시, 프로그램 시작문구가 출력된다.
```
숫자 야구 게임을 시작합니다.
```

## 문제 생성
 
- 1부터 9까지의 수중 중복되지 않는 3가지의 수로 구성된 3자리의 수가 생성된다.

## 문제 해결

- `숫자를 입력해주세요 : ` 가 콘솔에 출력된다.
- 사용자는 서로 다른 3자리의 수를 입력한다.
    - 사용자의 입력이 이와 다를경우 `IllegalArgumentException` 이 발생되고 프로그램이 종료된다.
    - 정상적인 입력의 경우는 문제와 입력값을 비교하여 아래의 산정방식에 따라 나온 결과가 출력방식에 따라 콘솔에 출력된다. 
        - 산정방식
          - 숫자와 그 위치가 문제와 일치하는 경우: **스트라이크**
          - 숫자는 일치하나, 그 위치가 문제와 다른 경우 : **볼**
        - 출력방식  
          - 스트라이크와 볼의 합산으로 결과를 출력한다.`ex) 1볼 1스트라이크,1볼,1스트라이크 ...`
          - 스트라이크와 볼, 두 경우가 모두 나오지 않는다면  `낫싱`이 출력된다.
- 문제와 입력값이 완전 일치하는 경우, 즉 3 스트라이크가 나올때 까지 **문제 해결**을 반복하여 진행된다.

## 해결 이후

- 게임종료 메시지가 콘솔에 출력된다.
```
3개의 숫자를 모두 맞히셨습니다! 게임 종료
```
- 게임 재시작 여부 메시지가 콘솔에 출력된다.
```
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
```
- 사용자에 입력에 따라 이후 과정을 진행된다.
    - "1"을 입력: **문제 생성** 부터 재시작된다.
    - "2"를 입력: 프로그램이 종료된다.
    - 이외 입력: `IllegalArgumentException`이 발생하고 프로그램이 종료된다.


-----
# 플로우차트

---

[![](https://mermaid.ink/img/pako:eNp9kktLw0AUhf_KZVYtWETdZaH04aMiuNBFoekitGMtJmmpCShNwdp20wo-sAslCfEFCl3EB5qFvyi5_Q9OM7FaELPKzPnuyZmTaZBitUSJQMp1qbYL2xlRBfYkY6PLTnBj-h9eYD8C9k20z-OQSCxCKhYMPXRMwLaFnec4H0iFWjqGx0O8fkL7DNDuBs5DJKdDOdPgm-C7F2i9AToDbLfQaaHl-e7REmzO5pp8IBMOGJsGrDBPl5GB-4R9Kz4l5wxYzmdlmZYlOVkv6wpVteWDIq1plapa4OhKiK7m_RfXf_2Eb7NTwHeTZYmo1ZBaa3CKhYEFwN79qOcF1ifLOmoNIUoZJVwbT7CA2Ukft93g7iT-W80Zab7Mjpfr7PhDXiWMBo7_0v4-N6-FtQJzwg8zL3DL6IProeUEFeaM1N_CvLGXn_59oU1hirbe8MozNv5vj8wQhdYVqVJiN6Qx3hGJtksVKhKBvZbojqTLmkhEtclQSdeqW4dqkQhaXaczRK-VJI1mKhK7WwoRdiR5nza_AEGCFdc?type=png)](https://mermaid-js.github.io/mermaid-live-editor/edit#pako:eNp9kktLw0AUhf_KZVYtWETdZaH04aMiuNBFoekitGMtJmmpCShNwdp20wo-sAslCfEFCl3EB5qFvyi5_Q9OM7FaELPKzPnuyZmTaZBitUSJQMp1qbYL2xlRBfYkY6PLTnBj-h9eYD8C9k20z-OQSCxCKhYMPXRMwLaFnec4H0iFWjqGx0O8fkL7DNDuBs5DJKdDOdPgm-C7F2i9AToDbLfQaaHl-e7REmzO5pp8IBMOGJsGrDBPl5GB-4R9Kz4l5wxYzmdlmZYlOVkv6wpVteWDIq1plapa4OhKiK7m_RfXf_2Eb7NTwHeTZYmo1ZBaa3CKhYEFwN79qOcF1ifLOmoNIUoZJVwbT7CA2Ukft93g7iT-W80Zab7Mjpfr7PhDXiWMBo7_0v4-N6-FtQJzwg8zL3DL6IProeUEFeaM1N_CvLGXn_59oU1hirbe8MozNv5vj8wQhdYVqVJiN6Qx3hGJtksVKhKBvZbojqTLmkhEtclQSdeqW4dqkQhaXaczRK-VJI1mKhK7WwoRdiR5nza_AEGCFdc)

---
# 구현시 유의사항

- JDK 11 버전에서 실행 가능해야 한다. **JDK 11에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

## 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

### 사용 예시

```java
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```