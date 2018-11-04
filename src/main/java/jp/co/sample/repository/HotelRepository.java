package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Hotel;

@Repository
public class HotelRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Autowired
	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;
	};

	public List<Hotel> findByLowPrice(Integer price){
		String sql = "select id,area_name,hotel_name,address,nearest_station,price,parking from hotels "
				+ "where price = :price";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		List<Hotel> hotelList = template.query(sql, param,HOTEL_ROW_MAPPER);
		
		return hotelList;
	}
	
}
