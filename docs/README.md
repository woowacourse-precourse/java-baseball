## ⚙️ 기능 목록
### 🏁 시작 : **initGame()**

> 1. 시작 메세지 출력 : **printStartMessage()**
>   * 프로그램 시작 시에만 출력
   > 2. 초기화 : **initGame()**
   >    * 타겟 숫자 생성: **buildTarget()**
   >    * 유저 예측 값 초기화: **initUser()**
   >    * 볼카운트 초기화: **initBallCount()**


### ⚾️ 진행 : play()
> 1. 게임 생성: **swing()**
> 1. 사용자 예측값 생성 : **buildUser()**
>   * 입력한 수가 조건을 만족하는지 판별: **readUser()**
>   * 잘못된 값일 경우 **IllegalArgumentException** 발생
> 2. 판정 : **judge()**
>   * 스트라이크 판정 : **judgeStrike()**
>   * 볼 판정 : **judgeBall()**
> 3. 출력 : **showBallCount()**
>    * judge()에서 얻은 볼카운트를 출력
>    * 3스트라이크일 경우 '종료' 페이즈 시행
> 5. 반복 : **while()**
>    * 사용자로부터 종료 입력을 받기 전까지 **swing()** 반복

### 🧹 종료 : **endGame()**
> 1. 종료 메세지 출력 : **printEndMessage()**
> 2. 재시작 : **restart()**
>    * 재시작 여부를 입력 받음 : **confirmRestart()**
>    *  confirmRestart()이 1일 경우 '시작' 페이즈로, 2일 경우 종료
>    * 잘못된 값일 경우 IllegalArgumentException 발생
