package hello.advanced.strategy.code.strategy

import org.slf4j.LoggerFactory

class StrategyLogic1: Strategy {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun call() {
        log.info("비즈니스 로직1 실행")
    }
}