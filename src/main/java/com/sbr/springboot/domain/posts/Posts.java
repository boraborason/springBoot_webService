package com.sbr.springboot.domain.posts;

//import com.jojoldu.book.springboot.domain.BaseTimeEntity;

import com.sbr.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//해당 클래스의 인스턴스 값이 어디서 변해야 하는지 명확히 하기위해 Entity클래스에 setter는 만들지 않는다.
@Getter
@NoArgsConstructor//기본생성자 추가
@Entity //테이블과 링크될 class임
public class Posts extends BaseTimeEntity { //실제 DB와 매칭될 class DTO

    @Id //PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK의 규칙성을 나타냄
    private Long id;

    @Column(length = 500, nullable = false) //컬럼을 선언하지 않아도 해당 클래스 필드는 모두 칼럼이 된다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //빌더를 사용하여 어느 필드에 어떤 값을 채워야 하는지 정확히 인지
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
