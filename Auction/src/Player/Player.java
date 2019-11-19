package Player;

import java.sql.SQLException;
import java.util.Scanner;

import com.ipl.bo.PlayerBO;
import com.ipl.dao.PlayerDAO;

import Connection.ConnectionManager;

public class Player {
String player;
String country;
String skill;
String team;
public Player(){
	
}
public Player(String player, String country, String skill, String team) {
	super();
	this.player = player;
	this.country = country;
	this.skill = skill;
	this.team = team;
}

ConnectionManager conn=new ConnectionManager();
public void add() {
	// TODO Auto-generated method stub
	PlayerBO pbo=new PlayerBO();
	pbo.setPlayer(player);
	pbo.setCountry(country);
	pbo.setSkill(skill);
	pbo.setTeam(team);
	
	try {
		Skill s=new Skill(skill);
		Team t=new Team(team);
		int skillId=s.getSkillName(conn.getConnection());
		int teamId=t.getTeamId(conn.getConnection());
		PlayerDAO.createPlayer(conn.getConnection(),pbo,skillId,teamId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void list() throws SQLException, Exception {
	// TODO Auto-generated method stub
	PlayerDAO.getAllPlayerDetails(conn.getConnection());
}
public void search() throws SQLException, Exception {
	// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the skill name");
	String Skillvalue=sc.nextLine();
	PlayerDAO.SearchBySkill(conn.getConnection(),Skillvalue);
}


}
