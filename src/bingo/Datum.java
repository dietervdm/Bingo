package bingo;

import java.util.Date;

public class Datum extends Date
{
    
    public void wijzigDatum(int jaren, int maanden, int uren, int minuten){
        this.setYear(jaren);
        this.setMonth(maanden);
        this.setHours(uren);
        this.setMinutes(minuten);
    }
}