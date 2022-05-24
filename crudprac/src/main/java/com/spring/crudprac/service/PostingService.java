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

    public int passwordcheck(Long id, String password) {
        Optional<Posting>optional = postRepository.findById(id);
        Posting posting = optional.get();
        String realpassword = posting.getPassword();
        if(realpassword.equals(password)){
            return 1;
        }else {
            return 0;
        }
    }

    public Posting changedetail(Posting posting) {
        Posting posting1 = postRepository.findById(posting.getId())
                .orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));
        posting1.setTitle(posting.getTitle());
        posting1.setDescription(posting.getDescription());
        posting1.setUsername(posting.getUsername());
        postRepository.save(posting1);
        return posting1;
    }

    public void deletedetail(Posting posting) {
        postRepository.delete(
                postRepository.findById(posting.getId()).orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."))
        );
    }
}
