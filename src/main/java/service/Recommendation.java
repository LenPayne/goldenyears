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
package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.SummaryList;

/**
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
@Path("/recommendation")
public class Recommendation {

    private final SummaryList summaryList = new SummaryList();

    @GET
    @Produces("application/json; charset=UTF-8")
    public String getAll() {
        return summaryList.toJSONString();
    }

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("/{stress}/{health}/{cost}")
    public String getWeighted(@PathParam("stress") int stress, @PathParam("health") int health, @PathParam("cost") int cost) {
        return summaryList.toJSONString(stress, health, cost);
    }
}
