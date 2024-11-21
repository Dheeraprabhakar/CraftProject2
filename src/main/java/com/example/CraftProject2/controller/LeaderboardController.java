package com.example.CraftProject2.controller;

import com.example.CraftProject2.model.Score;
import com.example.CraftProject2.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
public class LeaderboardController {
    @Autowired
    private LeaderboardService leaderboardService;

    @PostMapping("/register")
    public void registerScore(@RequestParam String player, @RequestParam int score) {
        leaderboardService.updatePlayerScore(player, score);
    }

    @GetMapping("/top/{n}")
    public List<Score> getTopNPlayers(@PathVariable int n) {
        return leaderboardService.getTopNPlayers(n);
    }
}
