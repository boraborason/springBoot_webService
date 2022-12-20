package com.sbr.springboot.service;

import com.sbr.springboot.domain.posts.Posts;
import com.sbr.springboot.domain.posts.PostsRepository;
import com.sbr.springboot.web.dto.PostsListResponseDto;
import com.sbr.springboot.web.dto.PostsResponseDto;
import com.sbr.springboot.web.dto.PostsSaveRequestDto;
import com.sbr.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor //=Autowired final이 선언된 모든 필드를 인자값으로 하는 생성자
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) { //jpa의 영속성 컨텐츠(쿼리 send없음)
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(posts); //jpa에서 삭제를 이미 지원 (존재 확인후 삭제)
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) //트랜잭션 범위는 유지하면서 조회기능속도 유지
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream() //postsRepository결과로 넘어온 posts의 스트림을 map을 통해
                .map(PostsListResponseDto::new)         //PostsListResponseDto로 변환하여 List로 반환하는 메소드
                .collect(Collectors.toList());
    }
}
