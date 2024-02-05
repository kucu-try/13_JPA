package com.ohgiraffers.section03.primaryKey.subsection01.identity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Date;
import java.util.List;

public class PrimaryKeyMappingTests {
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

    /*
    *  Primary key에는 @Id 어노테이션과 @GeneratedValue 어노테이션을 사용한다.
    *  @Id 어노테이션은 엔티티 클래스에서 primary key 역할을 하는 필드를 지정할 때 사용한다
    * @GenerationValue 어노테이션을 함께 사용하면 primary key 값을 자동을 생성할 수 있다
    *
    * 데이터 베이스마다 기본 키를 생성하는 방식이 서로 다르다
    * @GenenatedValue 어노테이션은 다음과 같은 속성을 가지고 있다
    *
    * strategy : 자동 생성 정략을 지정
    * GenerationType.IDENTITY : 기본 키 생성을 데이터베이스에 위임 (mysql의 AUTO_INCREMENT)
    * GenerationType.SEQUENCE : 데이터베이스 시퀀스 객체 사용(Oracle 의 sequence)
    * GenerationType.TABLE : 키 생성 테이블 사용
    * GenerationType.AUTO : 자동선택 (MYSQL 이라면 IDENTITY, ORACLE 이라면 SEQUENCE로 선택)
    * generator : strategy 값을 GenerationType.TABLE 로 지정한 경우 사용되는 테이블 이름을 지정
    * initialValue : strategy 값을 GenerationType.SEQUENCE로 지정한 경우 시퀀스 초기값을 지정
    * allocationSize : strategy 값을 GenerationType.SEQUENCE로 지정한 경우 시퀀스 증가치를 지정
    * */

    /* IDENTITY 전략 */
    @Test
    public void 식별자_매핑_테스트() {

        // given
        Member member = new Member();
        member.setMemberId("user01");
        member.setMemberPwd("pass01");
        member.setNickName("홍길동");
        member.setPhone("010-1234-5678");
        member.setAddress("서울시 종로구");
        member.setEnrollDate(new Date());
        member.setMemberRole("ROLE_MEMBER");
        member.setStatus("Y");

        Member member2 = new Member();
        member2.setMemberId("user02");
        member2.setMemberPwd("pass02");
        member2.setNickName("유관순");
        member2.setPhone("010-1234-5678");
        member2.setAddress("서울시 종로구");
        member2.setEnrollDate(new Date());
        member2.setMemberRole("ROLE_MEMBER");
        member2.setStatus("Y");

        // when
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(member);
        entityManager.persist(member2);
        entityTransaction.commit();

        //then
        String jpql = "SELECT A.memberNo FROM member_section03_subsection01 A";
        List<Integer> memberNoList = entityManager.createQuery(jpql, Integer.class).getResultList();

        memberNoList.forEach(System.out::println);

    }

}
