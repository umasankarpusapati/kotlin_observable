class ServiceImpl : Service {

    override fun backgroundTask(request: String): Observable<String> {
        return Observable { emitter ->
            if (request == "Invalid") {
                emitter.onError(Throwable("Invalid request"))
            } else {
                (1..5).forEach { emitter.onNext("Value $it") }
                emitter.onComplete()
            }
        }
    }

}