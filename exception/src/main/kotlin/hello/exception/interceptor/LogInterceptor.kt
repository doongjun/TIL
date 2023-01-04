package hello.exception.interceptor

import org.slf4j.LoggerFactory
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class LogInterceptor: HandlerInterceptor {
    companion object {
        const val LOG_ID = "logId"
    }

    private val log = LoggerFactory.getLogger(javaClass)

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val requestURI = request.requestURI

        val uuid = UUID.randomUUID().toString()
        request.setAttribute(LOG_ID, uuid)

        log.info("REQUEST [{}][{}][{}][{}]", uuid, request.dispatcherType, requestURI, handler)
        return true
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {
        log.info("postHandle [{}]", modelAndView)
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        val requestURI = request.requestURI
        val logId = request.getAttribute(LOG_ID) as String
        log.info("RESPONSE [{}][{}][{}]", logId, request.dispatcherType, requestURI)
        if (ex != null) {
            log.error("afterCompletion error!!", ex)
        }
    }
}