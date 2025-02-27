package com.cnu.real_coding_server.controller;

import com.cnu.real_coding_server.entity.Post;
import com.cnu.real_coding_server.model.request.PostRequest;
import com.cnu.real_coding_server.repository.PostRepository;
import com.cnu.real_coding_server.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest){
        return ResponseEntity.ok(postService.createPost(postRequest));
    }
    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }
    @GetMapping("/{postId}") // 받아올 Id를 postId로 받아온다.
    public ResponseEntity<Post> getPost(@PathVariable("postId") Integer postId){
        return ResponseEntity.ok(postService.getPost(postId).orElse(null));
    }

    public ResponseEntity<Post> updatePost(@PathVariable("postId") Integer postId, @RequestBody PostRequest postRequest){
        return ResponseEntity.ok(postService.updatePost(postId, postRequest).orElse(null));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable("postId")Integer postId){
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }

}