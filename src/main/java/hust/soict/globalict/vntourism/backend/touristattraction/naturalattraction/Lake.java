package hust.soict.globalict.vntourism.backend.touristattraction.naturalattraction;

import hust.soict.globalict.vntourism.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.vntourism.backend.rdfconstant.Prefix;

public class Lake extends BodyOfWater {
	private String lakeType;

	public Lake() {
		super();
		//Each attribute will be initialized with the information we want to query, will be used inside the sparql query. 
		this.lakeType = "?place dbo:type ?lakeType.";
	}

	public String getLakeType() {
		return lakeType;
	}

	@Override
	public String createSparqlQuery() {
		//Create a raw file
		this.createRawTtlFile(ObjectToCollect.OBJECT_LAKE);
		
		//Create the sparql query using all the attributes
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ObjectToCollect.OBJECT_LAKE+"\r\n"
				+ this.getName()+"\r\n"
				+ this.getComment()+"\r\n"
				+ this.getGeoPoint()+"\r\n"
				+ this.getGeoLat()+"\r\n"
				+ this.getGeoLong()+"\r\n"
				+ this.getLocation()+"\r\n"
				+ this.getCountry()+"\r\n"
				+ this.getLength()+"\r\n"
				+ this.getLakeType()+"\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ObjectToCollect.OBJECT_LAKE+"\r\n"
				+ "OPTIONAL {"+ this.getName()+"}\r\n"
				+ "OPTIONAL {"+ this.getComment()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoPoint()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLat()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLong()+"}\r\n"
				+ "OPTIONAL {"+ this.getLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getCountry()+"}\r\n"
				+ "OPTIONAL {"+ this.getLength()+"}\r\n"
				+ "OPTIONAL {"+ this.getLakeType()+"}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' )\r\n"
				+ "}";
	}
}
