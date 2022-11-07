---
docs: SystemException 기능 구현 목록
## 기능 구현

- isValidRestartInput
    - 게임을 재시작할거면 1, 완전 종료할거면 2. 둘중 하나를 선택해야 하므로 입력값에 1, 2만 오게 하였다
    - 이를 통해 적절한 입력값을 받는지 물어보고, 이를 통해 View에서 사용되게 해주었다.
- isValidInput
    - isValidNumber와 isNotContainsZero와 isNotDuplicate를 묶어, 다 해당되는지 물어봄
    - 이를 통해 적절한 입력값을 받는지 물어보고, 이를 통해 View에서 사용되게 해주었다.
- isValidNumber
    - 입력 받는 값이 123과 987 사이에 존재하는지 물어봄
    - 중복이 불가능한 세자리의 수 중 제일 min 값=123, max 값=987을 기준으로 잡았다
    - 굳이 세자리 수에 포함이 되는지 물어볼 필요를 줄였다
- isNotContainsZero
    - 입력 받는 값이 0이 들어가는지 물어봄
- isNotDuplicate
    - 중복되는 값이 존재하는지 물어봄