package hust.soict.globalict.vntourism.backend.touristattraction.naturalattraction;

import hust.soict.globalict.vntourism.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.vntourism.backend.rdfconstant.Prefix;

public class BotanicalGarden extends NaturalAttraction{

    public BotanicalGarden() {
		super();
	}
    @Override
    public String createSparqlQuery() {
    	//Create a raw file
    	this.createRawTtlFile(ObjectToCollect.OBJECT_GARDEN);
    	
    	//Create the sparql query using all the attributes
    	return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ ObjectToCollect.OBJECT_GARDEN + "\r\n"
				+ this.getName()+"\r\n"
				+ this.getComment()+"\r\n"
				+ this.getGeoPoint()+"\r\n"
				+ this.getGeoLat()+"\r\n"
				+ this.getGeoLong()+"\r\n"
				+ this.getLocation()+"\r\n"
				+ this.getCountry()+"\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ ObjectToCollect.OBJECT_GARDEN + "\r\n"
				+ "OPTIONAL {"+ this.getName()+"}\r\n"
				+ "OPTIONAL {"+ this.getComment()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoPoint()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLat()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLong()+"}\r\n"
				+ "OPTIONAL {"+ this.getLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getCountry()+"}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
				+ "}";
	}
}
