package hust.soict.globalict.vntourism.backend.touristattraction.manmadeattraction;

import hust.soict.globalict.vntourism.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.vntourism.backend.rdfconstant.Prefix;
import hust.soict.globalict.vntourism.backend.touristattraction.TouristAttraction;

public class ManmadeAttraction extends TouristAttraction {
    public ManmadeAttraction() {
        super();
    }
    @Override
	public String createSparqlQuery() {
    	//Create a raw file
    	this.createRawTtlFile(ObjectToCollect.OBJECT_MANMADE_ATTRACTION);
		

    	//Create the sparql query using all the attributes
    	String unionQuery="";
		int size= ObjectToCollect.OBJECT_MANMADE_ATTRACTION.length;
		for (int i=0;i<size;++i) {
			if(i==0)unionQuery= unionQuery+ "{?place dbo:wikiPageWikiLink "+ObjectToCollect.OBJECT_MANMADE_ATTRACTION[i]+"}\r\n";
			else unionQuery= unionQuery+ "UNION \r\n"
					+ "{?place dbo:wikiPageWikiLink "+ObjectToCollect.OBJECT_MANMADE_ATTRACTION[i]+"}\r\n";
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
