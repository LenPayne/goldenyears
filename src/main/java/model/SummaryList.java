/*
 * Copyright 2015 Len Payne <len.payne@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package model;

import au.com.bytecode.opencsv.CSV;
import au.com.bytecode.opencsv.CSVReadProc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import org.json.simple.JSONArray;

/**
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
@ApplicationScoped
public class SummaryList {

    private final List<Summary> summaryList = new ArrayList<>();
    private final String CSV_FILENAME = "/CODE-Dataset.csv";

    public SummaryList() {
        BufferedReader inputFile = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(CSV_FILENAME)));
        CSV csv = CSV.separator(',').charset(StandardCharsets.UTF_8).skipLines(1).quote('"').create();
        csv.read(inputFile, new CSVReadProc() {

            @Override
            public void procRow(int i, String... strings) {
                Logger.getLogger(getClass().getName()).log(Level.INFO, strings[0]);
                summaryList.add(new Summary(
                        strings[0].trim(),
                        Double.parseDouble(strings[1].trim()),
                        Double.parseDouble(strings[2].trim()),
                        Double.parseDouble(strings[3].trim()),
                        (strings[4].isEmpty()) ? -1 : Double.parseDouble(strings[4].trim())
                ));
            }
        });
    }

    public JSONArray toJSON() {
        JSONArray json = new JSONArray();
        for (Summary s : summaryList) {
            json.add(s.toJSON());
        }
        return json;
    }

    public String toJSONString() {
        return toJSON().toJSONString();
    }
}
