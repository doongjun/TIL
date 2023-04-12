package hello.advanced.threadlocal

import hello.advanced.threadlocal.code.FieldService
import hello.advanced.threadlocal.code.ThreadLocalService
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class ThreadLocalServiceTest {
    private val log = LoggerFactory.getLogger(javaClass)

    private val service = ThreadLocalService()

    @Test
    fun field() {
        log.info("main start")
        val userA = Runnable { service.logic("userA") }
        val userB = Runnable { service.logic("userB") }

        val threadA = Thread(userA)
        threadA.name = "thread-A"
        val threadB = Thread(userB)
        threadB.name = "thread-B"

        threadA.start()
//        sleep(2000) //동시성 문제 발생 X
        sleep(100) //동시성 문제 발생
        threadB.start()
        sleep(3000) //메인 쓰레드 종료 대기

        log.info("main exit")
    }

    private fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}