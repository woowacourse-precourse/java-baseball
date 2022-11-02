# 미션 - 숫자 야구

---

## 기능 Todo List (시작 전)

- 게임 머신 클래스
  - 게임 시작
    - 게임 진행
    - return : void
  - 랜덤 값 생성
    - 1부터 9까지 서로 다른 3자리의 수 생성
    - return : List<Integer>
  - 맞출 숫자 입력
    - 게임 시작 후 맞출 숫자 입력 받기
    - return : List<Integer>
  - 재시작 여부 입력
    - 게임 종료 후 재시작 여부 입력 받기
    - return : boolean
  - 맞출 숫자 입력시 잘못된 값 확인
    - 입력 값이 1부터 9가 아닌 경우
    - 입력 값이 3자리가 아닌 경우
    - parameter : List<Integer>
    - return : boolean
  - 재시작 여부 입력시 잘못된 값 확인
    - 입력 값이 1 또는 2가 아닌 경우
    - parameter : int
    - return : boolean
  - IllegalArgumentException 발생
    - 오류가 발생한 경우 예외 발생
    - extends : RuntimeException
    - parameter : boolean
    - return : void

- 게임 머신 클래스의 각 멤버 메소드마다 테스트 코드 작성

## 변경사항 (과제 진행 후)

- 삭제
  - 맞출 숫자 입력
  - 재시작 여부 입력
  - 맞출 숫자 입력시 잘못된 값 확인
  - 재시작 여부 입력시 잘못된 값 확인
  - illegalArgumentException 발생
- 추가
  - 맞출 숫자 입력과 잘못된 값 확인을 통해 illegalArgumentException 발생
  - 재시작 여부 입력과 잘못된 값 확인을 통해 illegalArgumentException 발생
  - 스트라이크와 볼 개수 세기
    - 컴퓨터와 게이머의 숫자를 비교해 스트라이크와 볼 개수 확인
    - return : List<Integer>
  - 게임 진행 여부 판단
    - 스트라이크와 볼의 개수를 토대로 더 진행할지 여부 판단
    - parameter : int, int
    - return : boolean