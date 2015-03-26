package webapp.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.springframework.stereotype.Service;

import webapp.exception.JDOMRuntimeException;
import webapp.exception.UrlRuntimeException;
import webapp.model.weather.Current;
import webapp.model.weather.Forecast;
import webapp.model.weather.Weather;

@Service
public class WeatherService {
	
	static Log log = LogFactory.getLog(WeatherService.class);
	SAXBuilder jdom = new SAXBuilder();
	Weather w;
	
	String url = "http://weather.service.msn.com/data.aspx?culture=ko-KR&weasearchstr=";
		
	Current getCurrent(Element current) {
		
		Current c = new Current();
		c.setTemperature(Integer.parseInt(current.getAttributeValue("temperature")));
		c.setSkycode(current.getAttributeValue("skycode"));
		c.setSkytext(current.getAttributeValue("skytext"));
		
		SimpleDateFormat df = new SimpleDateFormat("yyy-MM-dd");
		try {
			c.setDate(df.parse(current.getAttributeValue("date")));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		c.setObservationtime(current.getAttributeValue("observationtime"));
		c.setObservationpoint(current.getAttributeValue("observationpoint"));
		c.setFeelslike(current.getAttributeValue("feelslike"));
		c.setHumidity(current.getAttributeValue("humidity"));
		c.setWinddisplay(current.getAttributeValue("winddisplay"));
		c.setDay(current.getAttributeValue("day"));
		c.setShortday(current.getAttributeValue("shortday"));
		c.setWindspeed(current.getAttributeValue("windspeed"));
		
		return c;
	}
	
	List<Forecast> getForecasts(Element weather) {
		
		List<Forecast> list = new ArrayList<Forecast>();		
		List<Element> ws = weather.getChildren("forecast");
		
		for(Element e : ws) {
			Forecast f = new Forecast();
			
			Integer	low = Integer.parseInt(e.getAttributeValue("low"));
			Integer	high = Integer.parseInt(e.getAttributeValue("high"));
			String 	skycodeday = e.getAttributeValue("skycodeday"); 
			String 	skytextday = e.getAttributeValue("skytextday"); 
			
			SimpleDateFormat df = new SimpleDateFormat("yyy-mm-dd");
			Date 	date = null; 
			try {
				date = df.parse(e.getAttributeValue("date"));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			String 	day = e.getAttributeValue("day");
			String 	shortday = e.getAttributeValue("shortday"); 
			Integer precip = Integer.parseInt(e.getAttributeValue("precip"));
			
			f.setLow(low);
			f.setHigh(high);
			f.setSkycodeday(skycodeday);
			f.setSkytextday(skytextday);
			f.setDate(date);
			f.setDay(shortday);
			f.setShortday(shortday);
			f.setPrecip(precip);
			
			list.add(f);
		}
		
		return list;
	}
	 
	public Weather getWeather(String city) {
		
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		log.info("getWeather() city = " + city);
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		String urlCity = url + city;
		
		try {
			URL u = new URL(urlCity);
			InputStream in = u.openStream();
			Document doc = jdom.build(in);
			
			Element weatherdata = doc.getRootElement(); // root -> weatherdata
			Element weather = weatherdata.getChild("weather"); // -> weather
			Element current = weather.getChild("current");
			
			w = new Weather();
			Current c = getCurrent(current);
			List<Forecast> forecast = getForecasts(weather);
			
			w.setCurrent(c);
			w.setForecast(forecast);
			
			log.info("skytext : " + c.getSkytext());
			log.info("date : " + c.getDate());
			log.info("windspeed : " + c.getWindspeed());
			
			XMLOutputter output = new XMLOutputter();
			output.setFormat(Format.getPrettyFormat());
			output.output(doc, System.out);
			
		} catch (IOException e) {
			throw new UrlRuntimeException(urlCity, e);
		} catch (JDOMException e) {
			throw new JDOMRuntimeException("build error...", e);
		}
		
		
		return w;
	}

}
