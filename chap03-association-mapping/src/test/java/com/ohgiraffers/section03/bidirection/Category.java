package com.ohgiraffers.section03.bidirection;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


/*
* 양방향 매핑에서 어느 한 쪽이 연관 관계의 주인이 되면, 주인이 아닌 쪽에서는 속성을 지정해 주어야한다
* 이 때 , 연관관계의 주인이 아닌 객체 MappedBy를 써서 연관 관계 주인 객체의 필드명을 매핑시켜 놓으면 양방향 관계를 적용할 수 있다.
* */
@Entity(name = "bidirection_category")
@Table(name = "tbl_category")
public class Category {

    @Id
    @Column(name = "category_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private int categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "ref_category_code")
    private Integer refCategoryCode;

    @OneToMany(mappedBy = "categoryCode",cascade = CascadeType.PERSIST)   // 상대편 클래스의 필드를 작성한다(categorycode) mappedBy 가 달리면 주인이 아니다.  조회만 가능하다.
    private List<Menu> menuList = new ArrayList<>();

    public Category() {
    }


    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public Category(int categoryCode, String categoryName, Integer refCategoryCode) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

//    public void setMenuList(List<Menu> menuList) {
//        this.menuList = menuList;
//    }

public void setMenuList(List<Menu> menuList) {

    List<Menu> list = new ArrayList<>();
    for (Menu m : menuList) {
        m.setCategoryCode(this);
        list.add(m);
    }

    this.menuList = list;
}

    @Override
    public String toString() {
        return "CategoryAndMenu{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", menuList=" + menuList +
                '}';
    }
}
