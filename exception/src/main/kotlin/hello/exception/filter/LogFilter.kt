package hello.exception.filter

import org.slf4j.LoggerFactory
import java.util.*
import javax.servlet.*
import javax.servlet.http.HttpServletRequest

class LogFilter: Filter {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun init(filterConfig: FilterConfig?) {
        log.info("log filter init")
    }

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val httpRequest = request as HttpServletRequest
        val requestURI = httpRequest.requestURI

        val uuid = UUID.randomUUID().toString()

        try {
            log.info("REQUEST [{}][{}][{}]", uuid, request.dispatcherType, requestURI)
        } catch (e: Exception) {
            throw e
        } finally {
            log.info("RESPONSE [{}][{}][{}]", uuid, request.dispatcherType, requestURI)
        }
    }

    override fun destroy() {
        log.info("log filter destroy")
    }
}