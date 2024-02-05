package com.ohgiraffers.section05.access.subsection01;

import jakarta.persistence.*;

/*
*  필드 접근이 기본 값이므로 해당 설정은 제거해도 동일하게 동작한다
* 또한 필드 레벨과 프로퍼티 레벨에 모두 선언하면 프로퍼티 레벨을 우선으로 사용한다
* */
@Entity(name = "member_section05_subsection01")
@Table(name = "tbl_member_section05_subsection01")
@Access(AccessType.FIELD)
public class Member {

    @Id
    @Column(name = "memeber_no")
    @Access(AccessType.FIELD)
    private int memberNo;

    @Column(name = "memeber_id")
    @Access(AccessType.FIELD)
    private String memberId;

    @Column(name = "memeber_pwd")
    @Access(AccessType.FIELD)
    private String memberPwd;



    public Member() {
    }

    public Member(int memberNo, String memberId, String memberPwd) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                '}';
    }

    public int getMemberNo() {
        System.out.println("getMemberNo를 이용한 access확인");
        return memberNo;
    }

    public void setMemberNo(int memberNo) {

        this.memberNo = memberNo;
    }

    public String getMemberId() {
        System.out.println("getmemberId를 이용한 access확인");
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }
}