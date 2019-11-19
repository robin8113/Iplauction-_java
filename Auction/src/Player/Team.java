package Player;

import java.sql.Connection;
import java.util.Collection;

import com.ipl.bo.TeamBO;
import com.ipl.dao.TeamDAO;



public class Team {
	long teamId;
	String teamName;
	public Team(String teamName) {
		//super();
		this.teamName = teamName;
	}
	public int getTeamId(Connection connection) {
		// TODO Auto-generated method stub
		int id=TeamDAO.FindByTeamName(connection,teamName);
		TeamBO tbo=new TeamBO();
		tbo.setTeamId(id);
		tbo.setTeamName(teamName);
		return id;
	}
}
