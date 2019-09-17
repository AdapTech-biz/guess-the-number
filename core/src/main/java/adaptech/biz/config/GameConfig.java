package adaptech.biz.config;

import adaptech.biz.GuessCount;
import adaptech.biz.MaxNumber;
import adaptech.biz.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "adaptech.biz")
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // == fields ==
    @Value("${game.guessCount: 9}")
    private int guessCount;

    @Value("${game.maxNumber: 10}")
    private int maxNumber;

    @Value("${game.minNumber: 2}")
    private int minNumber;

    // == bean methods ==
    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber() { return minNumber; }
}
