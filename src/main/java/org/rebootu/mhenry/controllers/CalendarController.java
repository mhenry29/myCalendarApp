package org.rebootu.mhenry.controllers;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;

import static org.rebootu.mhenry.models.GoogleCalendarAPI.ListEvents;
import static org.rebootu.mhenry.models.GoogleCalendarAPI.createEvent;

/**
 * Created by melissa on 6/14/15.
 */

@Controller
public class CalendarController {

        @RequestMapping (value = "/", method = RequestMethod.GET)
        public String index(Model model) throws IOException {

            //createEvent();

            List<Event> items = ListEvents();

            // create an array of hashmaps with all the information needed to pass to template in place of portfolio
            ArrayList<HashMap<String , String>> eventMaps  = new ArrayList<>();
            HashMap<String, String> hm;

            for (Event event : items) {
                // Create a hash map
                hm = new HashMap();
                DateTime start = event.getStart().getDateTime();
                if (start == null) {
                    start = event.getStart().getDate();
                }
                hm.put("creator",event.getCreator().getDisplayName());
                hm.put("summary", event.getSummary());
                hm.put("start", String.valueOf(start));


                // append hashmap to portfolio array
                eventMaps.add(hm);
            }

        /*if (items.size() == 0) {
                System.out.println("No upcoming events found.");
            } else {
                System.out.println("Upcoming events");
                for (Event event : items) {
                    DateTime start = event.getStart().getDateTime();
                    if (start == null) {
                        start = event.getStart().getDate();
                    }
                    System.out.printf("%s (%s)\n", event.getSummary(), start);
                }
            }*/

            // pass data to template
            //model.addAttribute("name", "Melissa");
            model.addAttribute("events", eventMaps);


            return "index";
        }

    }
