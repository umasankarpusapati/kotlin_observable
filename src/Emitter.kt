interface Emitter<T> {
    fun onNext(value: T)
    fun onError(throwable: Throwable)
    fun onComplete()
}