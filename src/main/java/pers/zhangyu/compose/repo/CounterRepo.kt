package pers.zhangyu.compose.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pers.zhangyu.compose.pojo.CounterInformation

/**
 * @Anthor:
 * @Date:2020/4/27 17:33
 */
@Repository
interface CounterRepo : JpaRepository<CounterInformation, String> {

}