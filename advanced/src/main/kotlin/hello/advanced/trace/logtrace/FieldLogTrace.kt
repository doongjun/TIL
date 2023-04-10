package hello.advanced.trace.logtrace

import hello.advanced.trace.TraceId
import hello.advanced.trace.TraceStatus
import org.slf4j.LoggerFactory

class FieldLogTrace: LogTrace {
    companion object {
        private const val START_PREFIX = "-->"
        private const val COMPLETE_PREFIX = "<--"
        private const val EX_PREFIX = "<X-"
    }

    private val log = LoggerFactory.getLogger(javaClass)

    private var traceIdHolder: TraceId? = null

    override fun begin(message: String): TraceStatus {
        syncTraceId()
        val traceId = traceIdHolder ?: throw IllegalArgumentException("Server Error")
        val startTimeMs = System.currentTimeMillis()
        log.info("[{}] {}{}", traceId.id, addSpace(START_PREFIX, traceId.level), message)
        return TraceStatus(traceId, startTimeMs, message)
    }

    private fun syncTraceId() {
        traceIdHolder = traceIdHolder?.createNextId() ?: TraceId()
    }

    override fun end(status: TraceStatus) {
        complete(status, null)
    }

    override fun exception(status: TraceStatus, e: Exception) {
        complete(status, e)
    }

    private fun complete(status: TraceStatus, e: Exception?) {
        val stopTimeMs = System.currentTimeMillis()
        val resultTimeMs = stopTimeMs - status.startTimeMs
        val traceId = status.traceId

        if (e == null) {
            log.info("[{}] {}{} time={}ms", traceId.id, addSpace(COMPLETE_PREFIX, traceId.level), status.message, resultTimeMs)
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.id, addSpace(EX_PREFIX, traceId.level), status.message, resultTimeMs, e.javaClass)
        }

        releaseTraceId()
    }

    private fun releaseTraceId() {
        traceIdHolder = if (traceIdHolder?.isFirstLevel() == true) {
            null
        } else {
            traceIdHolder?.createPreviousId()
        }
    }

    private fun addSpace(prefix: String, level: Int): String {
        var space = ""
        for (i in 0 until level) {
            space += if (level-1 == i) "|$prefix" else "|  "
        }
        return space
    }
}