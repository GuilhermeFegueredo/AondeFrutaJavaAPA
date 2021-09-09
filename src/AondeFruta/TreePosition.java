package AondeFruta;

public class TreePosition {
    private String state; //??
    private String city;  //??
    private int geoPosition; //??

    public TreePosition(String state, String city, int geoPosition) {   //construtor set(estado, cidade, posição)
        setTreePosition(state, city, geoPosition);
    }

    public int getGeoPosition() {       // retorna posição
        return geoPosition;
    }

    public String getState() {          // retorna estado
        return state;
    }

    public String getCity() {           // retorna cidade
        return city;
    }

    private void setTreePosition(String state, String city, int geoPosition) { // função que da set (estado, cidade, posição)
        this.state = state;
        this.city = city;
        this.geoPosition = geoPosition;
    }
}
