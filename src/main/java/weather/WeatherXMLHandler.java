package weather;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherXMLHandler extends DefaultHandler {
	private List<Station> stationList = null;
	private Station station = null;

	public List<Station> getStationList() {
		return stationList;
	}
	
	boolean bName = false;
	boolean bWmocode = false;
	boolean bLongitude = false;
	boolean bLatitude = false;
	boolean bPhenomenon = false;
	boolean bVisibility = false;
	boolean bPrecipitations = false;
	boolean bAirpressure = false;
	boolean bRelativehumidity = false;
	boolean bAirtemperature = false;
	boolean bWinddirection = false;
	boolean bWindspeed = false;
	boolean bWindspeedmax = false;
	boolean bWaterlevel = false;
	boolean bWaterlevel_eh2000 = false;
	boolean bWatertemperature = false;
	boolean bUvindex = false;
	
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("station")) {
            //create a new station and put it in Map
            station = new Station();
            if (stationList == null)
                stationList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("name")) {
            //set boolean values for fields, will be used in setting station variables
            bName = true;
        } else if (qName.equalsIgnoreCase("wmocode")) {
            bWmocode = true;
        } else if (qName.equalsIgnoreCase("longitude")) {
            bLongitude = true;
        } else if (qName.equalsIgnoreCase("latitude")) {
            bLatitude = true;
        } else if (qName.equalsIgnoreCase("phenomenon")) {
        	bPhenomenon = true;
        } else if (qName.equalsIgnoreCase("visibility")) {
        	bVisibility = true;
        } else if (qName.equalsIgnoreCase("precipitations")) {
        	bPrecipitations = true;
        } else if (qName.equalsIgnoreCase("airpressure")) {
        	bAirpressure = true;
        } else if (qName.equalsIgnoreCase("relativehumidity")) {
        	bRelativehumidity = true;
        } else if (qName.equalsIgnoreCase("airtemperature")) {
        	bAirtemperature = true;
        } else if (qName.equalsIgnoreCase("winddirection")) {
        	bWinddirection = true;
        } else if (qName.equalsIgnoreCase("windspeed")) {
        	bWindspeed = true;
        } else if (qName.equalsIgnoreCase("windspeedmax")) {
        	bWindspeedmax = true;
        } else if (qName.equalsIgnoreCase("waterlevel")) {
        	bWaterlevel = true;
        } else if (qName.equalsIgnoreCase("waterlevel_eh2000")) {
        	bWaterlevel_eh2000 = true;
        } else if (qName.equalsIgnoreCase("watertemperature")) {
        	bWatertemperature = true;
        } else if (qName.equalsIgnoreCase("uvindex")) {
        	bUvindex = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("station")) {
            //add station object to list
            stationList.add(station);
            
            //Calculate wind chill if possible
            if (station.getAirtemperature() != null && station.getWindspeed() != null) {
            	station.setWindchill(this.calculateWindchill(station.getAirtemperature(), station.getWindspeed()));
            }
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bName) {
            //age element, set Employee age
            station.setName(new String(ch, start, length));
            bName = false;
        } else if (bWmocode) {
            station.setWmocode(new String(ch, start, length));
            bWmocode = false;
        } else if (bLongitude) {
            station.setLongitude(getDouble(new String(ch, start, length)));
            bLongitude = false;
        } else if (bLatitude) {
            station.setLatitude(getDouble(new String(ch, start, length)));
            bLatitude = false;
        } else if (bPhenomenon) {
            station.setPhenomenon(new String(ch, start, length));
            bPhenomenon = false;
        } else if (bVisibility) {
            station.setVisibility(getDouble(new String(ch, start, length)));
            bVisibility = false;
        } else if (bPrecipitations) {
            station.setPrecipitations(getDouble(new String(ch, start, length)));
            bPrecipitations = false;
        } else if (bAirpressure) {
            station.setAirpressure(getDouble(new String(ch, start, length)));
            bAirpressure = false;
        } else if (bRelativehumidity) {
            station.setRelativehumidity(getInteger(new String(ch, start, length)));
            bRelativehumidity = false;
        } else if (bAirtemperature) {
            station.setAirtemperature(getDouble(new String(ch, start, length)));
            bAirtemperature = false;
        } else if (bWinddirection) {
            station.setWinddirection(getInteger(new String(ch, start, length)));
            bWinddirection = false;
        } else if (bWindspeed) {
            station.setWindspeed(getDouble(new String(ch, start, length)));
            bWindspeed = false;
        } else if (bWindspeedmax) {
            station.setWindspeedmax(getDouble(new String(ch, start, length)));
            bWindspeedmax = false;
        } else if (bWaterlevel) {
            station.setWaterlevel(getInteger(new String(ch, start, length)));
            bWaterlevel = false;
        } else if (bWaterlevel_eh2000) {
            station.setWaterlevel_eh2000(getInteger(new String(ch, start, length)));
            bWaterlevel_eh2000 = false;
        } else if (bWatertemperature) {
            station.setWatertemperature(getDouble(new String(ch, start, length)));
            bWatertemperature = false;
        } else if (bUvindex) {
            station.setUvindex(getInteger(new String(ch, start, length)));
            bUvindex = false;
        }
    }
    
    private Double getDouble(String str) {
    	if (str == null || str.trim().length() == 0) 
    		return null;
    	return Double.valueOf(str);
    }
    
    private Integer getInteger(String str) {
    	if (str == null || str.trim().length() == 0) 
    		return null;
    	return Integer.valueOf(str);
    }
    
    private Double calculateWindchill(Double airtemperature, Double windspeed) {
    	return 13.12 + 0.6215*airtemperature - 11.37*Math.pow(windspeed, 0.16) + 0.3965*airtemperature*Math.pow(windspeed, 0.16);
    }

}
