package pers.zhangyu.compose.pojo

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "t_employee_counter")
data class UserCounter(
        @Id
        var empId: String? = null,
        var name: String? = null,
        var phoneNo: String? = null,
        var counterCode: String? = null,
        var counterName: String? = null,
        var isMaster: Int? = null
) : Serializable