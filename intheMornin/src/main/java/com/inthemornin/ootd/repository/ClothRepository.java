package com.inthemornin.ootd.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.inthemornin.ootd.model.ClothesVO;

@Repository
public class ClothRepository implements IRepository{
	@Autowired
	JdbcTemplate jdbcTemplate;
	private class ClothMapper implements RowMapper<ClothesVO> {
		@Override
		public ClothesVO mapRow(ResultSet rs, int count) 
				throws SQLException {
			ClothesVO cloth = new ClothesVO();
			cloth.setCloth_id(rs.getInt("employee_id"));
			cloth.setCloth_type(rs.getString("first_name"));
			cloth.setOutfits_type(rs.getString("last_name"));
			cloth.setCust_id(rs.getString("email"));
			cloth.setColor(rs.getString("phone_number"));
			cloth.setSeason(rs.getString("hire_date"));			

			return cloth;
		}			
	}
	
	@Override
	public int getClothCount() {
		String sql = "select count(*) from clothes";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int getClothCount(int deptid) {
		String sql = "select count(*) from clothes where cloth_id=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, deptid);
	}
}
