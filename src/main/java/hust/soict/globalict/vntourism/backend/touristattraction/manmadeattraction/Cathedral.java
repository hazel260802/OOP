package hust.soict.globalict.vntourism.backend.touristattraction.manmadeattraction;

import hust.soict.globalict.vntourism.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.vntourism.backend.rdfconstant.Prefix;

public class Cathedral extends ManmadeAttraction {

    private String denomination;
    private String functionalStatus;
    private String architecturalStyle;
    private String completedDate;

    public Cathedral() {
		super();
		//Each attribute will be initialized with the information we want to query, will be used inside the sparql query. 
        this.denomination = "?place dbp:denomination ?denomination.";
        this.functionalStatus = "?place dbp:functionalStatus ?functionalStatus.";
        this.architecturalStyle = "?place dbp:architecturalStyle ?architecturalStyle.";
        this.completedDate = "?place dbp:completedDate ?completedDate.";
    }

    public String getDenomination() {
        return this.denomination;
    }

    public String getFunctionalStatus() {
        return this.functionalStatus;
    }

    public String getArchitecturalStyle() {
        return this.architecturalStyle;
    }

    public String getCompletedDate() {
        return this.completedDate;
    }

    @Override
	public String createSparqlQuery() {
    	//Create a raw file
		this.createRawTtlFile(ObjectToCollect.OBJECT_CATHEDRAL);
		
		//Create the sparql query using all the attributes
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_CATHEDRAL + "\r\n"
				+ this.getName() + "\r\n"
				+ this.getComment() + "\r\n"
				+ this.getGeoPoint() + "\r\n"
				+ this.getGeoLat() + "\r\n"
				+ this.getGeoLong() + "\r\n"
				+ this.getLocation() + "\r\n"
				+ this.getCountry() + "\r\n"
				+ this.getDenomination() + "\r\n"
				+ this.getFunctionalStatus() + "\r\n"
				+ this.getArchitecturalStyle() + "\r\n"
				+ this.getCompletedDate() + "\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_CATHEDRAL + "\r\n"
				+ "OPTIONAL {" + this.getName() + "}\r\n"
				+ "OPTIONAL {" + this.getComment() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoPoint() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoLat() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoLong() + "}\r\n"
				+ "OPTIONAL {" + this.getLocation() + "}\r\n"
				+ "OPTIONAL {" + this.getCountry() + "}\r\n"
				+ "OPTIONAL {" + this.getDenomination() + "}\r\n"
				+ "OPTIONAL {" + this.getFunctionalStatus() + "}\r\n"
				+ "OPTIONAL {" + this.getArchitecturalStyle() + "}\r\n"
				+ "OPTIONAL {" + this.getCompletedDate() + "}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
				+ "}";
	}
}
