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

# 구현할 기능 목록

- [ ] Randoms API를 사용한 '랜덤 넘버 생성' 기능
- [ ] Console API를 사용한 '사용자 입력' 기능
- [ ] 사용자 입력값 유효성 검증 기능
- [ ] 입력값과 정답을 비교하여 결과값을 계산하는 기능
    - [ ] strike 개수 파악 기능
    - [ ] ball 개수 파악 기능
    - [ ] nothing 파악 기능
- [ ] 결과값을 출력하는 기능
- [ ] 사용자 입력값에 따라 게임 시작, 종료를 수행하는 기능
