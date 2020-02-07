package app.sagen.ordersystem.backend.initialization;

import app.sagen.ordersystem.backend.model.PostNummer;
import app.sagen.ordersystem.backend.service.PostNummerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PostNummerInitializer {

    private PostNummerService postNummerService;

    @Autowired
    public PostNummerInitializer(PostNummerService postNummerService) {
        this.postNummerService = postNummerService;
    }

    @Async("threadPoolTaskExecutor")
    public void load() {
        // todo: enable this test in production
//        if(postNummerService.count() > 0) {
//            log.debug("Postal codes table is not empty. Ignoring");
//            return;
//        }

        log.info("Loading postal codes");

        InputStream fileStream = getClass().getResourceAsStream("/Postnummerregister-ansi.txt");
        BufferedReader fileReader;
        try {
            fileReader = new BufferedReader(new InputStreamReader(fileStream, "Cp1252"));
        } catch (UnsupportedEncodingException e) {
            log.error("Error while loading postal numbers from file!", e);
            return;
        }

        List<PostNummer> postNummers = new ArrayList<>();

        fileReader.lines().forEach(line -> {
            try {
                String[] args = line.split("\\s+");
                if(args.length != 5) return; // ignore invalid data

                PostNummer postNummer = new PostNummer();
                postNummer.setPostnummer(args[0]);
                postNummer.setPoststed(args[1]);
                postNummer.setKommunekode(args[2]);
                postNummer.setKommunenavn(args[3]);
                postNummer.setKategori(args[4]);

                postNummers.add(postNummer);

                if(postNummers.size() >= 500) {
                    postNummerService.saveAll(postNummers);
                    log.debug("Saved/updated {} postal codes", postNummers.size());
                    postNummers.clear();
                }

            } catch (Exception e) {
                log.error("Error while reading line: '{}'", line, e);
            }
        });

        postNummerService.saveAll(postNummers);
        log.debug("Saved/updated {} postal codes", postNummers.size());

        log.info("Completed!");
    }
}
