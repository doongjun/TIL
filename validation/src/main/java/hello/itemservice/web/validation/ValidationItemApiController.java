package hello.itemservice.web.validation;

import hello.itemservice.domain.item.ItemSaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/validation/api/items")
class ValidationItemApiController {

    @PostMapping("/add")
    public Object addItem(
            @Valid @RequestBody ItemSaveForm form,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            log.info("검증 오류 발생 = errors={}", bindingResult);
            return bindingResult;
        }

        return form;
    }
}
