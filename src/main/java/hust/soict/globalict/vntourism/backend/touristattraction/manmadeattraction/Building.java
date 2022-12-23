package hust.soict.globalict.vntourism.backend.touristattraction.manmadeattraction;

import hust.soict.globalict.vntourism.backend.rdfconstant.ObjectToCollect;
import hust.soict.globalict.vntourism.backend.rdfconstant.Prefix;

public class Building extends ModernArchitecture {

	private String architect;
	private String architecturalStyle;
	private String buildingEndDate;
	private String buildingStartDate;
	private String developer;
	private String elevatorCount;
	private String floorCount;
	private String height;
	private String numberOfRooms;

	public Building() {
		super();
		//Each attribute will be initialized with the information we want to query, will be used inside the sparql query. 
		this.architect = "?place dbo:architect ?architect.";
		this.architecturalStyle = "?place dbo:architecturalStyle ?architecturalStyle.";
		this.buildingEndDate = "?place dbo:buildingEndDate ?buildingEndDate.";
		this.buildingStartDate = "?place dbo:buildingStartDate ?buildingStartDate.";
		this.developer = "?place dbo:developer ?developer.";
		this.elevatorCount = "?place dbo:elevatorCount ?elevatorCount.";
		this.floorCount = "?place dbo:floorCount ?floorCount.";
		this.height = "?place dbo:height ?height.";
		this.numberOfRooms = "?place dbo:numberOfRooms ?numberOfRooms.";
	}

	public String getArchitect() {
		return this.architect;
	}

	public String getArchitecturalStyle() {
		return this.architecturalStyle;
	}

	public String getBuildingEndDate() {
		return this.buildingEndDate;
	}

	public String getBuildingStartDate() {
		return this.buildingStartDate;
	}

	public String getDeveloper() {
		return this.developer;
	}

	public String getElevatorCount() {
		return this.elevatorCount;
	}

	public String getFloorCount() {
		return this.floorCount;
	}

	public String getHeight() {
		return this.height;
	}

	public String getNumberOfRooms() {
		return this.numberOfRooms;
	}

	@Override
	public String createSparqlQuery() {
		//Create a raw file
		this.createRawTtlFile(ObjectToCollect.OBJECT_BUILDING);
		
		//Create the sparql query using all the attributes
		return Prefix.PREFIX + "CONSTRUCT{\r\n"
				+ "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_BUILDING + "\r\n"
				+ this.getName() + "\r\n"
				+ this.getComment() + "\r\n"
				+ this.getGeoPoint() + "\r\n"
				+ this.getGeoLat() + "\r\n"
				+ this.getGeoLong() + "\r\n"
				+ this.getLocation() + "\r\n"
				+ this.getCountry() + "\r\n"
				+ this.getArchitect() + "\r\n"
				+ this.getArchitecturalStyle() + "\r\n"
				+ this.getBuildingEndDate() + "\r\n"
				+ this.getBuildingStartDate() + "\r\n"
				+ this.getDeveloper() + "\r\n"
				+ this.getElevatorCount() + "\r\n"
				+ this.getFloorCount() + "\r\n"
				+ this.getHeight() + "\r\n"
				+ this.getNumberOfRooms() + "\r\n"
				+ this.getOpeningDate() + "\r\n"
				+ this.getOwner() + "\r\n"
				+ "} WHERE{\r\n"
				+ "?place dbo:wikiPageWikiLink " + ObjectToCollect.OBJECT_BUILDING + "\r\n"
				+ "OPTIONAL {" + this.getName() + "}\r\n"
				+ "OPTIONAL {" + this.getComment() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoPoint() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoLat() + "}\r\n"
				+ "OPTIONAL {" + this.getGeoLong() + "}\r\n"
				+ "OPTIONAL {" + this.getLocation() + "}\r\n"
				+ "OPTIONAL {" + this.getCountry() + "}\r\n"
				+ "OPTIONAL {" + this.getArchitect() + "}\r\n"
				+ "OPTIONAL {" + this.getArchitecturalStyle() + "}\r\n"
				+ "OPTIONAL {" + this.getBuildingEndDate() + "}\r\n"
				+ "OPTIONAL {" + this.getBuildingStartDate() + "}\r\n"
				+ "OPTIONAL {" + this.getDeveloper() + "}\r\n"
				+ "OPTIONAL {" + this.getElevatorCount() + "}\r\n"
				+ "OPTIONAL {" + this.getFloorCount() + "}\r\n"
				+ "OPTIONAL {" + this.getHeight() + "}\r\n"
				+ "OPTIONAL {" + this.getNumberOfRooms() + "}\r\n"
				+ "OPTIONAL {" + this.getOpeningDate() + "}\r\n"
				+ "OPTIONAL {" + this.getOwner() + "}\r\n"
				+ "FILTER ( LANG ( ?comment ) = 'en' ).\r\n"
				+ "}";
	}
}
