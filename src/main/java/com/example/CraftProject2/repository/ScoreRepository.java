package com.example.CraftProject2.repository;

import com.example.CraftProject2.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    @Query(value = "SELECT * FROM score ORDER BY score DESC, player ASC LIMIT :n", nativeQuery = true)
    List<Score> getTopNPlayers(@Param("n")  int n);
    @Transactional
    @Modifying
    @Query(value = "insert into score (player, score) values (:player, :score) on conflict (player) DO UPDATE SET score = GREATEST(score.score, EXCLUDED.score)", nativeQuery = true)
    int saveScoreToLeaderboard(@Param("player") String player, @Param("score") int score);
}
