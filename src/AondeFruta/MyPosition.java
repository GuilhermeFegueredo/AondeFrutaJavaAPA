package AondeFruta;

public class MyPosition {
    private int myGeoPosition;
    private String myState;
    private String myCity;

    public MyPosition(String myState, String myCity, int myGeoPosition){
            setMyGeoPosition(myState, myCity, myGeoPosition);
    }

    public int getMyGeoPosition(){
            return myGeoPosition;
    }

    public String getMyState(){
        if(myState != null){
            return myState;
        } else {
            return "Your state wasn't found!";
        }
    }

    public String getMyCity(){
       if(myCity != null){
           return myCity;
       } else {
           return "Your city wasn't found!";
       }
    }

    private void setMyGeoPosition(String myState, String myCity, int myGeoPosition){
            this.myState = myState;
            this.myCity = myCity;
            this.myGeoPosition = myGeoPosition;
    }
}
