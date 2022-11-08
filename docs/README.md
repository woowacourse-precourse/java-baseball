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
    + input 받기
        - 숫자 야구 input 받기
        - 종료 input 받기
    + 예외 처리 (Input 검증)
        - 야구 Input 검증 (중복 숫자, 숫자가 아닌 경우, 사이즈가 안 맞는 경우)
        - 종료 혹은 재시작 input 검증 (1 혹은 2가 아닌 경우)
2. **Controller**
    + Service 통신
        - answer input 값 Service 전달
        - 종료 혹은 재시작 input 값 Service 전달
    + UI 통신
        - 일치하는 수, 자리 바탕으로 힌트 UI에 전달
        - 정답일 경우 UI에 전달
    + 전체 게임 동작 관리
        - 한 게임 cycle 관리
        - 전체 게임 관리
3. **Service**
    + input 값 가공 및 처리
        - 일치하는 수 처리 
        - 일치하는 수, 자리 처리
        - 힌트 생성
        - 랜덤한 답안 생성
### 기능 구현
1. **ui**
    - InputView
        + getBaseballInput
        + checkInputValidation
        + checkInputSize
        + checkNumericvalue
        + checkDuplicateValue
        + getInput
    - HintView
        + printHint
        + setHint
        + checkWinningCondition
    - ResultView
        + printResult
        + getRestartNumber
        + setResult
        + getResult

2. **controller**
    - Controller
        + playGame
        + playGameOneCycle
        + setState
        + sendHintView
        + sendInputToService
        + getResult
        + isRestart
        + restartGame
3. **service**
    - RandomNumberListGenerator
        + generateRandomNumberList
    - Service
        + generateHint
        + findMatchedNum
        + findMatchedNumAndPlace
        + isIdentical
        + resetRandomAnswer
        + getAnswer
    
4. **model**
    - Input
    - Hint
    - State
    - Result