package it.experis.service.controller;


import it.experis.service.bean.EventList;
import it.experis.service.bean.ResourceList;
import it.experis.service.ds.CalendarDS;

import org.springframework.http.ResponseEntity;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;





@Controller
public class CalendarController {
 
    private CalendarDS calendarDS;

    private Jaxb2Marshaller jaxb2Mashaller;
     
    
     
    @RequestMapping(method=RequestMethod.GET, value="/resources")
    public ModelAndView getResources() {
    	ResourceList list = new ResourceList(calendarDS.getAllResources());
        return new ModelAndView("resourceView", "resourceList", list);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/resources/json", produces="application/json")
    @ResponseBody
	public ResourceList getResourcesInJSON(@RequestParam("key") String key, @RequestParam("date_from") String date_from, @RequestParam("date_to") String date_to) {
    	ResourceList list = new ResourceList(calendarDS.getAllResources());
		return list;
		/*		if(list.getCount()==0)
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<String>(json,HttpStatus.OK);
		 */
	}
     
    @RequestMapping(method=RequestMethod.GET, value="/events")
    public ModelAndView getEvents() {
    	EventList list = new EventList(calendarDS.getAllEvents());
        return new ModelAndView("eventView", "eventList", list);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/event/{key}")
    public ModelAndView getEventDetail(@PathVariable String key) {
    	EventList l = new EventList(calendarDS.getEventDetail(key));
        return new ModelAndView("eventView", "eventList", l);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/events/json", produces="application/json")
    @ResponseBody
	public EventList getEventsInJSON(@RequestParam("key") String key, @RequestParam("start") String start, @RequestParam("end") String end, @RequestParam("lav_list") String lav_list) {
    	EventList list = new EventList(calendarDS.getAllEvents());
		return list;
		/*		if(list.getCount()==0)
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<String>(json,HttpStatus.OK);
		 */
	}
    
    @RequestMapping(method=RequestMethod.GET, value="/planner/json", produces="application/json")
    @ResponseBody
	public ResponseEntity<String> getPianificationInJSON(@RequestParam("lavoratoreSorg") String lavoratoreSorg,
			                                      @RequestParam("lavoratoreDest") String lavoratoreDest,
			                                      @RequestParam("turni") String turni,
			                                      @RequestParam("attivita") String attivita) {
		return null;
	}
    
    

	public Jaxb2Marshaller getJaxb2Mashaller() {
		return jaxb2Mashaller;
	}

	public void setJaxb2Mashaller(Jaxb2Marshaller jaxb2Mashaller) {
		this.jaxb2Mashaller = jaxb2Mashaller;
	}

	public CalendarDS getCalendarDS() {
		return calendarDS;
	}

	public void setCalendarDS(CalendarDS calendarDS) {
		this.calendarDS = calendarDS;
	}

}