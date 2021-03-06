package home.backend;

import java.text.SimpleDateFormat;

public class QueueTicket {
    static int instanceNr = 0;
    int nr = 0;
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());

    public QueueTicket(){
        instanceNr++;
        nr = instanceNr;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getNr() {
        return nr;
    }
    public void updateQueueNr(int nr){
        if(nr<this.nr)
            --this.nr;

    }
    public void updateInstanceNr() {
        --instanceNr;
    }
    public void resetInstanceNr() {
        instanceNr=0;
    }
    public void updateQueueNr(){
            --this.nr;

    }

}
