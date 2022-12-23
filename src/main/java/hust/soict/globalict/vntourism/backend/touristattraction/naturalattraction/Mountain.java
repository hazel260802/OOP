package hust.soict.globalict.vntourism.backend.touristattraction.naturalattraction;

import hust.soict.globalict.vntourism.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.vntourism.backend.rdfconstant.Prefix;

public class Mountain extends NaturalAttraction {
	private String elevation;
	private String prominence;

	public Mountain() {
		super();
		//Each attribute will be initialized with the information we want to query, will be used inside the sparql query. 
		this.elevation = "?place dbo:elevation ?elevation.";
		this.prominence = "?place dbo:prominence ?prominence.";
	}

	public String getElevation() {
		return elevation;
	}

	public String getProminence() {
		return prominence;
	}

	@Override
	public String createSparqlQuery() {
		//Create a raw file
		this.createRawTtlFile(ObjectToCollect.OBJECT_MOUNTAIN);
		
		//Create the sparql query using all the attributes
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_MOUNTAIN + "\r\n"
				+ this.getName() + "\r\n"
				+ this.getComment() + "\r\n"
				+ this.getGeoPoint() + "\r\n"
				+ this.getGeoLat() + "\r\n"
				+ this.getGeoLong() + "\r\n"
				+ this.getLocation() + "\r\n"
				+ this.getCountry() + "\r\n"
				+ this.getElevation() + "\r\n"
				+ this.getProminence() + "\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_MOUNTAIN + "\r\n"
				+ "OPTIONAL {" + this.getName() + "}\r\n"
				+ "OPTIONAL {" + this.getComment() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoPoint() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoLat() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoLong() + "}\r\n"
				+ "OPTIONAL {" + this.getLocation() + "}\r\n"
				+ "OPTIONAL {" + this.getCountry() + "}\r\n"
				+ "OPTIONAL {" + this.getElevation() + "}\r\n"
				+ "OPTIONAL {" + this.getProminence() + "}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
				+ "}";
	}
}
