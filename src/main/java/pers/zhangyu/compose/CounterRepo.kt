package pers.zhangyu.compose

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @Anthor:
 * @Date:2020/4/27 17:33
 */
@Repository
interface CounterRepo : JpaRepository<CounterInformation, String> {

}