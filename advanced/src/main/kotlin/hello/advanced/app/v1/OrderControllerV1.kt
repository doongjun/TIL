package hello.advanced.app.v1

import hello.advanced.trace.TraceStatus
import hello.advanced.trace.hellotrace.HelloTraceV1
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderControllerV1(
    private val trace: HelloTraceV1,
    private val orderServiceV1: OrderServiceV1
) {
    @GetMapping("/v1/request")
    fun request(itemId: String): String {
        var status: TraceStatus? = null
        try {
            status = trace.begin("OrderControllerV1.request()")
            orderServiceV1.orderItem(itemId)
            trace.end(status)
            return "ok"
        } catch (e: Exception) {
            status?.let { trace.exception(it, e) }
            throw e
        }
    }
}