package weather;

public class Station {
	private String name;
	private String wmocode;
	private Double longitude;
	private Double latitude;
	private String phenomenon;
	private Double visibility;
	private Double precipitations;
	private Double airpressure;
	private Integer relativehumidity;
	private Double airtemperature;
	private Double windchill;
	private Integer winddirection;
	private Double windspeed;
	private Double windspeedmax;
	private Integer waterlevel;
	private Integer waterlevel_eh2000;
	private Double watertemperature;
	private Integer uvindex;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWmocode() {
		return wmocode;
	}
	public void setWmocode(String wmocode) {
		this.wmocode = wmocode;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getPhenomenon() {
		return phenomenon;
	}
	public void setPhenomenon(String phenomenon) {
		this.phenomenon = phenomenon;
	}
	public Double getVisibility() {
		return visibility;
	}
	public void setVisibility(Double visibility) {
		this.visibility = visibility;
	}
	public Double getPrecipitations() {
		return precipitations;
	}
	public void setPrecipitations(Double precipitations) {
		this.precipitations = precipitations;
	}
	public Double getAirpressure() {
		return airpressure;
	}
	public void setAirpressure(Double airpressure) {
		this.airpressure = airpressure;
	}
	public Integer getRelativehumidity() {
		return relativehumidity;
	}
	public void setRelativehumidity(Integer relativehumidity) {
		this.relativehumidity = relativehumidity;
	}
	public Double getAirtemperature() {
		return airtemperature;
	}
	public void setAirtemperature(Double airtemperature) {
		this.airtemperature = airtemperature;
	}
	public Double getWindchill() {
		return windchill;
	}
	public void setWindchill(Double windchill) {
		this.windchill = windchill;
	}
	public Integer getWinddirection() {
		return winddirection;
	}
	public void setWinddirection(Integer winddirection) {
		this.winddirection = winddirection;
	}
	public Double getWindspeed() {
		return windspeed;
	}
	public void setWindspeed(Double windspeed) {
		this.windspeed = windspeed;
	}
	public Double getWindspeedmax() {
		return windspeedmax;
	}
	public void setWindspeedmax(Double windspeedmax) {
		this.windspeedmax = windspeedmax;
	}
	public Integer getWaterlevel() {
		return waterlevel;
	}
	public void setWaterlevel(Integer waterlevel) {
		this.waterlevel = waterlevel;
	}
	public Integer getWaterlevel_eh2000() {
		return waterlevel_eh2000;
	}
	public void setWaterlevel_eh2000(Integer waterlevel_eh2000) {
		this.waterlevel_eh2000 = waterlevel_eh2000;
	}
	public Double getWatertemperature() {
		return watertemperature;
	}
	public void setWatertemperature(Double watertemperature) {
		this.watertemperature = watertemperature;
	}
	public Integer getUvindex() {
		return uvindex;
	}
	public void setUvindex(Integer uvindex) {
		this.uvindex = uvindex;
	}
	
    @Override
    public String toString() {
        return "Station:: Name="+this.name+
        		" \r\nLongitude=" + this.longitude + 
        		" \r\nLatitude=" + this.latitude + 
        		" \r\nAir temperature=" + this.airtemperature +
        		" \r\nWind chill=" + this.windchill +
                " \r\nPhenomenon=" + this.phenomenon + "\n" +
                " \r\nVisibility=" + this.visibility + "\n" +
                " \r\nPrecipitations=" + this.precipitations + "\n" +
                " \r\nAirpressure=" + this.airpressure + "\n" +
                " \r\nRelativehumidity=" + this.relativehumidity + "\n" +
                " \r\nAirtemperature=" + this.airtemperature + "\n" +
                " \r\nWinddirection=" + this.winddirection + "\n" +
                " \r\nWindspeed=" + this.windspeed + "\n" +
                " \r\nWindspeedmax=" + this.windspeedmax + "\n" +
                " \r\nWaterlevel=" + this.waterlevel + "\n" +
                " \r\nWaterlevel_eh2000=" + this.waterlevel_eh2000 + "\n" +
                " \r\nWatertemperature=" + this.watertemperature + "\n" +
                " \r\nUvindex=" + this.uvindex + "\n";
    }
    
}
