package hust.soict.globalict.vntourism.backend.rdfconstant;

//This class store all the objects that we want to query in
public final class ObjectToCollect {
	public final static String OBJECT_BAY = "dbc:Bays_of_Vietnam.";
	public final static String OBJECT_BEACH = "dbc:Beaches_of_Vietnam.";
	public final static String OBJECT_LAKE = "dbc:Lakes_of_Vietnam.";
	public final static String OBJECT_RIVER = "dbc:Rivers_of_Vietnam.";
	public final static String OBJECT_GARDEN = "dbc:Botanical_gardens_in_Vietnam.";
	public final static String OBJECT_CAVE = "dbc:Caves_of_Vietnam.";
	public final static String OBJECT_ISLAND = "dbc:Islands_of_Vietnam.";
	public final static String OBJECT_MOUNTAIN = "dbc:Mountains_of_Vietnam.";
	public final static String OBJECT_NATIONALPARK = "dbc:National_parks_of_Vietnam.";
	public final static String OBJECT_ZOO = "dbc:Zoos_in_Vietnam.";
	public final static String OBJECT_AMUSEMENTPARK = "dbc:Amusement_parks_in_Vietnam.";
	public final static String OBJECT_BUILDING = "dbc:Skyscraper_office_buildings_in_Vietnam.";
	public final static String OBJECT_HOTEL = "dbc:Hotels_in_Vietnam.";
	public final static String OBJECT_BRIDGE = "dbc:Bridges_in_Vietnam.";
	public final static String OBJECT_CATHEDRAL = "dbc:Roman_Catholic_cathedrals_in_Vietnam.";
	public final static String OBJECT_MUSEUM = "dbc:Museums_in_Vietnam.";
	public final static String OBJECT_TEMPLE = "dbc:Buddhist_temples_in_Hanoi.";
	public final static String[] OBJECT_BODY_OF_WATER = { OBJECT_BAY, OBJECT_BEACH, OBJECT_LAKE, OBJECT_RIVER };
	public final static String[] OBJECT_MODERN_ARCHITECTURE = { OBJECT_BUILDING, OBJECT_HOTEL, OBJECT_AMUSEMENTPARK };
	public final static String[] OBJECT_NATURAL_ATTRACTION = { OBJECT_BAY, OBJECT_BEACH, OBJECT_LAKE, OBJECT_RIVER,
			OBJECT_GARDEN, OBJECT_CAVE, OBJECT_ISLAND, OBJECT_MOUNTAIN, OBJECT_MOUNTAIN, OBJECT_ZOO };
	public final static String[] OBJECT_MANMADE_ATTRACTION = { OBJECT_AMUSEMENTPARK, OBJECT_BUILDING, OBJECT_HOTEL,
			OBJECT_BRIDGE, OBJECT_CATHEDRAL, OBJECT_MUSEUM, OBJECT_TEMPLE };
	public final static String[] OBJECT_TOURIST_ATTRACTION = { OBJECT_AMUSEMENTPARK, OBJECT_BUILDING, OBJECT_HOTEL,
			OBJECT_BRIDGE, OBJECT_CATHEDRAL, OBJECT_MUSEUM, OBJECT_TEMPLE, OBJECT_BAY, OBJECT_BEACH, OBJECT_LAKE,
			OBJECT_RIVER, OBJECT_GARDEN, OBJECT_CAVE, OBJECT_ISLAND, OBJECT_MOUNTAIN, OBJECT_MOUNTAIN, OBJECT_ZOO };
}
