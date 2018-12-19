import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RuleDAO extends DBHandler {

    public Rule getRule(int ruleID) throws Exception {

        Connection conn = getConnection();
        Rule rule = new Rule();
        PreparedStatement preparedStmt = conn.prepareStatement("SELECT * FROM Rules WHERE RuleId=?");

        preparedStmt.setInt(1, ruleID);
        ResultSet rs = preparedStmt.executeQuery();

        if(rs.next()) {
            rule.setId(rs.getInt("RuleId"));
            rule.setOwnerID(rs.getInt("RuleOwner"));
            rule.setQuery(rs.getString("RuleQuery"));
            rule.setYesEdge(rs.getInt("YesEdge"));
            rule.setNoEdge(rs.getInt("NoEdge"));
            rule.setRelativeResults(rs.getString("RelativeResults"));
        }

        closePreparedStatement(preparedStmt);
        closeResultSet(rs);
        closeConnection(conn);


        return rule;

    }


    public boolean insertRule(Rule rule)  throws Exception {

        Connection conn = getConnection();
        PreparedStatement preparedStmt = conn.prepareStatement(" INSERT INTO Rules (RuleId, RuleOwner, RuleQuery, YesEdge, NoEdge,RelativeResults)"
                + " values (?, ?, ?, ?, ?, ?)");

        preparedStmt.setInt(1, rule.getId());
        preparedStmt.setInt(2, rule.getOwnerID());
        preparedStmt.setString(3, rule.getQuery());
        preparedStmt.setInt(4, rule.getYesEdge());
        preparedStmt.setInt(5, rule.getNoEdge());
        preparedStmt.setString(6, rule.getRelativeResults());

        closePreparedStatement(preparedStmt);
        closeConnection(conn);

        return preparedStmt.execute();

    }
}
