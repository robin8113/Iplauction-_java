package com.ipl.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.ipl.bo.PlayerBO;

import Player.Player;

public class PlayerDAO {
 
		public static void createPlayer(Connection connection, PlayerBO pbo, int skillId, int teamId) {
			// TODO Auto-generated method stub
			try {
				Statement stmnt=connection.createStatement();
				String query="insert into player(name,country,skill_id,team_id)values('"+pbo.getPlayer()+"','"+pbo.getCountry()+"',"+skillId+","+teamId+")";
			//	System.out.println(query);
				int res=stmnt.executeUpdate(query);
				if(res==1) {
					System.out.println("Player has been added successfully");
				}
				else {
					System.out.println("Player has'nt been added");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	List<Player> getPlayerDetails(String SkillName)
	{
		return null;
		
	}
	public static  void getAllPlayerDetails(Connection connection) throws SQLException
	{
		Statement stmnt=connection.createStatement();
		String query="select * from player p,team t,skill s where p.team_id=t.id and p.skill_id=s.id";
		ResultSet res=stmnt.executeQuery(query);
		System.out.println("Player name \t Country \t Skill \t \t Team");
        while(res.next()) {
            System.out.println(res.getString("p.name")+"\t \t"+res.getString("country")+"\t \t"+res.getString("s.name")+"\t \t"+res.getString("t.name"));
        }
	}

	public static void SearchBySkill(Connection connection, String skillvalue) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmnt=connection.createStatement();
		String query="select * from player p,team t,skill s where p.team_id=t.id and p.skill_id=s.id and s.name='"+skillvalue+"'";
        //    System.out.println(query);
            ResultSet res=stmnt.executeQuery(query);
            System.out.println("Details");
            System.out.println("Player name \t Country \t Skill \t \t Team");
            while(res.next()) {
                System.out.println(res.getString("p.name")+"\t \t"+res.getString("country")+"\t \t"+res.getString("s.name")+"\t \t"+res.getString("t.name"));
            }
        } 
	}
	
	

