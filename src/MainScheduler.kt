import java.util.concurrent.ConcurrentLinkedQueue

class MainScheduler private constructor() {

    companion object {
        private val queue = ConcurrentLinkedQueue<() -> Unit>()
        private val instance = MainScheduler()

        fun instance(): MainScheduler {
            return instance
        }

    }

    fun looper() {
        while (true) {
            queue.poll()?.invoke()
        }
    }

    fun schedule(action: () -> Unit) {
        queue.add(action)
    }
}