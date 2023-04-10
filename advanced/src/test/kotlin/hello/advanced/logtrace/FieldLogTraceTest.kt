package hello.advanced.logtrace

import hello.advanced.trace.logtrace.FieldLogTrace
import org.junit.jupiter.api.Test

class FieldLogTraceTest {
    val trace = FieldLogTrace()

    @Test
    fun begin_end_level2() {
        val status1 = trace.begin("hello1")
        val status2 = trace.begin("hello2")
        trace.end(status2)
        trace.end(status1)
    }

    @Test
    fun begin_exception_level2() {
        val status1 = trace.begin("hello1")
        val status2 = trace.begin("hello2")
        trace.exception(status2, IllegalStateException())
        trace.exception(status1, IllegalStateException())
    }
}