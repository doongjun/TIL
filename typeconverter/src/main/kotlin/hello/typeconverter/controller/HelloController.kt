package hello.typeconverter.controller

import hello.typeconverter.type.IpPort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/hello")
    fun hello(@RequestParam data: Int): String {
        return "ok"
    }

    @GetMapping("/ipPort")
    fun ipPort(@RequestParam ipPort: IpPort): IpPort {
        return ipPort
    }
}