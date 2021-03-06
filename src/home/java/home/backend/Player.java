package home.backend;

public class Player {
    String name;
    QueueTicket qt;


    public Player(){

    }
    public Player(String name){
        this.name = name;
        this.qt = new QueueTicket();
    }

    public String getName() {
        return name;
    }

    public int getQueueTicketNr() {
        return qt.getNr();
    }

    public String getQueueTimeStamp() {
        return qt.getTimeStamp();
    }

    public QueueTicket getQueueTicket() {
        return qt;
    }

    public String getPlaceInQueue() {
        if(null == this){
            return null;
        }
        return "Spelare: "+ name + "\nKöplats: "+qt.getNr() + "\nSkapad: " +qt.getTimeStamp();
    }

    public String getPlaceInQueueWithName(String newName) {
        if(null == this){
            return null;
        }
        return "Spelare: "+ name + "\nKöplats: "+qt.getNr() + "\nSkapad: " +qt.getTimeStamp();
    }

}
