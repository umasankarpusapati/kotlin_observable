interface Service {
    fun backgroundTask(request: String): Observable<String>
}
