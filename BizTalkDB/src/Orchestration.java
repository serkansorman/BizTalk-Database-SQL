import java.text.SimpleDateFormat;
import java.util.Date;

public class Orchestration {

    private int id;
    private int ownerID;
    private int status;
    private int startJobID;
    private Date InsertDateTime;
    private Date UpdateDateTime;

    public Orchestration(){

    }

    public Orchestration(int id, int ownerID, int status, int startJobID) {
        this.id = id;
        this.ownerID = ownerID;
        this.status = status;
        this.startJobID = startJobID;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        InsertDateTime = new Date();
        UpdateDateTime = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStartJobID() {
        return startJobID;
    }

    public void setStartJobID(int startJobID) {
        this.startJobID = startJobID;
    }

    public String getInsertDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = dateFormat.format(InsertDateTime);
        return date;
    }

    public void setInsertDateTime(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.InsertDateTime = dateFormat.parse(time);
    }

    public String getUpdateDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = dateFormat.format(UpdateDateTime);
        return date;
    }

    public void setUpdateDateTime(String update) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.UpdateDateTime = dateFormat.parse(update);
    }
}
