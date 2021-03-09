import java.util.Arrays;

/**
 * 
 * @author rdong26
 *This class represents the array that has been compressed from a matrix (2D array) into a linear
 *array that excludes elements from the diagonal and any elements above or to the right of the
 *diagonal. Only elements below or to the left of the matrix diagonal must be included in the
 *CompressedArray
 */
public class CompressedArray {

	private int origArraySize;
	private double[] array;
	
	/**
	 * 
	 * @param arr --> this is the original array provided
	 */
	public CompressedArray(double[][] arr) {
		this.origArraySize = arr.length;
		int arrSize = (origArraySize*(origArraySize-1))/2;
		this.array = new double[arrSize];
		int i, j, k = 0;
		
		for (i = 0; i < origArraySize; i++) {
			for ( j = 0; j<origArraySize; j++) {
				if (i> j) {
					this.array[k++]=arr[i][j];
				}
			}
		}
	}
	
	/**
	 * 
	 * @return the length of the compressed array
	 */
	public int getLength() {
		int arrSize = (origArraySize*(origArraySize-1))/2;
		return arrSize;
	}
	
	/**
	 * 
	 * @param index is an index of the array 
	 * @return the element at the index
	 */
	public double getElement (int index) {
		return this.array[index];
	}
	
	/**
	 * 
	 * @param arr2 is a given array
	 * @return true if both arrays are identical
	 */
	public boolean equals(CompressedArray arr2) {
		return Arrays.equals(this.array, arr2.array);
	}
	

	public String toString() {
		int counter = 0;
		String matrix = "";
	
		
		for (int i=0; i < this.origArraySize; i++) {
			for (int j = 0; j < this.origArraySize; j++) {
				if (i> j) {
					matrix += String.format("%8.2f", this.array[counter]);
					counter++;
				}
			}
			matrix += "\n";
		}
		return matrix;
	}
}
