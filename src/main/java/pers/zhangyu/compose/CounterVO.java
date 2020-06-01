package pers.zhangyu.compose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CounterVO {

    private String counterCode;
    private String counterName;
}
