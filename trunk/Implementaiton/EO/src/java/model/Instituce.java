package model;
// Generated 15.12.2011 17:22:14 by Hibernate Tools 3.2.1.GA



/**
 * Instituce generated by hbm2java
 */
public class Instituce  implements java.io.Serializable {


     private Integer id;
     private String nazev;

     /**
      *
      */
     public Instituce() {
    }

     /**
      *
      * @param nazev
      */
     public Instituce(String nazev) {
       this.nazev = nazev;
    }
   
    /**
     *
     * @return id
     */
    public Integer getId() {
        return this.id;
    }
    
    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     *
     * @return nazev
     */
    public String getNazev() {
        return this.nazev;
    }
    
    /**
     *
     * @param nazev
     */
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }




}


