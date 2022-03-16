package br.eco.econam.collector.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {
    private static final Logger logger = LoggerFactory.getLogger(TesteController.class);
    private final SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(cron = "*/5 * * * * *")
    public void performTask() {
        LocalDateTime now = LocalDateTime.now();
        logger.info("task iniciada ---" + now);
        this.simpMessagingTemplate.convertAndSend("/topic/teste", now);
    }

    public TesteController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        System.out.println(simpMessagingTemplate);
    }
}
