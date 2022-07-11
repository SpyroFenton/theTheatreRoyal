package util;

public enum CollectionID {
	BoxOffice(0.00), 
	Post(1.00),
	PrintAtHome(0.00); 
	
	public final double collectionID;
	
	CollectionID(double collectionID) {
		this.collectionID = collectionID;
	}
}