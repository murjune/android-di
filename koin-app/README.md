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
- [ ] ProductRepository 는 ViewModel LifeCycle 동안 유지되도록 구현한다.
- [ ] DateFormatter 는 Activity LifeCycle 동안 유지되도록 구현한다.
- [ ] DateFormatter 는 Configuration Changes 에도 살아남을 수 있도록 구현한다.
- [ ] 각 Repository 는 각자의 Scope 에 맞게 의존성을 주입받도록 구현한다.