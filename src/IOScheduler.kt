import java.util.concurrent.ConcurrentLinkedQueue

class IOScheduler private constructor() {

    init {
        Thread({ looper() }, "background").start()
    }

    companion object {
        private val instance = IOScheduler()
        private val queue = ConcurrentLinkedQueue<() -> Unit>()

        fun instance(): IOScheduler {
            return instance
        }
    }

    private fun looper() {
        printTh("Thread is created")
        while (true) {
            queue.poll()?.invoke()
        }
    }

    fun schedule(action: () -> Unit) {
        queue.add(action)
    }
}