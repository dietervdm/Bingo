
package Logica;



public class VestigingId  implements java.io.Serializable {


     private int vestigingid;
     private String winkelnaam;

    public VestigingId() {
    }

    public VestigingId(int vestigingid, String winkelnaam) {
       this.vestigingid = vestigingid;
       this.winkelnaam = winkelnaam;
    }
   
    public int getVestigingid() {
        return this.vestigingid;
    }
    
    public void setVestigingid(int vestigingid) {
        this.vestigingid = vestigingid;
    }
    public String getWinkelnaam() {
        return this.winkelnaam;
    }
    
    public void setWinkelnaam(String winkelnaam) {
        this.winkelnaam = winkelnaam;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VestigingId) ) return false;
		 VestigingId castOther = ( VestigingId ) other; 
         
		 return (this.getVestigingid()==castOther.getVestigingid())
 && ( (this.getWinkelnaam()==castOther.getWinkelnaam()) || ( this.getWinkelnaam()!=null && castOther.getWinkelnaam()!=null && this.getWinkelnaam().equals(castOther.getWinkelnaam()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getVestigingid();
         result = 37 * result + ( getWinkelnaam() == null ? 0 : this.getWinkelnaam().hashCode() );
         return result;
   }   
}