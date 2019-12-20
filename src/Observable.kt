class Observable<T>(private val action: (Emitter<T>) -> Unit) {

    fun subscribe(onNext: (T) -> Unit, onError: (Throwable) -> Unit, onComplete: () -> Unit) {
        val emitter = object : Emitter<T> {
            override fun onNext(value: T) {
                MainScheduler.instance().schedule { onNext.invoke(value) }
            }

            override fun onError(throwable: Throwable) {
                MainScheduler.instance().schedule { onError.invoke(throwable) }
            }

            override fun onComplete() {
                MainScheduler.instance().schedule(onComplete)
            }
        }

        IOScheduler.instance().schedule {
            action.invoke(emitter)
        }
    }

}