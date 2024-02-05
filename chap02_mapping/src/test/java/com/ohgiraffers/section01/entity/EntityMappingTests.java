package com.ohgiraffers.section01.entity;

import com.ohgiraffers.section01.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Date;

public class EntityMappingTests {
    //싱글톤 패턴
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @AfterEach
    public void closeManager() {
        entityManager.close();
    }

    @Test
    void 테이블_만들기_테스트(){
        com.ohgiraffers.section01.entity.Member member = new com.ohgiraffers.section01.entity.Member();

        member.setMemberNo(1);
        member.setMemberId("userId");
        member.setMemberPwd("1234");
        member.setAddress("관악구 신림동");
        member.setEmail("gorila@gmail.com");
        member.setNickName("gorila");
        member.setEnrollDate(new Date());
        member.setStatus("Y");

        entityManager.persist(member);

        com.ohgiraffers.section01.entity.Member foundMember = entityManager.find(Member.class , member.getMemberNo());
        Assertions.assertEquals(member.getMemberNo(), foundMember.getMemberNo());
    }
/*
* commit 하지 않았기 때문에 dml은 rollback 되어 있지만 ㅡ ddl은 autoCommit 구문이기 때문에 테이블은 생성되엉 있다
* 생성되는 컬럼의 순서는 pk이기
* */

}
