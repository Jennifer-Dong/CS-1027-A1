/**
 * 
 * @author rdong26
 *This class represents each city that is loaded in from a text file. It is a simple class that just
 *contains the city's name, x and y coordinates, and a CityMarker icon.
 */
public class City {
	
	private String name;
	private int x;
	private int y;
	private CityMarker marker = new CityMarker();
	
	public City(String name, int x, int y) {
		this.name=name;
		this.x=x;
		this.y=y;
	}
	
	/**
	 * 
	 * @return city name
	 */
	public String getName () {
		return this.name;
	}
	
	/**
	 * 
	 * @return x coordinate
	 */
	public int getX () {
		return this.x;
	}
	
	/**
	 * 
	 * @return y coordinate
	 */
	public int getY () {
		return this.y;
	}
	
	/**
	 * 
	 * @return marker
	 */
	public CityMarker getMarker() {
		return this.marker;
	}
	
	/**
	 * 
	 * @param name sets a name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @param x sets x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @param y sets y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * 
	 * @param marker sets marker
	 */
	public void setMarker(CityMarker marker) {
		this.marker = marker;
	}
	
	/**
	 * @return name
	 */
	public String toString() {
		return this.name;
	}
	
	
}
