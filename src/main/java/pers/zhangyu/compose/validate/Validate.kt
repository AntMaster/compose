package pers.zhangyu.compose.validate

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import pers.zhangyu.compose.ValidateForm

@RestController("/validate")
class Validate {

    @PostMapping
    fun validate(@RequestBody validateForm: ValidateForm): ValidateForm {
        return validateForm
    }
}