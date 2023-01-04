package hello.exception

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.http.HttpServletResponse

@Controller
class ServletExController {
    @GetMapping("/error-ex")
    fun errorEx() {
        throw RuntimeException("예외 발생!")
    }

    @GetMapping("/error-400")
    fun error400(response: HttpServletResponse) {
        response.sendError(400, "400 오류")
    }

    @GetMapping("/error-404")
    fun error404(response: HttpServletResponse) {
        response.sendError(404, "404 오류")
    }

    @GetMapping("/error-500")
    fun error500(response: HttpServletResponse) {
        response.sendError(500)
    }
}