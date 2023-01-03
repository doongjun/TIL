package hello.exception

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class ErrorPageController {
    private val log = LoggerFactory.getLogger(javaClass)

    @RequestMapping("/error-page/404")
    fun errorPage404(request: HttpServletRequest, response: HttpServletResponse): String {
        printErrorInfo(request)
        return "error-page/404"
    }

    @RequestMapping("/error-page/500")
    fun errorPage500(request: HttpServletRequest, response: HttpServletResponse): String {
        printErrorInfo(request)
        return "error-page/500"
    }

    private fun printErrorInfo(request: HttpServletRequest) {
        log.info("ERROR_EXCEPTION: ex= {}", request.getAttribute(ERROR_EXCEPTION))
        log.info("ERROR_EXCEPTION_TYPE: ex= {}", request.getAttribute(ERROR_EXCEPTION_TYPE))
        log.info("ERROR_MESSAGE: ex= {}", request.getAttribute(ERROR_MESSAGE))
        log.info("ERROR_REQUEST_URI: ex= {}", request.getAttribute(ERROR_REQUEST_URI))
        log.info("ERROR_SERVLET_NAME: ex= {}", request.getAttribute(ERROR_SERVLET_NAME))
        log.info("ERROR_STATUS_CODE: ex= {}", request.getAttribute(ERROR_STATUS_CODE))
    }

    companion object {
        const val ERROR_EXCEPTION = "javax.servlet.error.exception"
        const val ERROR_EXCEPTION_TYPE = "javax.servlet.error.exception_type"
        const val ERROR_MESSAGE = "javax.servlet.error.message"
        const val ERROR_REQUEST_URI = "javax.servlet.error.request_uri"
        const val ERROR_SERVLET_NAME = "javax.servlet.error.servlet_name"
        const val ERROR_STATUS_CODE = "javax.servlet.error.status_code"
    }
}