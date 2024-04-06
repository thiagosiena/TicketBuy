package Utils;

public class City {

    private String name;
    private String id;
    private String state;

    //constructors

    public City(){
        
    }
    public City(String name, String id, String state) {
        this.name = name;
        this.id = id;
        this.state = state;
    }

     //Getters

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getState() {
        return state;
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setState(String state) {
        this.state = state;
    }
      // To String 
    @Override
    public String toString() {
        return name + "/" + state;
    }


    

}
