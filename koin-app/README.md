# Koin - APP

- [Koin](https://insert-koin.io/) 을 활용하여 DI 를 적용한 샘플 앱입니다.
- [Koin Tutorial](https://insert-koin.io/docs/quickstart/android) 을 참고하여 구현하였습니다.

# 기능 요구 사항

## Step 1
- [x] CartRepository 는 앱 전체 LifeCycle 동안 유지되도록 구현한다.
- [x] ProductRepository 는 앱 전체 LifeCycle 동안 유지되도록 구현한다.
- [x] DateFormatter 는 앱 전체 LifeCycle 동안 유지되도록 구현한다.

---

## Step 2
- [x] 액티비티 컨택스트를 활용해서 DateFormatter 를 생성하도록 구현한다. (Application Context 사용이 더 바람직하나 연습을 위해~)
- [x] DateFormatter 는 Activity LifeCycle 동안 유지되도록 구현한다.
- [x] DateFormatter 는 Configuration Changes 에도 살아남을 수 있도록 구현한다.
- [x] CartRepository 는 ViewModel LifeCycle 동안 유지되도록 구현한다.


# 연습 후기
장점)
- 빌드시간에 영향을 안준다. (Hilt 는 빌드 타임에 코드가 생성돼서 빌드시간이 늘어나서 짜증나는데 이건 진짜 좋은듯)
- 에러 발생시 Debugger 가 잘 동작해서 에러 로깅이 쉬움 (Hilt 는 진짜 알아보기 힘들다)
- 공식 문서가 진짜 가독성 있게 잘 정리되어 있어 쉽게 따라할 수 있었다.
- Only Kotlin 인 점이 진짜 장점인듯
- Test 도 진짜 쉬움
- Hilt 처럼 KSP 를 활용 해서 빌드 타임에 코드를 만드는 방식도 있었음 

단점)
- 이게 가장 큰 단점 - 런타임에 DI가 동작하기 때문에 실수하면 앱이 죽는다 -> Test 코드가 진짜 필수 일듯
- 좀 심화된 내용은 한국 Reference 가 거의 없었다
- Scope Component 가 진짜 짜증난다 🔥
  좀 더 딥하게 얘기하자면, ViewModel 의 생명주기를 따르는 레포지토리를 만들고, Activity 에서 by ViewModel() 에 넘겨주고 싶었는데 불가능함
  ViewModel 내부에 서비스 로케이터 패턴으로 레포지토리를 가져오는 방식으로 해결해야함 😨
  Hilt 는 Android Scope 를 좀 더 친절하게 지원해주는듯~


후기) Hilt 가 맞는것 같다. Hilt 를 Koin 처럼 아직 파진 않았지만~