package Utils;


public class Person {
    private String name;
    private String cpf;
    private String email;
    
    //constructors
    
    public Person(){
        this.name = "";
        this.cpf = "";
        this.email = "";
    }
    
    public Person(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    //Getters

    public String getName() {
        return name;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEmail() {
        return email;
    }
    
    //Setters
    
    public void setName(String name) {
        this.name = name;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // To String 
    
    @Override
    public String toString() {
        return  "Name[" + name + "]" + " Cpf[" + cpf + "]";
    }
    


}
