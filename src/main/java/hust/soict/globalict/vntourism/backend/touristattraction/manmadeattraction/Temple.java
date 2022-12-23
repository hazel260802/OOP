package hust.soict.globalict.vntourism.backend.touristattraction.manmadeattraction;

import hust.soict.globalict.vntourism.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.vntourism.backend.rdfconstant.Prefix;

public class Temple extends ManmadeAttraction{

    private String religiousAffiliation;
    private String deity;
    private String architecture;

    public Temple() {
    	super();
		//Each attribute will be initialized with the information we want to query, will be used inside the sparql query. 
        this.religiousAffiliation = "?place dbp:religiousAffiliation ?religiousAffiliation.";
        this.deity = "?place dbp:deity ?deity.";
        this.architecture = "?place dbp:architecture ?architecture.";
    }

    public String getReligiousAffiliation() {
        return this.religiousAffiliation;
    }

    public String getDeity() {
        return this.deity;
    }

    public String getArchitecture() {
        return this.architecture;
    }

    @Override
	public String createSparqlQuery() {
    	//Create a raw file
		this.createRawTtlFile(ObjectToCollect.OBJECT_TEMPLE);
		
		//Create the sparql query using all the attributes
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_TEMPLE + "\r\n"
				+ this.getName() + "\r\n"
				+ this.getComment() + "\r\n"
				+ this.getGeoPoint() + "\r\n"
				+ this.getGeoLat() + "\r\n"
				+ this.getGeoLong() + "\r\n"
				+ this.getLocation() + "\r\n"
				+ this.getCountry() + "\r\n"
				+ this.getReligiousAffiliation() + "\r\n"
				+ this.getDeity() + "\r\n"
				+ this.getArchitecture() + "\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_TEMPLE + "\r\n"
				+ "OPTIONAL {" + this.getName() + "}\r\n"
				+ "OPTIONAL {" + this.getComment() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoPoint() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoLat() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoLong() + "}\r\n"
				+ "OPTIONAL {" + this.getLocation() + "}\r\n"
				+ "OPTIONAL {" + this.getCountry() + "}\r\n"
				+ "OPTIONAL {" + this.getReligiousAffiliation() + "}\r\n"
				+ "OPTIONAL {" + this.getDeity() + "}\r\n"
				+ "OPTIONAL {" + this.getArchitecture() + "}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
				+ "}";
	}

}
