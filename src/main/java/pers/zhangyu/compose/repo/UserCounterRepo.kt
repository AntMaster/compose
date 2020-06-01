package pers.zhangyu.compose.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository
import pers.zhangyu.compose.pojo.UserCounter

@Repository
interface UserCounterRepo : JpaRepository<UserCounter, String>, QuerydslPredicateExecutor<UserCounter> {


}