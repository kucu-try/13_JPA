package com.ohgiraffers.section01.manytoone;

import jakarta.persistence.*;
/*
* @JoinColumn은 다대일 연관관계에서 사용되는 어노테이션이다
* @JoinColumn에서 사용할 수 있는 속성들은 다음과 같다
*
* -name : 참조하는 테이블의 컬럼명을 지정한다
* -referencedColumnName : 참조되는 컬럼명을 지정한다
* -nullable : 참조하는 테이블의 칼럼에 null값을 허용할지 여부를 지정한다
* -unique : 참조하는 테이블의 컬럼에 유일성 제약 조건을 추가할지 여부를 지정한다
* -insertable: 새로운 엔티티가 저장될 때 , 이 참조 컬럼이 sql insert 문에 포함될지 여부를 지정한다
* -updatable : 엔티티가 업데이트 될 때, 이 참조 컬럼이 SQL update 문에 포함될지 여부를 지정한다
* -table : 참조하는 테이블의 이름을 지정한다
* -foreignkey : 참조하는 테이블에 생성될 외래 키에 대한 추가 정보를 지정한다
*
* @ManyToOne 은 다대일 연관관계에서 사용되는 어노테이션이다
* @ManyToOne 에서 사용할 수 있는 속성들은 다음과 같다
*
* -cascade : 연관된 엔티티의 대한 영속성 전이를 설정한다(생명주기만 설정한다)
* -fetch : 연관된 엔티티를 로딩하는 전략을 설정한다
* -optional : 연관된 엔티티가 필수인지 선택적인지 설정한다.
* */
@Entity(name = "menu_and_category")
@Table(name = "tbl_menu")
public class MenuAndCategory {

    @Id
    @Column(name = "menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private int menuPrice;

    /*
    * CascadeType.PERSIST
    * PERSIST : 엔티티를 영속화 할 때 , 연관된 하위 엔티티도 함께 유지된다  //없는 쿼리를 등록한다. 있으면 그대로
    * Merge: 엔티티 상태를 병함 할 때 연관된 하위 엔티티도 모두 병합한다
    * Remove: 엔티티를 제거할 때 연관된 하위 엔티티 도 모두 제거한다
    * Detach: 영속성 컨텍스트 엔티티 제거, 부모 엔티티를 Detach() 수행하면 하위 엔티티도 detach 상태가 된어 변경 사항을 반영하지 않는다
    * Refresh : 상위 엔티티를 새로 고침할 때 연관된 하위 엔티티도 모두 새로 고침한다.
    * */
    @JoinColumn(name = "category_code")
//    @ManyToOne(cascade = CascadeType.PERSIST) //테스트 1
//    @ManyToOne(cascade = CascadeType.REMOVE) // 테스트2
//    @ManyToOne(cascade = CascadeType.REFRESH) // 테스트3
//    @ManyToOne // 테스트 3
//    @ManyToOne(cascade = CascadeType.MERGE) // 테스트4
    @ManyToOne(cascade = CascadeType.DETACH) // 테스트 5
    private Category category;

    @Column(name = "orderable_status")
    private String orderableStatus;

    public MenuAndCategory(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuAndCategory{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", category=" + category +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    public MenuAndCategory() {
    }

    public MenuAndCategory(int menuCode, String menuName, int menuPrice, Category category) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
