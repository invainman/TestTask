package com.nba.TestTask.repository;

import com.nba.TestTask.entity.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post getById(Long id);

    @Transactional
    void deleteAllByProfileId(Long profileId);
}
