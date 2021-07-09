## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

### TDD 원칙
- 실패하는 단위 테스트를 먼저 작성하고 프로덕션 코드를 작성한다.
- 컴파일은 실패하지 않으면서 실행이 실패하는 정도로만 단위테스트를 작성한다.
- 현재 실패하는 테스트를 통과할 정도로만 실제 코드를 작성한다.

### TDD 사이클
- 실패하는 테스트를 구현
- 테스트가 성공하도록 프로덕션 코드를 구현
- 프로덕션 코드와 테스트 코드를 리팩토링

### 피드백 강의를 보면서 느낀 점
- 멤버 변수를 호출해서 사용하지말고 객체에 메시지를 보낼 것
    - ex) ball.getStrike() === 3 대신 ball.isGameEnd()
- enum을 활용
- 각 단위 작업이 끝날 때마다 commit
- Java의 Stream 사용 

### TODO
* 1~9 숫자 중 랜덤으로 3개의 숫자를 생성
* 사용자로부터 입력받은 3개의 숫자 예외 처리
    * 1~9의 숫자인가?
    * 중복이 있는가?
    * 3자리인가?
    * 숫자인가?
* 위치와 숫자값이 같은 경우 - 스트라이크
* 위치 다르고 숫자값이 같은 경우 - 볼
* 숫자값이 다른 겨우 - 낫싱
* 사용자가 입력한 값에 대한 실행결과를 출

#### 숫자 검증
- com, user
- 123 , 456 -> nothing 
- 123 , 415 -> 1ball
- 123 , 145 -> 1strike

#### 숫자값, 위치값 검증
- com, user
- 1 1 , 1 1 -> strike
- 1 4 , 2 4 -> ball
- 1 4 , 2 5 -> nothing

### Git 커밋 메시지 구분
- `feat`: feature
- `fix`: bug fix
- `docs`: documentation
- `style`: formatting, missing semi colons, …
- `refactor`: refactoring
- `test`: when adding missing tests
- `chore`: maintain