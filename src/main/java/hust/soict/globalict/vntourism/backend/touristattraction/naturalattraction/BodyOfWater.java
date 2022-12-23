package hust.soict.globalict.vntourism.backend.touristattraction.naturalattraction;

import hust.soict.globalict.vntourism.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.vntourism.backend.rdfconstant.Prefix;

public class BodyOfWater extends NaturalAttraction {
	private String length;

	public BodyOfWater() {
		super();
		//Each attribute will be initialized with the information we want to query, will be used inside the sparql query. 
		this.length = "?place dbo:length ?length.";
	}

	public String getLength() {
		return this.length;
	}
	@Override
	public String createSparqlQuery() {
		//Create a raw file
		this.createRawTtlFile(ObjectToCollect.OBJECT_BODY_OF_WATER);
		
		//Create the sparql query using all the attributes
		String unionQuery="";
		int size= ObjectToCollect.OBJECT_BODY_OF_WATER.length;
		for (int i=0;i<size;++i) {
			if(i==0)unionQuery= unionQuery+ "{?place dbo:wikiPageWikiLink "+ObjectToCollect.OBJECT_BODY_OF_WATER[i]+"}\r\n";
			else unionQuery= unionQuery+ "UNION \r\n"
					+ "{?place dbo:wikiPageWikiLink "+ObjectToCollect.OBJECT_BODY_OF_WATER[i]+"}\r\n";
		}
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ this.getName()+"\r\n"
				+ this.getComment()+"\r\n"
				+ this.getGeoPoint()+"\r\n"
				+ this.getGeoLat()+"\r\n"
				+ this.getGeoLong()+"\r\n"
				+ this.getLocation()+"\r\n"
				+ this.getCountry()+"\r\n"
				+ this.getLength()+"\r\n"
				+ "} WHERE{\r\n"
				+unionQuery
				+ "OPTIONAL {"+ this.getName()+"}\r\n"
				+ "OPTIONAL {"+ this.getComment()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoPoint()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLat()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLong()+"}\r\n"
				+ "OPTIONAL {"+ this.getLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getCountry()+"}\r\n"
				+ "OPTIONAL {"+ this.getLength()+"}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' )\r\n"
				+ "}";
	}
}
