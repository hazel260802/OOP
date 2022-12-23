package hust.soict.globalict.vntourism.backend.touristattraction.naturalattraction;

import hust.soict.globalict.vntourism.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.vntourism.backend.rdfconstant.Prefix;

public class NationalPark extends NaturalAttraction {

    private String areaTotal;
    private String nearestCity;
    private String established;
    private String governingBody;

    public NationalPark() {
        super();
		//Each attribute will be initialized with the information we want to query, will be used inside the sparql query. 
        this.areaTotal = "?place dbo:areaTotal ?areaTotal.";
        this.nearestCity = "?place dbo:nearestCity ?nearestCity.";
        this.established = "?place dbo:established ?established.";
        this.governingBody = "?place dbo:governingBody ?governingBody.";
    }

    public String getAreaTotal() {
        return this.areaTotal;
    } 
    
    public String getNearestCity() {
        return this.nearestCity;
    }

    public String getEstablished() {
        return this.established;
    }

    public String getGoverningBody() {
        return this.governingBody;
    }

    @Override
    public String createSparqlQuery() {
    	//Create a raw file
        this.createRawTtlFile(ObjectToCollect.OBJECT_NATIONALPARK);
        
        //Create the sparql query using all the attributes
        return Prefix.PREFIX + "CONSTRUCT{\r\n"
                + "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_NATIONALPARK + "\r\n"
                + this.getName() + "\r\n"
                + this.getComment() + "\r\n"
                + this.getGeoPoint() + "\r\n"
                + this.getGeoLat() + "\r\n"
                + this.getGeoLong() + "\r\n"
                + this.getLocation() + "\r\n"
                + this.getCountry() + "\r\n"
                + this.getAreaTotal() + "\r\n"
                + this.getNearestCity() + "\r\n"
                + this.getEstablished() + "\r\n"
                + this.getGoverningBody() + "\r\n"
                + "} WHERE{\r\n"
                + "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_NATIONALPARK + "\r\n"
                + "OPTIONAL {" + this.getName() + "}\r\n"
                + "OPTIONAL {" + this.getComment() + "}\r\n"
                + "OPTIONAL {" + this.getGeoPoint() + "}\r\n"
                + "OPTIONAL {" + this.getGeoLat() + "}\r\n"
                + "OPTIONAL {" + this.getGeoLong() + "}\r\n"
                + "OPTIONAL {" + this.getLocation() + "}\r\n"
                + "OPTIONAL {" + this.getCountry() + "}\r\n"
                + "OPTIONAL {" + this.getAreaTotal() + "}\r\n"
                + "OPTIONAL {" + this.getNearestCity() + "}\r\n"
                + "OPTIONAL {" + this.getEstablished() + "}\r\n"
                + "OPTIONAL {" + this.getGoverningBody() + "}\r\n"
                + "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
                + "}";
    }
}
