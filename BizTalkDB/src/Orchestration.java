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

    public Date getInsertDateTime() {
        return InsertDateTime;
    }

    public Date getUpdateDateTime() {
        return UpdateDateTime;
    }

    public void setUpdateDateTime(Date update) {
        this.UpdateDateTime = update;
    }
}
