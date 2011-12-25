package model;
// Generated 15.12.2011 17:22:14 by Hibernate Tools 3.2.1.GA



/**
 * Zadost generated by hbm2java
 */
public class Zadost  implements java.io.Serializable {


     private Integer id;
     private String datumZadani;
     private String datumVyrizeni;
     private String textZadosti;
     private String stavZadosti;

     /**
      *
      */
     public Zadost() {
    }

    /**
     *
     * @param datumZadani
     * @param datumVyrizeni
     * @param textZadosti
     * @param stavZadosti
     */
    public Zadost(String datumZadani, String datumVyrizeni, String textZadosti, String stavZadosti) {
       this.datumZadani = datumZadani;
       this.datumVyrizeni = datumVyrizeni;
       this.textZadosti = textZadosti;
       this.stavZadosti = stavZadosti;
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
     * @return datumZadani
     */
    public String getDatumZadani() {
        return this.datumZadani;
    }
    
    /**
     *
     * @param datumZadani
     */
    public void setDatumZadani(String datumZadani) {
        this.datumZadani = datumZadani;
    }
    /**
     *
     * @return datumVyrizeni
     */
    public String getDatumVyrizeni() {
        return this.datumVyrizeni;
    }
    
    /**
     *
     * @param datumVyrizeni
     */
    public void setDatumVyrizeni(String datumVyrizeni) {
        this.datumVyrizeni = datumVyrizeni;
    }
    /**
     *
     * @return textZadosti
     */
    public String getTextZadosti() {
        return this.textZadosti;
    }
    
    /**
     *
     * @param textZadosti
     */
    public void setTextZadosti(String textZadosti) {
        this.textZadosti = textZadosti;
    }
    /**
     *
     * @return stavZadosti
     */
    public String getStavZadosti() {
        return this.stavZadosti;
    }
    
    /**
     *
     * @param stavZadosti
     */
    public void setStavZadosti(String stavZadosti) {
        this.stavZadosti = stavZadosti;
    }




}

