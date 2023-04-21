package hello.advanced.app.v4

import hello.advanced.trace.logtrace.LogTrace
import hello.advanced.trace.template.AbstractTemplate
import org.springframework.stereotype.Service

@Service
class OrderServiceV4(
    private val trace: LogTrace,
    private val orderRepository: OrderRepositoryV4
) {
    fun orderItem(itemId: String) {
        val template = object : AbstractTemplate<String>(trace) {
            override fun call(): String {
                orderRepository.save(itemId)
                return "ok"
            }
        }
        template.execute("OrderService.request()")
    }
}