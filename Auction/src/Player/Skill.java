package Player;

import java.sql.Connection;

import com.ipl.bo.SkillBO;
import com.ipl.dao.SkillDAO;

public class Skill {
	long skillId;
	String skillName;
	public Skill() {
		
	}
	public Skill(String skillName) {
		//super();
		this.skillName = skillName;
	}
	public int getSkillName(Connection connection) {
		// TODO Auto-generated method stub
		int id=SkillDAO.FindBySkillName(connection,skillName);
		SkillBO sbo=new SkillBO();
		sbo.setSkillName(skillName);
		sbo.setSkillId(id);
		return id;
	}
	
	
}