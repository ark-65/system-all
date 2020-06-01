package com.teacher.system.controller;

import com.teacher.system.domain.Statistics;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
public class TestContorller {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/getTestData")
    public List<Statistics> getTestData() {
        StoredProcedureQuery store = this.entityManager.createNamedStoredProcedureQuery("StatiticsAll");
        List<Statistics> resultList = store.getResultList();
        log.info(resultList.toString());
        return resultList;
    }
//    @GetMapping("/user")
//    public Page<UserInfo> getUserByPageable(@PageableDefault(page = 0, size = 10, sort = {"username"}, direction = Sort.Direction.DESC)
//                                                    Pageable pageable) {
//        return userService.findPage(pageable);
//    }
}
