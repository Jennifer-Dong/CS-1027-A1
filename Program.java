/**
 * 
 * @author rdong26
 *This class, as its name suggests, will be the main heart of the program. It will be the entry point
 *of the program, read in a file of cities and create objects for each of them, contain the array of
 *those cities, and create a CompressedArray containing the distances between each of the cities
 *read in from the file.
 */
public class Program {
	
	private int cityCount;
	private City[] cityArray;
	private CompressedArray array;
	
	/**
	 * 
	 * @param file --> this is the file that will be opened
	 * @param showMap --> this tells whether a map will be shown
	 */
	public Program(String file, boolean showMap) {
		this.cityArray = new City[3];
		this.cityCount = 0;
		
		MyFileReader fr = new MyFileReader(file);
		fr.readString();
		
		while (!fr.endOfFile()) {
			String cityName = fr.readString();
			int x = fr.readInt();
			int y = fr.readInt();
			City newCity = new City(cityName, x, y);
			
			if (this.cityArray.length == this.cityCount) {
				expandCapacity();
			}
			this.cityArray[this.cityCount] = newCity;
			this.cityCount++;
		}
		
		if (showMap == true) {
			Map mapObj = new Map();
			for (int i = 0; i < this.cityCount; i++) {
				mapObj.addCity(this.cityArray[i]);
			}
		}
	}
	
	/**
	 * 
	 * @return cityArray
	 */
	public City[] getCityList() {
		return this.cityArray;
	}
	
	private void expandCapacity() {
		City[] newCityArray = new City[this.cityCount+3];
		
		for (int i = 0; i < this.cityCount; i++) {
			newCityArray[i] = this.cityArray[i];
		}
		
		this.cityArray = newCityArray;
	}
		
	/**
	 * 
	 * @param cityA a given city
	 * @param cityB a given city
	 * @return the Euclidean distance between two cities
	 */
	public double distBetweenCities(City cityA, City cityB) {
	
		double xDiff = Math.abs(cityA.getX() - cityB.getX());
		double yDiff = Math.abs(cityA.getY() - cityB.getY());
		double eucDist = Math.sqrt((xDiff*xDiff)+(yDiff*yDiff));
		return eucDist;
		
	}
	

	public void compareDistances() {
		double [][] cityDist = new double[this.cityCount][this.cityCount];
		
		for (int i=0; i<this.cityCount; i++) {
			for (int j=0; j<this.cityCount; j++) {
				cityDist[i][j] = distBetweenCities(this.cityArray[i], this.cityArray[j]);
			}
		}
		this.array = new CompressedArray(cityDist);
	}
	
	/**
	 * 
	 * @return the CompressedArray array
	 */
	public CompressedArray getArray() {
		return this.array;
	}
}
