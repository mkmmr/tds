package com.example.tds.list;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ToDoRepository {

	@Select("select * from to_do_list")
	List<ToDoEntity> selectAll();

	@Insert("insert into to_do_list (state, task, limit_date) values (#{state}, #{task}, #{limit_date})")
	void insert(@Param("state") String state, @Param("task") String task, @Param("limit_date") String limitDate);

	@Delete("delete from to_do_list where id = #{id}")
	int deleteById(@Param("id") Integer id);

	@Update("update to_do_list set state = #{state}")
	int update(@Param("state") String state);
}