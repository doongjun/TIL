package hello.exception

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.RequestDispatcher
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class ErrorPageController {
    companion object {
        const val ERROR_EXCEPTION = "javax.servlet.error.exception"
        const val ERROR_EXCEPTION_TYPE = "javax.servlet.error.exception_type"
        const val ERROR_MESSAGE = "javax.servlet.error.message"
        const val ERROR_REQUEST_URI = "javax.servlet.error.request_uri"
        const val ERROR_SERVLET_NAME = "javax.servlet.error.servlet_name"
        const val ERROR_STATUS_CODE = "javax.servlet.error.status_code"
    }

    private val log = LoggerFactory.getLogger(javaClass)

    @RequestMapping("/error-page/404")
    fun errorPage404(
        request: HttpServletRequest,
        response: HttpServletResponse
    ): String {
        printErrorInfo(request)
        return "error-page/404"
    }

    private fun printErrorInfo(
        request: HttpServletRequest
    ) {
        log.info("ERROR_EXCEPTION: ex= {}", request.getAttribute(ERROR_EXCEPTION))
        log.info("ERROR_EXCEPTION_TYPE: ex= {}", request.getAttribute(ERROR_EXCEPTION_TYPE))
        log.info("ERROR_MESSAGE: ex= {}", request.getAttribute(ERROR_MESSAGE))
        log.info("ERROR_REQUEST_URI: ex= {}", request.getAttribute(ERROR_REQUEST_URI))
        log.info("ERROR_SERVLET_NAME: ex= {}", request.getAttribute(ERROR_SERVLET_NAME))
        log.info("ERROR_STATUS_CODE: ex= {}", request.getAttribute(ERROR_STATUS_CODE))
    }


    @RequestMapping(value = ["/error-page/500"], produces = [MediaType.TEXT_HTML_VALUE])
    fun errorPage500(
        request: HttpServletRequest,
        response: HttpServletResponse
    ): String {
        printErrorInfo(request)
        return "error-page/500"
    }

    @RequestMapping(value = ["/error-page/500"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun errorPage500Api(
        request: HttpServletRequest,
        response: HttpServletResponse
    ): ResponseEntity<Map<String, Any?>> {
        log.info("API errorPage 500")

        val result = mutableMapOf<String, Any?>()
        val ex = request.getAttribute(ERROR_EXCEPTION) as Exception
        result["status"] = request.getAttribute(ERROR_STATUS_CODE)
        result["message"] = ex.message

        val statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE) as Int
        return ResponseEntity(result, HttpStatus.valueOf(statusCode))
    }

}