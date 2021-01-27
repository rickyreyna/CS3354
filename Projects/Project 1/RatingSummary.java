package project1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import  java.lang.Math.*; // We will use it for the average

/**
  Ratings Summary supporting inner and outer statistics of the review 
  @author tesic
  @author tarek
  @author Anthony Meza
  @author Benjamin Nye
  @author Ricardo Reyna
*/

public class RatingSummary extends AbstractRatingSummary{

	/**
	 * Constructor.
	 * 
	 * @param inNodeID
	 * @param inDegree
	 * @param inList
	 */
	public RatingSummary(final String inNodeID, final long inDegree, final List inList) {
		super(inNodeID, inDegree, inList);
	}

	/**
     * Constructor.
	 * I made it like this assuming the constructor above is a hint on how some constructors will be made for this class
	 * 
     * @param inNodeID
     * @param inDegree
     */
    public RatingSummary(final String inNodeID, final long inDegree) {
		super(inNodeID, inDegree);
	}

	/**
     * Constructor.
	 * 
     * @param id        	product/review id
     * @param degree		number of times reviewed
     * @param productAvg    average rating of the product
     * @param productStDev 	standard deviation of the product's rating
     * @param reviewerAvg   average rating of the reviewer
     * @param reviewerStDev standard deviation of the reviewer's ratings
     */
	public RatingSummary(final String id, final long degree, final float productAvg, final float productStDev, final float reviewerAvg, final float reviewerStDev) {
		super(id, degree);
		List<Float> ratingStats = new List<Float>();
		ratingStats = createList(productAvg, productStDev, reviewerAvg, reviewerStDev);
	}

	/**
	 * @param id
	 * @param rawRatings
	 */
	public RatingSummary(final String id, final List<Rating> rawRatings) {
		super(id);
		List<Rating> newRawRatings = new List<Rating> (rawRatings);


	}
	
	public void setList() {
		super.setList(createList());
	}
	
	public void setList(float productAvg, float productStDev, float reviewerAvg, float reviewerStDev) {
		super.setList(this.createList(productAvg, productStDev, reviewerAvg, reviewerStDev));
	}

	@Override
	public List<Float> createList(){
		return new ArrayList<Float>();
	}

	/**
	 * @param productAvg
	 * @param productStDev
	 * @param reviewerAvg
	 * @param reviewerStDev
	 * @return List of object Float
	 */
	public List<Float> createList(float productAvg, float productStDev, float reviewerAvg, float reviewerStDev) {
		Float newProductAvg = productAvg;
		Float newProductStDev = productStDev;
		Float newReviewerAvg = reviewerAvg;
		Float newReviewerStDev = reviewerStDev;
		List<Float> newList = new List<Float>();
		newList.add(newProductAvg);
		newList.add(newProductStDev);
		newList.add(newReviewerAvg);
		newList.add(newReviewerStDev);
	
		return newList; 
	}


	/**
	 * Prints RatingSummary object as form Id,degree,product avg,product st.dev,reviewer avg,reviewer st.dev\n
	 */
	@Override
	public String toString(){
		// IMPLEMENT METHOD ***************************************************************************************************************************************************************
		

		return "test"; // Added the following code just to be able to compile&run:
	}

	private String printStats() {
		// TODO Auto-generated method stub *****************************************************************************
		String statistics = ""; 
		for(int i = 0; i < this.getList().size(); ++i){
			statistics = statistics + this.getList().get(i);
		}
		return statistics;
	}

	/**
	 * collect the list that keeps statistics 
	 * Make sure the object was initialized 
	 */
	@Override
	public void collectStats(final List<Rating> rawRatings){
		if(this.getNodeID().startsWith("A")) {
			collectReviewerStats(rawRatings);
		}
		else if(this.getNodeID().startsWith("B")) {
			collectProductStats(rawRatings);
		}
		else {
			System.out.println("There's something wrong with the Node ID");
		}

	}

	/**
	 * Collects product stats for nodeID -- never call this function directly, only through collectStats
	 * @param rawRatings
	 */
	public void collectProductStats(final List<Rating> rawRatings) {
		List<Rating> collectProduct = new List<Rating> ();
		//List<Rating> collectProduct = rawRatings.stream().filter(r -> r.getProductID().equals(this.getNodeID().collect(Collectors.toList())));
		for(Rating r : rawRatings) {
			if(r.getProductID().equals(this.getNodeID())){
				collectProduct.add(r);
			}

		}/*
		for(int i = 0; i < rawRatings.size(); ++i) {
			if(rawRatings.get(i).getProductID().equals(this.getNodeID())){
				collectProduct.add(rawRatings.get(i));
			}
		
		}	*/// IMPLEMENT METHOD ***************************************************************************************************************************************************************

	}

	/**
	 * Collects product stats for nodeID -- never call this function directly, only through collectStats
	 * @param rawRatings
	 */
	public void collectReviewerStats(final List<Rating> rawRatings) {
				// IMPLEMENT METHOD ***************************************************************************************************************************************************************
	
	}

	////////// Statistics block

	/** 
	 * @return sort by biggest difference between product and review average in collection 
	 */
	public Float avgScore(){
		// IMPLEMENT METHOD ***************************************************************************************************************************************************************
		Float test = null; // Added this just to be able to compile&run
		return test; // Added this just to be able to compile&run
	}

	/** 
	 * @return sort by biggest difference between product and review st.dev. in collection   
	 */
	public Float stDevScore(){
		// IMPLEMENT METHOD ***************************************************************************************************************************************************************
		Float test = null; // Added this just to be able to compile&run
		return test; // Added this just to be able to compile&run
	}

	/** 
	 * @return summary of statistics as key to sorting the rating summaries 
	 */
	public Float sortStats(){
		// IMPLEMENT METHOD ***************************************************************************************************************************************************************
		Float test = null; // Added this just to be able to compile&run
		return test; // Added this just to be able to compile&run
	}

   //add methods if needed

}
