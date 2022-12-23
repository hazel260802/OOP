package hust.soict.globalict.vntourism.backend.touristattraction.naturalattraction;

import hust.soict.globalict.vntourism.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.vntourism.backend.rdfconstant.Prefix;

public class River extends BodyOfWater {
	
	private String sourceLocation;
	private String mouthLocation;
	private String mouthElevation;
	private String dischargeLocation;
	private String tributariesLeft;
	private String tributariesRight;

	public River() {
		super();
		//Each attribute will be initialized with the information we want to query, will be used inside the sparql query. 
		this.sourceLocation = "?place dbp:source1Location  ?sourceLocation.";
		this.mouthLocation = "?place dbo:mouthPlace ?mouthLocation.";
		this.mouthElevation = "?place dbo:mouthElevation ?mouthElevation.";
		this.dischargeLocation = "?place dbp:discharge1Location ?dischargeLocation.";
		this.tributariesLeft = "?place dbp:tributariesLeft ?tributariesLeft.";
		this.tributariesRight = "?place dbp:tributariesRight ?tributariesRight.";
	}

	public String getSourceLocation() {
		return sourceLocation;
	}

	public String getMouthLocation() {
		return mouthLocation;
	}

	public String getMouthElevation() {
		return mouthElevation;
	}

	public String getDischargeLocation() {
		return dischargeLocation;
	}

	public String getTributariesLeft() {
		return tributariesLeft;
	}

	public String getTributariesRight() {
		return tributariesRight;
	}
	
	@Override
	public String createSparqlQuery() {
		//Create a raw file
		this.createRawTtlFile(ObjectToCollect.OBJECT_RIVER);
		
		//Create the sparql query using all the attributes
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ ObjectToCollect.OBJECT_RIVER + "\r\n"
				+ this.getName()+"\r\n"
				+ this.getComment()+"\r\n"
				+ this.getGeoPoint()+"\r\n"
				+ this.getGeoLat()+"\r\n"
				+ this.getGeoLong()+"\r\n"
				+ this.getLocation()+"\r\n"
				+ this.getCountry()+"\r\n"
				+ this.getLength()+"\r\n"
				+ this.getSourceLocation()+"\r\n"
				+ this.getMouthLocation()+"\r\n"
				+ this.getMouthElevation()+"\r\n"
				+ this.getDischargeLocation()+"\r\n"
				+ this.getTributariesLeft()+"\r\n"
				+ this.getTributariesRight()+"\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ ObjectToCollect.OBJECT_RIVER + "\r\n"
				+ "OPTIONAL {"+ this.getName()+"}\r\n"
				+ "OPTIONAL {"+ this.getComment()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoPoint()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLat()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLong()+"}\r\n"
				+ "OPTIONAL {"+ this.getLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getCountry()+"}\r\n"
				+ "OPTIONAL {"+ this.getLength()+"}\r\n"
				+ "OPTIONAL {"+ this.getSourceLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getMouthLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getMouthElevation()+"}\r\n"
				+ "OPTIONAL {"+ this.getDischargeLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getTributariesLeft()+"}\r\n"
				+ "OPTIONAL {"+ this.getTributariesRight()+"}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
				+ "}";
	}
}
