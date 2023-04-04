package hello.advanced.trace

import java.util.UUID

data class TraceId(
    val id: String = UUID.randomUUID().toString(),
    val level: Int = 0
) {
    fun createNextId() = TraceId(id = id, level = level+1)
    fun createPreviousId() = TraceId(id = id, level = level-1)
    fun isFirstLevel() = level == 0
}