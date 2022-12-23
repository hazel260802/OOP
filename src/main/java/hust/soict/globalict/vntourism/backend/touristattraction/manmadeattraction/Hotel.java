package hust.soict.globalict.vntourism.backend.touristattraction.manmadeattraction;

import hust.soict.globalict.vntourism.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.vntourism.backend.rdfconstant.Prefix;

public class Hotel extends ModernArchitecture {

    private String numberOfRestaurants;
    private String numberOfRooms;
    private String architect;

    public Hotel() {
        super();
		//Each attribute will be initialized with the information we want to query, will be used inside the sparql query. 
        this.numberOfRestaurants = "?place dbo:numberOfRestaurants ?numberOfRestaurants.";
        this.numberOfRooms = "?place dbo:numberOfRooms ?numberOfRooms.";
        this.architect = "?place dbo:architect ?architect.";
    }

    public String getNumberOfRestaurants() {
        return this.numberOfRestaurants;
    }

    public String getNumberOfRooms() {
        return this.numberOfRooms;
    }

    public String getArchitect() {
        return this.architect;
    }

    @Override
    public String createSparqlQuery() {
    	//Create a raw file
        this.createRawTtlFile(ObjectToCollect.OBJECT_HOTEL);
        
        //Create the sparql query using all the attributes
        return Prefix.PREFIX + "CONSTRUCT{\r\n"
                + "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_HOTEL + "\r\n"
                + this.getName() + "\r\n"
                + this.getComment() + "\r\n"
                + this.getGeoPoint() + "\r\n"
                + this.getGeoLat() + "\r\n"
                + this.getGeoLong() + "\r\n"
                + this.getLocation() + "\r\n"
                + this.getCountry() + "\r\n"
                + this.getNumberOfRestaurants() + "\r\n"
                + this.getNumberOfRooms() + "\r\n"
                + this.getArchitect() + "\r\n"
                + this.getOpeningDate() + "\r\n"
                + this.getOwner() + "\r\n"
                + "} WHERE{\r\n"
                + "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_HOTEL + "\r\n"
                + "OPTIONAL {" + this.getName() + "}\r\n"
                + "OPTIONAL {" + this.getComment() + "}\r\n"
                + "OPTIONAL {" + this.getGeoPoint() + "}\r\n"
                + "OPTIONAL {" + this.getGeoLat() + "}\r\n"
                + "OPTIONAL {" + this.getGeoLong() + "}\r\n"
                + "OPTIONAL {" + this.getLocation() + "}\r\n"
                + "OPTIONAL {" + this.getCountry() + "}\r\n"
                + "OPTIONAL {" + this.getNumberOfRestaurants() + "}\r\n"
                + "OPTIONAL {" + this.getNumberOfRooms() + "}\r\n"
                + "OPTIONAL {" + this.getArchitect() + "}\r\n"
                + "OPTIONAL {" + this.getOpeningDate() + "}\r\n"
                + "OPTIONAL {" + this.getOwner() + "}\r\n"
                + "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
                + "}";
    }
}
