package Main.dao;

import java.util.ArrayList;

public interface Dao_interface<T> {
	
	public int insert(T t);
	public int update(T t);
	public int delete(T t);
	
	public ArrayList<T> selectALL();
	
	public T Selectby_id( T t);
	
	public ArrayList<T> select_by_condition(String condition);
}
