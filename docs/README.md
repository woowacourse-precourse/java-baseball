### 게임 기능

- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - [X] 컴퓨터 수는 1에서 9까지 서로 다른 임의의 수 3개를 선택하도록 하는 기능
        - [X] 게임을 다시 시작하는 경우, 다시 숫자를 새로 세팅하는 기능


- [X] 게임 시작시, `숫자 야구 게임을 시작합니다.` 게임 시작 문구 출력 기능


- [X] 게임 플레이시, `숫자를 입력해주세요 :` 숫자 입력 문구 출력 기능
    - 사용자 입력 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()` 을 활용한다.
    - [X] 서로 다른 3자리의 수만 입력 가능하도록 하는 기능
        - [X] 사용자가 잘못된 값을 입력하는 경우, `IllegalArgumentException` 을 발생시킨 후, 애플리케이션을 종료하는 기능


- [X] 게임 종료시, 재시작 숫자 1, 완전 종료 2 만 입력이 가능하도록 하는 기능
    - [X] 사용자가 잘못된 값을 입력하는 경우, `IllegalArgumentException` 을 발생시킨 후, 애플리케이션을 종료하는 기능


- 컴퓨터의 수와 사용자의 입력한 수를 비교
    - [X] 같은 수가 있는 지 확인하는 기능
        - 같은 수가 하나도 없을 때,
            - [X] `낫싱`을 출력하는 기능
        - [X] 같은 수가 같은 자리에 있는지 확인하는 기능
            - 서로 다른 자리에 존재할 때,
                - [X] 볼 개수에 더하는 기능
            - 서로 같은 자리에 존재할 때,
                - [X] 스트라이크 개수에 더하는 기능
            - [X] 볼 및 스트라이크 개수를 포함한 결과 `1볼 1스트라이크` 출력 기능
                - [X] 정답인 경우(3스트라이크인 경우), `3스트라이크
                  3개의 숫자를 모두 맞히셨습니다! 게임 종료`

                  `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.` 출력 기능
                  - [X] 사용자가 1 또는 2를 입력하는 경우, 게임 상태 결정 기능
        - [X] 같은 수의 개수, 볼 개수, 스트라이크 개수 초기화 기능


- [X] 게임 상태를 저장하는 기능
  - [X] 정답을 맞춘 경우, 게임의 상태를 게임 종료로 표현하는 기능

### 테스트

- [X] 위에서 정리한 기능 목록이 정상 동작함을 확인할 수 있도록 하는 기능

### 게임 실행 화면
#### 최종 게임 플레이 화면
<img src="https://user-images.githubusercontent.com/55132964/200545258-a46b3397-3ec5-4da8-8375-c228c909da51.png" width="50%" height="50%"/>
<img src="https://user-images.githubusercontent.com/55132964/200546400-a5ecf47d-f8bc-465a-891c-4d661ae8b2aa.png" width="40%" height="40%"/>

#### 예외 처리 화면
- 사용자가 공백 입력한 경우

<img src="https://user-images.githubusercontent.com/55132964/200548422-7b52ca5a-ca2f-47ef-8189-ce21b652a80f.png" width="50%" height="50%"/>

- 사용자가 입력값에 숫자가 아닌 문자를 포함하여 입력한 경우

<img src="https://user-images.githubusercontent.com/55132964/200548482-e0b1b452-3b69-47a6-b007-e43a3a7f3ce0.png" width="50%" height="50%"/>

- 사용자의 입력값이 세 자릿수가 아닌 경우

<img src="https://user-images.githubusercontent.com/55132964/200548544-45fe6d6b-384f-41c1-a7af-3a1a6e52d682.png" width="50%" height="50%"/>

- 사용자의 입력값에 중복되는 수가 있는 경우

<img src="https://user-images.githubusercontent.com/55132964/200548590-3ce73697-ede9-4795-90f7-53d2d31d571a.png" width="50%" height="50%"/>

- 정답을 맞춘 후, 새게임을 할지 결정할때 입력하는 값이 1과 2가 아닌 경우

<img src="https://user-images.githubusercontent.com/55132964/200548640-77a5ade8-f609-4b1f-adde-03c06eed4f4c.png" width="50%" height="50%"/>

#### 테스팅 화면
<img src="https://user-images.githubusercontent.com/55132964/200548856-6f3543c4-868f-4838-9983-a8f0f7d9dcbb.png" width="50%" height="50%"/>