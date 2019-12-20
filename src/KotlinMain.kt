object KotlinMain {

    private val service = ServiceImpl()

    @JvmStatic
    fun main(args: Array<String>) {
        service.backgroundTask("Request")
            .subscribe(
                { printTh("emitted :: $it") },
                { printTh("error :: ${it.message}") },
                { printTh("completed") }
            )
        MainScheduler.instance().looper()
    }
}
