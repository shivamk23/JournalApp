package com.companyproject.journalApp.scheduler;

import com.companyproject.journalApp.cache.AppCache;
import com.companyproject.journalApp.entity.JournalEntry;
import com.companyproject.journalApp.entity.User;
import com.companyproject.journalApp.enums.Sentiment;
import com.companyproject.journalApp.repository.UserRespositoryImpl;
import com.companyproject.journalApp.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserScheduler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRespositoryImpl userRespository;

    @Autowired
    private AppCache appCache;

//    @Scheduled(cron = "0 0/1 * * * ?")
//    public void fetchUsersAndSendMail() {
//        System.out.println("Starting fetchUsersAndSendMail...");
//
//        List<User> users = userRespository.getUserForSA();
//        System.out.println(users);
//
//        for (User user : users) {
//            System.out.println("Processing user: " + user.getEmail());
//
//            List<JournalEntry> journalEntries = user.getJournalEntries();
//            List<Sentiment> sentiments = journalEntries.stream()
//                    .filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS)))
//                    .map(JournalEntry::getSentiment)
//                    .collect(Collectors.toList());
//
//            Map<Sentiment, Integer> sentimentCounts = new HashMap<>();
//            for (Sentiment sentiment : sentiments) {
//                if (sentiment != null) {
//                    sentimentCounts.put(sentiment, sentimentCounts.getOrDefault(sentiment, 0) + 1);
//                }
//            }
//
//            Sentiment mostFrequentSentiment = null;
//            int maxCount = 0;
//            for (Map.Entry<Sentiment, Integer> entry : sentimentCounts.entrySet()) {
//                if (entry.getValue() > maxCount) {
//                    maxCount = entry.getValue();
//                    mostFrequentSentiment = entry.getKey();
//                }
//            }
//
//            if (mostFrequentSentiment != null) {
//                System.out.println("Most frequent sentiment for " + user.getEmail() + ": " + mostFrequentSentiment);
//                emailService.sendMail(user.getEmail(), "Sentiment for last 7 days", mostFrequentSentiment.toString());
//            }
//        }
//
//        System.out.println("Finished fetchUsersAndSendMail.");
//    }
//
//    public void clearAppCache() {
//        appCache.init();
//    }
}
