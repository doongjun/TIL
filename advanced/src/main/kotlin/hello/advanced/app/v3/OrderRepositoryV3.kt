package hello.advanced.app.v3

import hello.advanced.trace.TraceStatus
import hello.advanced.trace.logtrace.LogTrace
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryV3(
    private val trace: LogTrace
) {
    fun save(itemId: String) {
        var status: TraceStatus? = null
        try {
            status = trace.begin("OrderRepository.request()")

            if (itemId == "ex") {
                throw IllegalArgumentException("예외 발생")
            }
            sleep(1000)

            trace.end(status)
        } catch (e: Exception) {
            status?.let { trace.exception(it, e) }
            throw e
        }
    }

    private fun sleep(millis: Long) {
        Thread.sleep(millis)
    }
}