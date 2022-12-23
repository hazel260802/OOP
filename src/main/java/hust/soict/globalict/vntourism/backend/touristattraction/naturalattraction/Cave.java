package hust.soict.globalict.vntourism.backend.touristattraction.naturalattraction;

import hust.soict.globalict.vntourism.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.vntourism.backend.rdfconstant.Prefix;

public class Cave extends NaturalAttraction{

	private String depth;
	private String length;
	public String dicovery;
	private String geology;
	private String entrance;
	public Cave() {
		super();
		//Each attribute will be initialized with the information we want to query, will be used inside the sparql query. 
		this.depth="?place dbo:depth ?depth.";
		this.length="?place dbo:length ?length.";
		this.dicovery="?place dbp:discovery ?discover.";
		this.geology="?place dbp:geology ?geology.";
		this.entrance="?place dbp:entranceCount ?entrance.";
	}
	public String getDepth() {
		return depth;
	}
	public String getLength() {
		return length;
	}
	public String getDicovery() {
		return dicovery;
	}
	public String getGeology() {
		return geology;
	}
	public String getEntrance() {
		return entrance;
	}
	@Override
	public String createSparqlQuery() {
		//Create a raw file
		this.createRawTtlFile(ObjectToCollect.OBJECT_CAVE);
		
		//Create the sparql query using all the attributes
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ ObjectToCollect.OBJECT_CAVE + "\r\n"
				+ this.getName()+"\r\n"
				+ this.getComment()+"\r\n"
				+ this.getGeoPoint()+"\r\n"
				+ this.getGeoLat()+"\r\n"
				+ this.getGeoLong()+"\r\n"
				+ this.getLocation()+"\r\n"
				+ this.getCountry()+"\r\n"
				+ this.getDepth()+"\r\n"
				+ this.getLength()+"\r\n"
				+ this.getDicovery()+"\r\n"
				+ this.getGeology()+"\r\n"
				+ this.getEntrance()+"\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink "+ ObjectToCollect.OBJECT_CAVE + "\r\n"
				+ "OPTIONAL {"+ this.getName()+"}\r\n"
				+ "OPTIONAL {"+ this.getComment()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoPoint()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLat()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLong()+"}\r\n"
				+ "OPTIONAL {"+ this.getLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getCountry()+"}\r\n"
				+ "OPTIONAL {"+ this.getDepth()+"}\r\n"
				+ "OPTIONAL {"+ this.getLength()+"}\r\n"
				+ "OPTIONAL {"+ this.getDicovery()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeology()+"}\r\n"
				+ "OPTIONAL {"+ this.getEntrance()+"}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
				+ "}";
	}
}
