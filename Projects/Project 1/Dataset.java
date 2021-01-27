package project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


/**
  Dataset

  
 
  @author tesic

  @author Anthony Meza
  @author Benjamin Nye
  @author Ricardo Reyna
*/


public class Dataset {
	
	/**
	 * @param dataId
	 * @param nameOfFile
	 * @param numberOfRatings
	 */
	public Dataset(String dataId, Path nameOfFile, long numberOfRatings) {
		this.dataId = dataId;
		this.rawFile = nameOfFile;
		this.numberOfRatings = numberOfRatings;
		this.ratingList = new ArrayList<Rating>();
		this.ratingStat = new ArrayList<AbstractRatingSummary>(); 
	}

	/**
	 * @param dataId
	 * @param inRawFile
	 * @throws IOException
	 */
	public Dataset(String dataId, Path inRawFile) throws IOException {

		this.dataId = dataId;
		this.rawFile = inRawFile;
		this.numberOfRatings = Files.lines(inRawFile).count();
		this.ratingList = new ArrayList<Rating>();
		this.ratingStat = new ArrayList<AbstractRatingSummary>(); 
	}

	/**
	 * @return number of ratings 
	 * @throws IOException
	 */
	public int loadRatings() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(this.getRawFile().toFile()));
        String line;
        while((line = br.readLine()) != null) {
		  String[] tempArr = line.split(DataAnalysis.DELIMITER);
		  Rating r = new Rating(tempArr[0],tempArr[1],Float.parseFloat(tempArr[2]));
		   this.ratingList.add(r);
        }
		br.close();
		return this.ratingList.size();
	}

	/**
	 * @param inStatPath
	 * @return
	 * @throws IOException
	 */
	public int loadStats(Path inStatPath) throws IOException {
		//load stats if file exists
		BufferedReader brs = new BufferedReader(new FileReader(inStatPath.toFile()));
		String line; 
		// reading first line with the column name
		 brs.readLine();
		
		while((line = brs.readLine()) != null) {

			final String[] tempArr = line.split(DataAnalysis.DELIMITER);
			final int len = tempArr.length;

			if (len>5){
				RatingSummary rs = new RatingSummary(tempArr[0],Long.getLong(tempArr[1]));
				rs.createList(Float.valueOf(tempArr[2]), Float.valueOf(tempArr[3]), Float.valueOf(tempArr[4]),Float.valueOf(tempArr[5]));
				this.ratingStat.add(rs);
			}
		}
        brs.close();
        return this.ratingStat.size();
	}


	
	
	public boolean computeStats(){
		//do not append, start from scratch
		// IMPLEMENT METHOD ******************************************************************************
		return true; // Added this just to be able to compile&run

	}


	public String saveStats(){

		String statString = ""; 
		//writing a rating summary in each line
		for (AbstractRatingSummary rs : this.getRatingStat()) {
			statString += rs.toString();
		}
		return statString;
	}

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	public Path getRawFile() {
		return this.rawFile;
	}

	public long getNumberOfRatings() {
		return numberOfRatings;
	}

	public void setNumberOfRatings(long numberOfRatings) {
		this.numberOfRatings = numberOfRatings;
	}

	public int statsExist(){
		return ratingStat.size();
	}

	public List<Rating> getRatingList(){
		return this.ratingList;
	}
	
	public List<AbstractRatingSummary> getRatingStat(){
		return this.ratingStat;
	}


	public void setRatingSummary(List<AbstractRatingSummary> ratingSummary) {
		this.ratingStat = ratingSummary;
	} 

	@Override
	public String toString(){
		//"dataID,RAW_FILE,RATINGS_NO,STAT_FILE\n";
		return (this.getDataId()+","+this.getRawFile().toString()+","+this.getNumberOfRatings()+",");	
	}

	private String dataId;
	private Path rawFile;
	private long numberOfRatings;
	private List<Rating> ratingList;
	private List<AbstractRatingSummary> ratingStat;
}
