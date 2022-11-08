# 사용자 관점 작동 흐름

1. 프로그램 실행
2. 3자리 숫자 입력
    1. 3 단계로 이동 (오답인 경우)
    2. 4 단계로 이동 (정답인 경우)
    3. 6 단계로 이동 (잘못된 형식의 값을 입력한 경우)
3. 결과값 확인(EX: "n 스트라이크, m 볼")
    - 2 단계로 이동
4. 결과값 확인(EX: "3 스트라이크")
5. 게임 종료
    1. 2 단계로 이동 (1 입력)
    2. 6 단계로 이동 (2 입력)
6. 프로그램 종료

# 프로그램 관점 작동 흐름

![state-diagram](https://raw.githubusercontent.com/wonju-dev/java-baseball/wonju-dev/docs/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202022-11-03%20%EC%98%A4%ED%9B%84%202.05.35.png)
*프로그램 진행 과정을 6개의 state로 분석함*

## 1. Initial state

- 정상적인 게임 실행을 위한 초기화 작업을 수행

## 2. 숫자 입력 state

- Console API를 사용해, 사용자로부터 입력값을 받음
    - 잘못된 형식의 값이 입력된 경우, IllegalArgumentException을 반환 & Final state로 전이
    - 올바른 형식의 값이 입력된 경우, 입력값 분석 state로 전이

## 3. 입력값 분석 state

- 사용자가 입력한 값을 게임 규칙에 따라 분석한 뒤, 결과값을 도출

## 4. 결과 출력 state

- 결과값을 화면에 출력
- 결과값에 따라 각각 다른 state로 전이
    - 정답(3 strike): 행동 입력 state로 전이
    - 오답(not 3 strike): 숫자 입력 state로 전이

## 5. 행동 입력 state

- 게임이 종료된 경우, 사용자로부터 값을 입력받아 각각 다른 state로 전이
    - 1: Initial State로 전이
    - 2: Final State로 전이

## 6. Final state

- 프로그램 종료

# 구현할 기능 목록 & 고려 사항

<details>
<summary>랜덤 넘버 생성</summary>

- [x] Randoms API 사용
- [x] 각 자리의 숫자가 서로 겹치지 않음

</details>

<details>
<summary>사용자 입출력 & 검증</summary>

# 입력

- [x] Interactive 인터페이스 선언
- [x] Console API 사용

# 출력

## 프로그램 동작 결과 출력

- [x] 프로그램 시작 메시지 출력
- [x] 프로그램 종료 메시지 출력

## 게임 동작 결과 출력

- [x] 게임 승리 (3 strike) 메시지 출력
- [x] Ball 개수 출력
- [x] Strike 개수 출력
- [x] Nothing 출력

# 입력값 검증

- [x] Validator 구현
- [x] Condition 인터페이스 선언
  ## 숫자 입력 검증
- [x] 길이가 3 이하인가
- [x] 숫자로만 이루어져 있는가
- [x] 중복된 숫자가 사용되었는가
  ## 사용자 행동 입력 검증
- [x] 1 또는 2가 입력되었는가

</details>

<details>
<summary>정답 비교</summary>

- [x] Rule 인터페이스 선언
- [x] RuleChecker 구현

## 게임 규칙

- [x] strike 개수 파악 규칙
- [x] ball 개수 파악 규칙
- [x] nothing 파악 규칙

</details>
