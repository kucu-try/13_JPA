package com.ohgiraffers.section02.column;

import jakarta.persistence.*;

import java.util.Date;

/*
* 컬럼매핑시 @column 어노테이션에 사용 가능한 속성들
* 1. name; 매핑할 테이블의 컬럼 이름
* 2. insertable: 엔티티 저장시 필드 저장여부 (default:true
* 3. updatable : 엔티티 수정 시 필드 수정 여부 (디폴트 트루
* 4. table: 엔티티와 매핑될 테이블 이름. 하나의 엔티티를 두 개 이상의 테이블에 매핑할 때 사용(@SecondaryTable 사용)
* 5. nullable: null 값 허용 여부 설정, not null 제약 조건에 해당함 (true 기본값)
* 6. unique: 컬럼에 유일성 제약조건
* (두개 이상 컬럼에 unique 제약조건을 설정하기 위해서 클래스 레벨에서 @table의 uniqueConstraints 속성에 설정)
* 7. columnsDefinition: 직접 컬럼의 ddl을 저장
* 8. length: 문자열 길이, String type에서만 사용(default: 255)
* */
@Entity(name = "member_section02")
@Table(name = "tbl_member_section02")
public class Member {

    @Id
    @Column(name = "memeber_no")
    private int memberNo;

    @Column(name = "memeber_id")
    private String memberId;

    @Column(name = "memeber_pwd")
    private String memberPwd;

    @Column(name = "nickName")
    @Transient // 테이블 생성 시 무시된다.
    private String nickName;

    @Column(name = "phone", columnDefinition = "varchar(200) default '010-0000-0000'")
    private String phone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "address", nullable = false)  // null 허용하지 않겠다라는 의미
    private String address;

    @Column(name = "enroll_date")
    @Temporal(TemporalType.TIMESTAMP) // dateTime
//    @Temporal(TemporalType.DATE) // date
//    @Temporal(TemporalType.TIME) // time
    private Date enrollDate;
    @Column(name = "member_role")
    private String memberRole;

    @Column(name = "status")
    private String status;

    public Member() {
    }

    public Member(int memberNo, String memberId, String memberPwd, String nickName, String phone, String email, String address, Date enrollDate, String memberRole, String status) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.nickName = nickName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRole = memberRole;
        this.status = status;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", enrollDate=" + enrollDate +
                ", memberRole='" + memberRole + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
