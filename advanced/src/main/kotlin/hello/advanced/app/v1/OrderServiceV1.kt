package hello.advanced.app.v1

import hello.advanced.trace.TraceStatus
import hello.advanced.trace.hellotrace.HelloTraceV1
import org.springframework.stereotype.Service

@Service
class OrderServiceV1(
    private val trace: HelloTraceV1,
    private val orderRepository: OrderRepositoryV1
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