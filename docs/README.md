미션 - 숫자 야구
===
---
### 기능 목록

1. **View**
    + 출력
      - 시작 메시지 출력
      - 숫자 입력 메시지 출력
      - 힌트 메시지 출력
      - 상황 별 종료 메시지 출력
    + BackEnd 통신
       - answer input 값 BackEnd로 전달
       - 종료 혹은 재시작 input 값 BackEnd로 전달 

2. **Service**
   + input 값 처리
     - 일치하는 수 처리 
     - 일치하는 수, 자리 처리 
   + UI 통신
     - 일치하는 수, 자리 바탕으로 힌트 UI에 전달
     - 정답일 경우 UI에 전달
   + 예외 처리
     - answer input 값 확인 (숫자가 아닌 경우, 세자릿수가 아닌 경우, 중복된 수가 있을 경우)
     - 종료 혹은 재시작 input 값 확인 (1 혹은 2가 아닌 경우)
     - 예외 처리 (IllegalArgumentException)
   

### 기능 구현

1. **ui**
   - InputView
       + getBaseballNumber
       + sendInput
   - HintView
       + printHint
   - ResultView
       + printResult
       + getRestartNumber

2. **controller**
    - Controller
        + setState
        + sendInputToService
        + sendOutputToUI
3. **service**
    - RandomNumberListGenerator
        + generateRandomNumberList
    - InputService
        + findMatchedNum
        + findMatchedNumAndPlace
        
        
4. **game**
    - baseballGame
        + playOneCycle