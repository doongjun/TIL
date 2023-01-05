package hello.exception.exhandler

import hello.exception.dto.MemberDto
import hello.exception.exception.UserException
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
class ApiExceptionV2Controller {
    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping("/api2/members/{id}")
    fun getMember(@PathVariable id: String): MemberDto {
        return when (id) {
            "ex" -> throw RuntimeException("잘못된 사용자")
            "bad" -> throw IllegalArgumentException("잘못된 입력 값")
            "user-ex" -> throw UserException("사용자 오류")
            else -> MemberDto(id, "hello $id")
        }
    }
}