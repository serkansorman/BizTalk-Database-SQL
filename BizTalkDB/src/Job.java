import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Job {
    private int id;
    private int owner;
    private String description;
    private String destination;
    private String fileUrl;
    private String relatives;
    private int status;
    private int ruleId;
    private Date insertDateTime;
    private Date updateDateTime;

    public Job(){

    }

    public Job(int id,int owner,String description,String destination,String fileUrl,
               String relatives,int status, int ruleId ){
        this.id = id;
        this.owner = owner;
        this.description = description;
        this.destination = destination;
        this.fileUrl = fileUrl;
        this.relatives = relatives;
        this.status = status;
        this.ruleId = ruleId;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.insertDateTime = new Date();
        this.updateDateTime = new Date();
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

    public String getInsertDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = dateFormat.format(insertDateTime);
        return date;
    }

    public void setInsertDateTime(String time) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.insertDateTime = dateFormat.parse(time);
    }

    public String getUpdateDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = dateFormat.format(updateDateTime);
        return date;
    }

    public void setUpdateDateTime(String update) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.updateDateTime = dateFormat.parse(update);
    }


}

