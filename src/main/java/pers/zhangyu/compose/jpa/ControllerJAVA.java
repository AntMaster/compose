package pers.zhangyu.compose.jpa;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.zhangyu.compose.repo.CounterRepo;
import pers.zhangyu.compose.pojo.UserCounter;
import pers.zhangyu.compose.repo.UserCounterRepo;

/**
 * @Anthor:Fangtao
 * @Date:2020/4/27 17:38
 */
@RestController
@RequestMapping("/java")
public class ControllerJAVA {

    private final CounterRepo counterRepo;
    private final UserCounterRepo userCounterRepo;
    private final JPAQueryFactory queryFactory;
    //private final QUserCounter userCounter = QUserCounter.userCounter;

    @Autowired
    public ControllerJAVA(CounterRepo counterRepo, UserCounterRepo userCounterRepo, JPAQueryFactory queryFactory) {
        this.counterRepo = counterRepo;
        this.userCounterRepo = userCounterRepo;
        this.queryFactory = queryFactory;
    }




    @GetMapping("/save1")
    public UserCounter save1() {
        UserCounter userCounter = new UserCounter("id1", "id", "id", "id", "id", 1);
        return userCounterRepo.save(userCounter);
    }

    @GetMapping("/save2")
    public UserCounter save2() {
        UserCounter userCounter = new UserCounter("id2", "id", "id", "id", "id", 1);
        return userCounterRepo.save(userCounter);
    }

    /**
     * queryDsl查询方式1
     */
 /*   @GetMapping("/querydsl")
    public void queryDsl() {
        JPAQuery<String> where = queryFactory.select(userCounter.counterCode).from(userCounter).where(userCounter.counterCode.eq("0002")).fetchAll();
        System.out.println(where);
        //查询并将结果封装至dto中
        List<CounterVO> dtoList = queryFactory
                .select(Projections.constructor(CounterVO.class, userCounter.counterCode, userCounter.counterName))
                .from(userCounter).fetch();
        System.out.println(dtoList);
    }*/

    /**
     * queryDsl查询方式2
     */
    @GetMapping("/querydsl2")
    //@DS(DBConst.SLAVE)
    public void queryDsl2() {
      /*  BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(userCounter.counterCode.eq("0002"));
        Iterable<UserCounter> all = userCounterRepo.findAll(booleanBuilder);
        all.forEach(System.out::println);*/
    }



    /*@PostMapping("/validate")
    public void validate(@RequestBody @Valid ValidateForm validateForm) {
        System.out.println("123");
    }*/

    /*public Long update(String id, String nickName) {
        QUserModel userModel = QUserModel.userModel;
        // 更新
        return queryFactory.update(userModel).set(userModel.nickName, nickName).where(userModel.id.eq(id)).execute();
    }

    public Long delete(String id) {
        QUserModel userModel = QUserModel.userModel;
        // 删除
        return queryFactory.delete(userModel).where(userModel.id.eq(id)).execute();
    }*/




}
