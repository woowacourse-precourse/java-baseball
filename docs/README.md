기능 목록

1. 랜덤 숫자 3개 뽑기 기능 

   - 1~9까지 랜덤 숫자
   - 숫자는 서로 다른 수 3개
   - camp.nextstep.edu.missionutils API사용

   

2. 사용자 입력을 받아 처리하는 기능

   - 사용자가 숫자를 제시하면 값을 3번 기능 호출
   - 3번기능이 넘겨준 결과값을 통해 결과 출력
   - 게임이 종료될 때까지 반복
   - 게임이 끝나면 4번 기능 호출
   - 사용자가 잘못된 값 입력시 IllegalArgumentException 호출 후 종료

   

3. 사용자가 입력한 값을 랜덤 숫작 3개와 비교하여 결과를 리턴하는 기능

   - 같은 수, 같은 자리 -> 1스트라이크
   - 같은 수 , 다른 자리 -> 1볼
   - 다른 수 3가지         -> 낫싱

   

4. 게임이 종료되었을 때 재시작 or 종료  입력 처리 기능

   - 1 입력시 재시작
   - 2 입력시 종료

------

프로그래밍 요구사항 메모..

코드 컨벤션 가이드

- 들여쓰기 4칸
- 열 제한 120
- 들여쓰기 지속 최소 +8칸
- 수직 빈 줄 클래스 첫 번째 멤버나 초기화 또는 마지막 멤버 또는 초기화 뒤 빈줄 강제x

추가 요구사항

- 들여쓰기 depth 2까지 허용
- whlie문 안에 if문이 있으면 depth는 2
- 3항 연산자 사용금지
- 함수가 한 가지 일만 하도록 최대한 작게
- JUnit 5와 AssertJ를 활용(test/java/study 참고)

라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API사용
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`
- 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`

```java
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```