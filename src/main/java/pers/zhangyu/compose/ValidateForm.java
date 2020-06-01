package pers.zhangyu.compose;


import lombok.Data;

import javax.validation.constraints.*;

/**
 * @Anthor:Fangtao
 * @Date:2020/5/6 14:17
 */

@Data
public class ValidateForm {

    private String userId;

    @NotNull(message = "爱宠类别必填")
    @Min(value = 0,message = "年龄最小为0")
    @Max(value = 12,message = "年龄最大为12岁")
    @Digits(integer = 1, fraction = 2,message = "整数位最多一位")
    private Integer classifyId;

    @NotNull(message = "爱宠类别必填")
    private Integer varietyId;

    @NotBlank(message = "爱宠头像必填")
    private String headImgUrl;


    @NotBlank(message = "爱宠昵称必填")
    private String nickName;


    @NotNull(message = "爱宠节育状态必填")
    private Integer contraception;


    @NotNull(message = "爱宠性别必填")
    private Integer sex;


    @NotBlank(message = "爱宠生日必填")
    private String birthday;


    @NotBlank(message = "爱宠小特点必填")
    private String description;


    private String chipNo;

}
