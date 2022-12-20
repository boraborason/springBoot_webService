package com.sbr.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PostsRepository  extends JpaRepository<Posts, Long> { //DAO-DB레이어 접근자 (JPA에서는 저장소라고 불림)
                                                                        //JpaRepository<Entity클래스, pk타입>을 상속하면 기본
                                                                        //CRUD가 생성된다.

    //springDataJpa에서 제공하지 않는 메소드는 @Query 쿼리로 작성 가능
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}

