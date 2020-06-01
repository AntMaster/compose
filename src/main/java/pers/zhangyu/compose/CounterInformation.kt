package pers.zhangyu.compose

import com.fasterxml.jackson.annotation.JsonFormat

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


@Table(name = "t_counter_info")
@Entity
data class CounterInformation(
        @Id
        var counterId: String? = null,
        var counterType: Int? = null,
        var brandName: String? = null,
        var counterName: String? = null,
        var largeAreaCode: String? = null,
        var largeAreaName: String? = null,
        var provinceCode: String? = null,
        var provinceName: String? = null,
        var cityCode: String? = null,
        var cityName: String? = null,
        var countyCode: String? = null,
        var countyName: String? = null,
        var counterPostalCode: String? = null,
        var counterAbbrev: String? = null,
        var counterAddress: String? = null,
        var operationalModel: String? = null,
        var channelCode: String? = null,
        var channelName: String? = null,
        var isPosExit: Int? = null,
        var counterCooperative: Int? = null,
        var counterPhone: String? = null,
        var orgAreaId: String? = null,
        var orgAreaName: String? = null,
        var orgOfficeId: String? = null,
        var orgOfficeName: String? = null,
        var orgMasterId: String? = null,
        var orgMasterName: String? = null,
        var principalEmpId: String? = null,
        var principalEmpStatus: Int? = null,
        var principalEmpName: String? = null,
        var principalEmpPositionCode: String? = null,
        var principalEmpPositionName: String? = null,
        var principalEmpDeptCode: String? = null,
        var principalEmpDeptName: String? = null,
        var isDel: Int? = null,
        var depositBoxStatus: Int? = null,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        var createTime: LocalDateTime? = null,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        var stopTime: LocalDateTime? = null,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        var reopenTime: LocalDateTime? = null,
        var updateTime: LocalDateTime? = null
) : Serializable {

}