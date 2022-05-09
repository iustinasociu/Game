package project.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class Scheduler {

    @Scheduled(cron = "0 */1 * * * *")
    public void scheduler() throws InterruptedException{
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
        String formattedDateTime = current.format(format);
        log.info("Scheduler time " + formattedDateTime);
        Thread.sleep(1000);
    }
}
