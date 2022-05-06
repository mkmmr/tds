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

	@Select("select * from to_do_list order by limit_date")
	List<ToDoEntity> selectAll();

	@Insert("insert into to_do_list (state, task, limit_date) values (0, #{task}, #{limit_date})")
	void insert(@Param("task") String task, @Param("limit_date") String limitDate);

	@Delete("delete from to_do_list where id = #{id}")
	int deleteById(@Param("id") long toDoid);

	@Update("update to_do_list set task = #{task}, limit_date = #{limit_date} where id = #{id}")
	int update(@Param("task") String task, @Param("limit_date") String limitDate, @Param("id") long toDoId);

	@Select("select * from to_do_list where id = #{id}")
	ToDoEntity findById(@Param("id") long toDoId);

	@Update("update to_do_list set state = 1 where id = #{id}")
	void switchState(@Param("id") long toDoId);
}
