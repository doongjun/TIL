package hello.exception

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiExceptionController {
    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping("/api/members/{id}")
    fun getMember(
        @PathVariable id: String
    ): MemberDto {
        if (id == "ex") {
            throw RuntimeException("잘못된 사용자")
        }

        if (id == "bad") {
            throw IllegalArgumentException("잘못된 입력 값")
        }

        return MemberDto(id, "hello $id")
    }
}

data class MemberDto(
    val memberId: String,
    val name: String
)