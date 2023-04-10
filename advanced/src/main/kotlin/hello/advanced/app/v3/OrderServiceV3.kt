package hello.advanced.app.v3

import hello.advanced.trace.TraceStatus
import hello.advanced.trace.logtrace.LogTrace
import org.springframework.stereotype.Service

@Service
class OrderServiceV3(
    private val trace: LogTrace,
    private val orderRepository: OrderRepositoryV3
) {
    fun orderItem(itemId: String) {
        var status: TraceStatus? = null
        try {
            status = trace.begin("OrderService.request()")
            orderRepository.save(itemId)
            trace.end(status)
        } catch (e: Exception) {
            status?.let { trace.exception(it, e) }
            throw e
        }
    }
}