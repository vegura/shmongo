package me.vegura;

import io.quarkus.runtime.StartupEvent;
import lombok.extern.slf4j.Slf4j;
import me.vegura.model.LondonIdx;
import me.vegura.repo.LondonIdxRepo;
import me.vegura.resource.LondonIndexesCsvParser;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.Set;

@ApplicationScoped
@Slf4j
public class ApplicationListener {

    // Variables

    private final String CSV_LONDON_IDXS_FILENAME = "data/london_postcodes.csv";

    @Inject
    LondonIndexesCsvParser csvImporter;

    @Inject
    LondonIdxRepo idxRepo;

    @ConfigProperty(name = "london.idx.parse-and-save", defaultValue = "false")
    boolean isReUpdatingNeed;

    // Public

    public void onStart(@Observes StartupEvent startupEvent) {
        log.info("Starting application -> {}", isReUpdatingNeed);

        if (isReUpdatingNeed) {
            final Set<LondonIdx> importedIdxs = csvImporter.parse(CSV_LONDON_IDXS_FILENAME);
            log.info("Fetched data -> {}", importedIdxs);
            idxRepo.persistOrUpdate(importedIdxs);
        }
    }
}
