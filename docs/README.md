## 설계 - 전체적인 구조와 클래스

### 구조

- main program
- Start game
  - 랜덤 넘버 생성
  - 유저 입력 받기
- Precede game
  - 스트라이크, 볼 판단
  - 케이스를 나누어 출력
- Quit game
  - 재시작 여부 확인



### 클래스 별 요구사항

- Game.java
  - 게임 제어 (시작, 종료, 재시작)
  - 스트라이크, 볼 관리
- Input.java
  - 유저 입력 받기
  - 잘못된 입력 시, throws exception: 3글자, 숫자가 아닐 시





## 기능 목록

- [ ] 게임 시작 문구
- [x] 랜덤 넘버 생성
- [x] 서로 다른 3자리 수 입력 받기
  - [x] 잘못된 입력 판단: `IllegalArgumentException` 발생 후 종료
- [x] 스트라이클, 볼 판단 로직
- [ ] 결과 출력
- [ ] 게임 종료 및 다시 시작







---

## 애로사항과 해결 방안

**Lambda** **사용**

- strike 판단 시에, computer와 guess를 각 인덱스 별로 비교해야 함.
- 직접 List의 stream을 통해서 인덱스를 비교하는 방법이 다소 까다로움.

>IntStream을 통해서 각 Index마다 filter를 함으로써 구현.
>
>결과적으로는 Lambda를 적극 활용하면서도, 깔끔한 코드가 되었다.
