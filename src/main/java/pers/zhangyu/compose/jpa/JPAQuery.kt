package pers.zhangyu.compose.jpa

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pers.zhangyu.compose.CounterInformation
import pers.zhangyu.compose.CounterRepo
import pers.zhangyu.compose.UserCounter
import pers.zhangyu.compose.UserCounterRepo

@RestController
@RequestMapping("/jpa")
class JPAQuery(
        private val userCounterRepo: UserCounterRepo,
        private val counterRepo: CounterRepo
) {

    @GetMapping("/query1/{id}")
    fun query1(@PathVariable id: String): CounterInformation {
        return counterRepo.findById(id).orElse(CounterInformation())!!
    }

    @GetMapping("/query2/{id}")
    fun query2(@PathVariable id: String): CounterInformation {
        return counterRepo.findById(id).orElse(CounterInformation())!!
    }

    @GetMapping("/save1")
    fun save1(): UserCounter {
        val userCounter = UserCounter("id1", "id", "id", "id", "id", 1)
        return userCounterRepo.save(userCounter)
    }

    @GetMapping("/save2")
    fun save2(): UserCounter {
        val userCounter = UserCounter("id2", "id", "id", "id", "id", 1)
        return userCounterRepo.save(userCounter)
    }


}