package hust.soict.globalict.vntourism.backend.touristattraction.manmadeattraction;

import hust.soict.globalict.vntourism.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.vntourism.backend.rdfconstant.Prefix;

public class Bridge extends ManmadeAttraction {

	private String length;
	private String type;
	private String crosses;
	private String open;
	private String width;
	private String height;
	private String design;
	private String mainspan;
	private String begin;
	private String locatedInArea;
	private String carries;
	private String material;

	public Bridge() {
		super();
		//Each attribute will be initialized with the information we want to query, will be used inside the sparql query. 
		this.length = "?place dbo:length ?length.";
		this.type = "?place dbo:type ?type.";
		this.crosses = "?place dbo:crosses ?crosses.";
		this.open = "?place dbp:open ?open.";
		this.width = "?place dbo:width ?width.";
		this.height = "?place dbo:height ?height.";
		this.design = "?place dbp:design ?design.";
		this.mainspan = "?place dbo:mainspan ?mainspan.";
		this.begin = "?place dbp:begin ?begin.";
		this.locatedInArea = "?place dbo:locatedInArea ?locatedInArea.";
		this.carries = "?place dbp:carries ?carries.";
		this.material = "?place dbp:material ?material.";
	}

	public String getLength() {
		return this.length;
	}

	public String getType() {
		return this.type;
	}

	public String getCrosses() {
		return this.crosses;
	}

	public String getOpen() {
		return this.open;
	}

	public String getWidth() {
		return this.width;
	}

	public String getHeight() {
		return this.height;
	}

	public String getDesign() {
		return this.design;
	}

	public String getMainspan() {
		return this.mainspan;
	}

	public String getBegin() {
		return this.begin;
	}

	public String getLocatedInArea() {
		return this.locatedInArea;
	};

	public String getCarries() {
		return this.carries;
	}

	public String getMaterial() {
		return this.material;
	}

	@Override
	public String createSparqlQuery() {
		//Create a raw file
		this.createRawTtlFile(ObjectToCollect.OBJECT_BRIDGE);
		
		//Create the sparql query using all the attributes
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_BRIDGE + "\r\n"
				+ this.getName() + "\r\n"
				+ this.getComment() + "\r\n"
				+ this.getGeoPoint() + "\r\n"
				+ this.getGeoLat() + "\r\n"
				+ this.getGeoLong() + "\r\n"
				+ this.getLocation() + "\r\n"
				+ this.getCountry() + "\r\n"
				+ this.getLength() + "\r\n"
				+ this.getType() + "\r\n"
				+ this.getCrosses() + "\r\n"
				+ this.getOpen() + "\r\n"
				+ this.getWidth() + "\r\n"
				+ this.getHeight() + "\r\n"
				+ this.getDesign() + "\r\n"
				+ this.getMainspan() + "\r\n"
				+ this.getBegin() + "\r\n"
				+ this.getLocatedInArea() + "\r\n"
				+ this.getCarries() + "\r\n"
				+ this.getMaterial() + "\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_BRIDGE + "\r\n"
				+ "OPTIONAL {" + this.getName() + "}\r\n"
				+ "OPTIONAL {" + this.getComment() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoPoint() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoLat() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoLong() + "}\r\n"
				+ "OPTIONAL {" + this.getLocation() + "}\r\n"
				+ "OPTIONAL {" + this.getCountry() + "}\r\n"
				+ "OPTIONAL {" + this.getLength() + "}\r\n"
				+ "OPTIONAL {" + this.getType() + "}\r\n"
				+ "OPTIONAL {" + this.getCrosses() + "}\r\n"
				+ "OPTIONAL {" + this.getOpen() + "}\r\n"
				+ "OPTIONAL {" + this.getWidth() + "}\r\n"
				+ "OPTIONAL {" + this.getHeight() + "}\r\n"
				+ "OPTIONAL {" + this.getDesign() + "}\r\n"
				+ "OPTIONAL {" + this.getMainspan() + "}\r\n"
				+ "OPTIONAL {" + this.getBegin() + "}\r\n"
				+ "OPTIONAL {" + this.getLocatedInArea() + "}\r\n"
				+ "OPTIONAL {" + this.getCarries() + "}\r\n"
				+ "OPTIONAL {" + this.getMaterial() + "}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
				+ "}";
	}
}
