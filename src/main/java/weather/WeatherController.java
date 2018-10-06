package weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

@RestController
public class WeatherController {

    @RequestMapping("/weather")
    public String index(@RequestParam(value="station", defaultValue="All") String station) {
		String urlStr = "http://www.ilmateenistus.ee/ilma_andmed/xml/observations.php";
    	StringBuffer results = new StringBuffer();
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	    
		try {
	    	URL url = new URL(urlStr);
	    	
	    	HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
	        httpcon.addRequestProperty("User-Agent", "Mozilla/4.0");
	        
	        SAXParser saxParser = saxParserFactory.newSAXParser();
	        WeatherXMLHandler handler = new WeatherXMLHandler();
	        saxParser.parse(httpcon.getInputStream(), handler);
	        
	        List<Station> stationList = handler.getStationList();
	        
	        if (stationList == null) {
	        	return "EMPTY LIST";
	        }
	        
	        for(Station stat : stationList) {
	        	if (station.equals(stat.getName()) || station.equals("All"))
	        		results.append(stat);
	        }
	        
	        return results.toString();
	    } catch (ParserConfigurationException | SAXException | IOException e) {
	        return e.getMessage();
	    }
	            
    }

    private static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}

}    	 
