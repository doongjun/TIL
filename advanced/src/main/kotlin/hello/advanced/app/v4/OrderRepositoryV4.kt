package hello.advanced.app.v4

import hello.advanced.trace.logtrace.LogTrace
import hello.advanced.trace.template.AbstractTemplate
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryV4(
    private val trace: LogTrace
) {
    fun save(itemId: String) {
        val template = object : AbstractTemplate<String>(trace) {
            override fun call(): String {
                if (itemId == "ex") throw IllegalArgumentException("예외 발생!")
                sleep(1000)
                return "ok"
            }
        }
        template.execute("OrderRepository.request()")
    }

    private fun sleep(millis: Long) {
        Thread.sleep(millis)
    }
}