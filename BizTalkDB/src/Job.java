import java.util.Date;

public class Job {
    private int id;
    private int owner;
    private String description;
    private String destination;
    private String fileUrl;
    private String relatives;
    private int status;
    private int ruleId;            // ??????
    private Date insertDateTime;
    private Date updateDateTime;

    public Job(){

    }

    public Job(int id,int owner,String description,String destination,String fileUrl,
               String relatives,int status, int ruleId ,Date insertDateTime,Date updateDateTime){
        this.id = id;
        this.owner = owner;
        this.description = description;
        this.destination = destination;
        this.fileUrl = fileUrl;
        this.relatives = relatives;
        this.status = status;
        this.ruleId = ruleId;
        this.insertDateTime = insertDateTime;
        this.updateDateTime = updateDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getRelatives() {
        return relatives;
    }

    public void setRelatives(String relatives) {
        this.relatives = relatives;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

}

