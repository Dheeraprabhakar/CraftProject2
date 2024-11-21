package com.example.CraftProject2.service;


import com.example.CraftProject2.model.Score;
import com.example.CraftProject2.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {

    @Autowired
    private ScoreRepository scoreRepository;

    public int updatePlayerScore(String player, int score) {
        Score scoreObj = new Score(player, score);
        return scoreRepository.saveScoreToLeaderboard( player, score);
    }


    public List<Score> getTopNPlayers(int n) {
        return scoreRepository.getTopNPlayers(n);

    }
}

// curl -X POST "http://localhost:8080/api/leaderboard/register?player=dheera&score=100"
// curl -v -X POST "http://localhost:8080/api/leaderboard/register?player=ithi2&score=650"
// curl -v -X POST "http://localhost:8080/api/leaderboard/register?player=vikrant&score=670"
// curl -v -X POST "http://localhost:8080/api/leaderboard/register?player=vikrant123&score=680"
// curl -v -X POST "http://localhost:8080/api/leaderboard/register?player=anup&score=200"
// curl -v -X POST "http://localhost:8080/api/leaderboard/register?player=dheera2&score=690"
// curl -v -X POST "http://localhost:8080/api/leaderboard/register?player=dheer&score=601"
// curl -v -X POST "http://localhost:8080/api/leaderboard/register?player=anupm&score=620"


 //curl -v GET "http://localhost:8080/api/leaderboard/top/5"


///AFETR ADDING AUTH

//curl -u admin:adminpass -X POST "http://localhost:8080/api/leaderboard/register?player=dheera&score=109"
// curl -u admin:adminpass -X POST "http://localhost:8080/api/leaderboard/register?player=anupm&score=620"
// curl -v -X POST "http://localhost:8080/api/leaderboard/register?player=vikrant2&score=670" -u admin:adminpass
// curl -v -X POST "http://localhost:8080/api/leaderboard/register?player=ithi&score=671" -u admin:adminpass
// curl -v -X POST "http://localhost:8080/api/leaderboard/register?player=ithi&score=671" -u admin:adminpass
// curl -v -X POST "http://localhost:8080/api/leaderboard/register?player=ithi2&score=671" -u admin:adminpass
// curl -v -X POST "http://localhost:8080/api/leaderboard/register?player=vikrant&score=670" -u admin:adminpass
// curl -v -X POST "http://localhost:8080/api/leaderboard/register?player=vikrant123&score=680" -u admin:adminpass
// curl -v -X POST "http://localhost:8080/api/leaderboard/register?player=anup&score=200" -u admin:adminpass
// curl -v -X POST "http://localhost:8080/api/leaderboard/register?player=dheera2&score=690" -u admin:adminpass
// curl -v -X POST "http://localhost:8080/api/leaderboard/register?player=dheer&score=601" -u admin:adminpass



//curl -v GET "http://localhost:8080/api/leaderboard/top/5" -u user:userpass
