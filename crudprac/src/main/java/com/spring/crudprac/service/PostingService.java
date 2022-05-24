package com.spring.crudprac.service;

import com.spring.crudprac.dto.PostDto;
import com.spring.crudprac.model.Posting;
import com.spring.crudprac.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostingService {
    private final PostRepository postRepository;

    @Autowired
    public PostingService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void postwrite(PostDto postDto) {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Posting posting = new Posting(postDto);
        postRepository.save(posting);
    }

    public List<Posting> postview() {
        return postRepository.findAll();
    }

    public Posting getdetail(Long id) {
        Optional<Posting> result = postRepository.findById(id);
        return result.get();
    }
}
