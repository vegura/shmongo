package me.vegura.parsers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;
import me.vegura.model.LondonIdx;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
@Slf4j
public class LondonIndexesCsvParser implements SCVParser<LondonIdx> {

    // Overrides

    public Set<LondonIdx> parse(String filename) {
        final Set<LondonIdx> londonIdxSet = new HashSet<>();

        log.info("Parsing csv file -> {}", filename);

        final File dataFile = new File(filename);

        try {
            final FileReader fileReader = new FileReader(dataFile);
            final CSVReader csvDataReader = new CSVReader(fileReader);
            csvDataReader.skip(1);

            String[] dataRow = null;
            while ((dataRow = csvDataReader.readNext()) != null) {
                final LondonIdx londonIdx = new LondonIdx()
                        .setPostcode(dataRow[0])
                        .setLatitude(new BigDecimal(dataRow[2]))
                        .setLongitude(new BigDecimal(dataRow[3]))
                        .setDistrictName(dataRow[8]);



                londonIdxSet.add(londonIdx);
            }

        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }

        return londonIdxSet;
    }
}
