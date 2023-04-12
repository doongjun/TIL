package hello.advanced.threadlocal.code

import org.slf4j.LoggerFactory

class ThreadLocalService {
    private val log = LoggerFactory.getLogger(javaClass)

    private var nameStore: ThreadLocal<String> = ThreadLocal()

    fun logic(name: String): String? {
        log.info("저장 name={} -> nameStore={}", name, nameStore.get())
        nameStore.set(name)
        sleep(1000)
        log.info("조회 nameStore={}", nameStore.get())
        return nameStore.get()
    }

    private fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}