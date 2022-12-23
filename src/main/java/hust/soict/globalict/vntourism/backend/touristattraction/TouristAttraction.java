package hust.soict.globalict.vntourism.backend.touristattraction;

import hust.soict.globalict.vntourism.backend.dataprocess.IDataProcess;
import hust.soict.globalict.vntourism.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.vntourism.backend.rdfconstant.Prefix;

public class TouristAttraction implements IDataProcess{
	private String name;
	private String comment;
	private String geoPoint;
	private String geoLat;
	private String geoLong;
	private String location;
	private String country;

	public TouristAttraction() {
		//Each attribute will be initialized with the information we want to query, will be used inside the sparql query. 
		this.name = "?place dbp:name ?name.";
		this.comment = "?place rdfs:comment ?comment.";
		this.geoPoint = "?place georss:point ?geoPoint.";
		this.geoLat = "?place geo:lat ?geoLat.";
		this.geoLong = "?place geo:long ?geoLong.";
		this.location = "?place dbo:location ?location.";
		this.country = "?place dbo:country ?country.";
	}

	public String getName() {
		return this.name;
	}

	public String getComment() {
		return this.comment;
	}

	public String getGeoPoint() {
		return this.geoPoint;
	}

	public String getGeoLat() {
		return this.geoLat;
	}

	public String getGeoLong() {
		return this.geoLong;
	}

	public String getLocation() {
		return this.location;
	}

	public String getCountry() {
		return this.country;
	}

	@Override
	public String createSparqlQuery() {
		//Create a raw file
		this.createRawTtlFile(ObjectToCollect.OBJECT_TOURIST_ATTRACTION);
		
		//Create the sparql query using all the attributes
		String unionQuery="";
		int size= ObjectToCollect.OBJECT_TOURIST_ATTRACTION.length;
		for (int i=0;i<size;++i) {
			if(i==0)unionQuery= unionQuery+ "{?place dbo:wikiPageWikiLink "+ObjectToCollect.OBJECT_TOURIST_ATTRACTION[i]+"}\r\n";
			else unionQuery= unionQuery+ "UNION \r\n"
					+ "{?place dbo:wikiPageWikiLink "+ObjectToCollect.OBJECT_TOURIST_ATTRACTION[i]+"}\r\n";
		}
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ this.getName()+"\r\n"
				+ this.getComment()+"\r\n"
				+ this.getGeoPoint()+"\r\n"
				+ this.getGeoLat()+"\r\n"
				+ this.getGeoLong()+"\r\n"
				+ this.getLocation()+"\r\n"
				+ this.getCountry()+"\r\n"
				+ "} WHERE{\r\n"
				+unionQuery
				+ "OPTIONAL {"+ this.getName()+"}\r\n"
				+ "OPTIONAL {"+ this.getComment()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoPoint()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLat()+"}\r\n"
				+ "OPTIONAL {"+ this.getGeoLong()+"}\r\n"
				+ "OPTIONAL {"+ this.getLocation()+"}\r\n"
				+ "OPTIONAL {"+ this.getCountry()+"}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' )\r\n"
				+ "}";
	}
}
