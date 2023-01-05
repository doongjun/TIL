package hello.exception.exhandler

import hello.exception.dto.MemberDto
import hello.exception.exception.UserException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ApiExceptionV2Controller {
    private val log = LoggerFactory.getLogger(javaClass)

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException::class)
    fun illegalExHandle(e: IllegalArgumentException): ErrorResult {
        log.error("[exceptionHandle] ex", e)
        return ErrorResult("BAD", e.message)
    }

    @ExceptionHandler
    fun userExHandle(e: UserException): ResponseEntity<ErrorResult> {
        log.error("[exceptionHandle] ex", e)
        val errorResult = ErrorResult("USER-EX", e.message)
        return ResponseEntity.badRequest().body(errorResult)
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    fun exHandle(e: Exception): ErrorResult {
        log.error("[exceptionHandle] ex", e)
        return ErrorResult("EX", "내부 오류")
    }

    @GetMapping("/api2/members/{id}")
    fun getMember(@PathVariable id: String): MemberDto {
        return when (id) {
            "ex" -> throw RuntimeException("잘못된 사용자")
            "bad" -> throw IllegalArgumentException("잘못된 입력 값")
            "user-ex" -> throw IllegalArgumentException("잘못된 입력 값")
            else -> MemberDto(id, "hello $id")
        }
    }
}