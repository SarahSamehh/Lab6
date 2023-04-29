/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sarah
 */
public class Container implements Comparable<Container> {
    private String UUID;
    private String shortName;
    private String longName;
    
    public String getUUID() {
        return UUID;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setUUID(String UUID) {
       this.UUID = UUID;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    @Override
    public String toString(){
        return "\t<CONTAINER UUID=\"" + this.getUUID() + "\">\n"
                + "\t\t<SHORT-NAME>" + this.getShortName() + "</SHORT-NAME>\n"
                + "\t\t<LONG-NAME>" + this.getLongName() + "</LONG-NAME>\n"
                + "\t</CONTAINER>\n";
    }
    
    public int compareTo(Container o){
        return this.getShortName().compareTo(o.getShortName());
    }
       
}
