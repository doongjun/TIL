package hello.typeconverter.controller

import org.springframework.format.annotation.DateTimeFormat
import org.springframework.format.annotation.NumberFormat
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import java.time.LocalDateTime

@Controller
class FormatterController {

    @GetMapping("/formatter/edit")
    fun formatterForm(model: Model): String {
        val form = Form(10000, LocalDateTime.now())
        model.addAttribute("form", form)

        return "formatter-form"
    }

    @PostMapping("/formatter/edit")
    fun formatterEdit(@ModelAttribute form: Form): String {
        return "formatter-view"
    }

    data class Form(
        @field:NumberFormat(pattern = "###,###")
        var number: Int? = null,
        @field:DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        var localDateTime: LocalDateTime? = null
    )

}