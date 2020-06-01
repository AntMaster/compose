package pers.zhangyu.compose.queryDSL

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.web.bind.annotation.*
import pers.zhangyu.compose.CounterVO
import pers.zhangyu.compose.pojo.QUserCounter
import pers.zhangyu.compose.pojo.UserCounter
import pers.zhangyu.compose.repo.UserCounterRepo
import java.util.function.Consumer

/**
 * @Anthor:zhangyu
 * @Date:2020/4/27 17:38
 */
@RestController
@RequestMapping("/queryDSL")
class QueryDSL constructor(
        private val userCounterRepo: UserCounterRepo,
        private val queryFactory: JPAQueryFactory
) {

    private val userCounter = QUserCounter.userCounter

    /**
     * queryDsl查询方式1
     */
    @GetMapping("/query")
    fun query() {
        val result = queryFactory.select(userCounter.counterCode).from(userCounter).where(userCounter.counterCode.eq("0002")).fetchAll()
        print(result)
        //查询并将结果封装至dto中
        val dtoList = queryFactory
                .select(Projections.constructor(CounterVO::class.java, userCounter.counterCode, userCounter.counterName))
                .from(userCounter).fetch()
        println(dtoList)
    }

    /**
     * queryDsl查询方式2
     */
    @GetMapping("/query2")
    fun query2() {

        val booleanBuilder = BooleanBuilder()
        booleanBuilder.and(userCounter.counterCode.eq("0002"))
        val all = userCounterRepo.findAll(booleanBuilder)
        all.forEach(Consumer { x: UserCounter? -> println(x) })

    }

    @PostMapping("/queryWithJPA")
    fun queryWithJPA() {

        val booleanBuilder = BooleanBuilder()
        booleanBuilder.and(userCounter.counterCode.eq("0002"))
        val all = userCounterRepo.findAll(booleanBuilder)
        all.forEach(Consumer { x: UserCounter? -> println(x) })

    }

    @PostMapping("/update")
    fun update() {
        val execute = queryFactory.update(userCounter).set(userCounter.counterName, "zhangsan").where(userCounter.counterName.eq("456")).execute()
        print(execute)
    }

    @PostMapping("/delete")
    fun delete() {
        val execute = queryFactory.delete(userCounter).where(userCounter.counterName.eq("456")).execute()
        print(execute)
    }


//    @PostMapping("/")
//    fun gsonTest() {
//        val gson = GsonBuilder()
//                .addSerializationExclusionStrategy(object : ExclusionStrategy {
//                    override fun shouldSkipField(f: FieldAttributes): Boolean {
//                        // 这里作判断，决定要不要排除该字段,return true为排除
//                        if ("finalField" == f.name) return true //按字段名排除
//                        val expose = f.getAnnotation(Expose::class.java)
//                        return expose != null && !expose.deserialize //按注解排除
//                    }
//
//                    override fun shouldSkipClass(clazz: Class<*>): Boolean {
//                        // 直接排除某个类 ，return true为排除
//                        return clazz == Int::class.javaPrimitiveType || clazz == Int::class.java
//                    }
//                })
//                .create()
//
//        println(gson)
//    }

}