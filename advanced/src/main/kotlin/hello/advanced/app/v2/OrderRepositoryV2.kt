package hello.advanced.app.v2

import hello.advanced.trace.TraceId
import hello.advanced.trace.TraceStatus
import hello.advanced.trace.hellotrace.HelloTraceV2
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryV2(
    private val trace: HelloTraceV2
) {
    fun save(traceId: TraceId, itemId: String) {
        var status: TraceStatus? = null
        try {
            status = trace.beginSync(traceId, "OrderRepository.request()")

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