package com.ipl.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;

import Player.Team;

public class TeamDAO {
  
	public static int FindByTeamName(Connection connection, String teamName) {
		// TODO Auto-generated method stub
		int team_id=0;
		try {
			
			Statement stmnt=connection.createStatement();
			String query="select id from team where name='"+teamName+"'";
			ResultSet res=stmnt.executeQuery(query);
			while(res.next()) {
				team_id=res.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return team_id;
		
	}
}

