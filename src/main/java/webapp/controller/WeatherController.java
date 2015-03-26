package webapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import webapp.model.weather.Weather;
import webapp.service.WeatherService;

// http://localhost:8080/Employee/desktop/weather
// http://localhost:8080/Employee/desktop/weather/

@Controller
@RequestMapping("/weather")
public class WeatherController {

	static Log log = LogFactory.getLog(WeatherController.class);
	
	@Autowired
	WeatherService service;
	
	@RequestMapping(value={"", "/"}, method=RequestMethod.GET) // 배열처럼 여러개를 넘길 수 있다
	public String showList(Model model) {
		log.info("##################");
		log.info("### showForm() ###");
		log.info("##################");
		
		return "weather/form";
	}
	
	@RequestMapping(value="/show", method=RequestMethod.POST)
	public String showWeather(Model model, String city) { // 파라미터를 city로 자동 mapping
		log.info("##################");
		log.info("## showWeather() ##");
		log.info("##################");
		log.info("city = " + city);
		
		Weather weather = service.getWeather(city);
		model.addAttribute("weather", weather);
		
		return "weather/weather";
	}
		
}
