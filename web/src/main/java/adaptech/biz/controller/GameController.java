package adaptech.biz.controller;

import adaptech.biz.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("home")
    public String home() {
        return "home";
    }

    @GetMapping("play")
    public String playGame(Model model) {
        model.addAttribute("mainMessage", gameService.getMainMessage());
        model.addAttribute("resultMessage", gameService.getResultMessage());
        return "play";
    }

    @GetMapping("game-over")
    public String gameOver(Model model) {
        model.addAttribute("mainMessage", gameService.getMainMessage());
        model.addAttribute("resultMessage", gameService.getResultMessage());
        gameService.resetGame();
        return "game-over";
    }

    @PostMapping("play")
    public String guessNumber(@RequestParam int guess) {
        log.info("Guessed number {}", guess);
        gameService.setGuess(guess);
        gameService.checkGameStatus();

        return gameService.isGameOver() ? "redirect:/game-over" : "redirect:/play";

    }
}
