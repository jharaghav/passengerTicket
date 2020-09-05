package passesnger.ticket.utilities;

public enum StationConstants {
    CHENNAI_BEACH("Chennai Beach"),
    CHENNAI_FORT("Chennai Fort"),
    CHENNAI_PARK("Chennai Park"),
    CHENNAI_EGMORE("Chennai Egmore"),
    CHETPET("Chetpet"),
    NUNGAMBAKKAM("Nungambakkam"),
    KODAMBAKKAM("Kodambakkam"),
    MAMBALAM("Mambalam"),
    SAIDPET("Saidapet"),
    GUINDY("Guindy"),
    ST_THOMAS_MOUNT("St. Thomas Mount"),
    PAZHAVANTHANGAL("Pazhavanthangal"),
    MENNAMBAKKAM("Meenambakkam"),
    TRISULAM("Trisulam"),
    PALLAVARAM("Pallavaram"),
    CHROMEPET("Chromepet"),
    TAMBARAM_SANATORIUM("Tambaram Sanatorium"),
    TAMBARAM("Tambaram");

    public final String stationName;

    private StationConstants(String stationName) {
        this.stationName = stationName;
    }
}
