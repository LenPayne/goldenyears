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

import org.json.simple.JSONObject;

/**
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
public class Summary {
    private String city = "";
    private double health = 0;
    private double stress = 0;
    private double expenses = 0;
    private double historicalExpenses = 0;

    public Summary(String city, double health, double stress, double expenses, double historicalExpenses) {
        this.city = city;
        this.health = health;
        this.stress = stress;
        this.expenses = expenses;
        this.historicalExpenses = historicalExpenses;
    }

    public Summary() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getStress() {
        return stress;
    }

    public void setStress(double stress) {
        this.stress = stress;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getHistoricalExpenses() {
        return historicalExpenses;
    }

    public void setHistoricalExpenses(double historicalExpenses) {
        this.historicalExpenses = historicalExpenses;
    }
    
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("city", city);
        json.put("health", health);
        json.put("stress", stress);
        json.put("expenses", expenses);
        json.put("historicalExpenses", historicalExpenses);
        return json;
    }
    
    public String toJSONString() {
        return toJSON().toJSONString();
    }
    
}
