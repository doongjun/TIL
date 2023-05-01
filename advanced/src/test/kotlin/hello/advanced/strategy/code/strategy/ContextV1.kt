package hello.advanced.strategy.code.strategy

import org.slf4j.LoggerFactory

class ContextV1(
    private val strategy: Strategy
) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun execute() {
        val startTime = System.currentTimeMillis()

        // 비즈니스 로직 실행
        strategy.call() // 위임
        // 비즈니스 로직 종료

        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info("resultTime={}", resultTime)
    }

}