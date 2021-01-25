package com.mygym.model;

import com.netu.lib.ApplicationService;
import com.netu.lib.DBUtils;
import com.netu.lib.Model.MODeleteViolationException;
import com.netu.lib.Model.MOTranslatedValidationException;
import com.netu.lib.Model.ModelObject;

import com.netu.lib.db.ConnectionPool;

import com.netu.lib.db.DBMapper;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import com.netu.lib.Model.ModelObjectList;
import com.netu.lib.db.MySQLDBMapper;
import com.netu.lib.Model.annotations.DMLQueries;

import javax.annotation.Generated;

/**
 * Gen: Version 3, MapperBase.mysql.txt
 * Class autogenerated on <DATE>Wed Jan 20 12:07:47 EET 2021</DATE> by com.netu.codeGen.XMLModelGenerator.<br>
 * Class for Database Data Mapper Pattern for table <b>exercise_type</b>.<br>
 * <b>!!!!!!!! DO NOT MODIFY CODE OF THIS CLASS!!!!!!!!</b><br>
 * This class has the responsibility of loading 
 * data into Model Objects, and saving them back to 
 * the Database
 */
@Generated(
        value = {"com.netu.codeGen.XMLModelGenerator"},
        comments = "Mapper Object for table exercise_type ",
        date = "Wed Jan 20 12:07:47 EET 2021"
    )
@DMLQueries(
	update="update exercise_type set exercise_type=?,create_date=?,update_date=?,create_user=?,update_user=? where exercise_type_id=?",
	updateRowid="",
	delete="DELETE FROM exercise_type WHERE exercise_type_id=?",
	deleteRowid="",
	insert="insert into exercise_type (exercise_type,create_date,update_date,create_user,update_user) values (?,?,?,?,?)",
	selectone="SELECT t.exercise_type_id, t.exercise_type, t.create_date, t.update_date, t.create_user, t.update_user FROM  exercise_type t  WHERE exercise_type_id=?",
	selectall="SELECT t.exercise_type_id, t.exercise_type, t.create_date, t.update_date, t.create_user, t.update_user FROM  exercise_type t ",
	pagingSelect="SELECT t.exercise_type_id, t.exercise_type, t.create_date, t.update_date, t.create_user, t.update_user FROM  exercise_type t  {criteria} LIMIT {offset}, {pageSize}")
public class ExerciseTypeDBMapper extends MySQLDBMapper  {
	
	public ExerciseTypeDBMapper(Connection c) {
		super(c);
	}
	public ExerciseTypeDBMapper() {
                // empty constructor, used in dynamic instantiations
		// will get a connection from the ApplicationService
		super();
	}
	
	/**
	* Clients can override this to return a custom class for loading
	*/
	public ExerciseType getInstanceForLoad() {
		
		return new ExerciseType();
		
	}
		
	public ModelObject load(Object ors) {
		
		ResultSet rs = (ResultSet)ors;
		
		ExerciseType ret = this.getInstanceForLoad();
		try {
			ret.setLoading(true);
			
			ret.setExerciseTypeId(readInt(rs,ExerciseType.FLD_EXERCISE_TYPE_ID));
			ret.setExerciseType(rs.getString(ExerciseType.FLD_EXERCISE_TYPE));
			ret.setCreateDate(readTimeStamp(rs,ExerciseType.FLD_CREATE_DATE));
			ret.setUpdateDate(readTimeStamp(rs,ExerciseType.FLD_UPDATE_DATE));
			ret.setCreateUser(rs.getString(ExerciseType.FLD_CREATE_USER));
			ret.setUpdateUser(rs.getString(ExerciseType.FLD_UPDATE_USER));

			
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());		
		
		}
		ret.setLoading(false);
		ret.setNew(false); // since we load from database, we mark as "old"
		return ret;
    
    }
	 
	
	



	
	@Override
	public void fillStatement(ModelObject obj, CallableStatement stmt, boolean bForInsert) throws Exception {
		
		ExerciseType o = (ExerciseType)obj;
		
		if (o.getExerciseType()==null){
			stmt.setNull(1, Types.VARCHAR);
		}else{
			stmt.setString(1,o.getExerciseType());
		}
		if (o.getCreateDate()==null){
			stmt.setNull(2, Types.VARCHAR);
		}else{
			stmt.setTimestamp(2, new java.sql.Timestamp( o.getCreateDate().getTime()));
		}
		if (o.getUpdateDate()==null){
			stmt.setNull(3, Types.VARCHAR);
		}else{
			stmt.setTimestamp(3, new java.sql.Timestamp( o.getUpdateDate().getTime()));
		}
		if (o.getCreateUser()==null){
			stmt.setNull(4, Types.VARCHAR);
		}else{
			stmt.setString(4,o.getCreateUser());
		}
		if (o.getUpdateUser()==null){
			stmt.setNull(5, Types.VARCHAR);
		}else{
			stmt.setString(5,o.getUpdateUser());
		}


		/* PRIMARY KEY FIELD HANDLED BELOW AND SHOULD ALAWAYS BE THE LAST PARAMETER IN THE SQL */
		if (bForInsert){
		 /* No Need to pass anything For INSERTS.  MySQL will assign an autoincrement value, and the MySQLDBMapper will receive it.*/
		} else {
		 /* For Update statement*/
			stmt.setInt(6,o.getExerciseTypeId().intValue());
		}


	}
	

	
	
	/**
	 * Method used by generated accessor methods of 1-many associations.
	 * It retrieves the object collection using the ApplicationService connection, or 
	 * if that is null, it opens and closes a connection
	 * @param swhere SQL where clause
	 * @param params Parameter array
	 * @return a ModelObjectList of ExerciseType objects loaded from database
	 */
	 public static ModelObjectList<ExerciseType> getAll(String swhere, Object ... params)  {
		// for static methods w/o connections, we try to get a connection from 
		// the ApplicationService.getCurrentConn().  if we do not find one there, 
		// then we get from the connection pool
		boolean bCloseConn = false;
		Connection c = ApplicationService.getCurrentConn();
		
		try {
			if(c==null) {
				bCloseConn = true;  // since we open a connection from the pool, set the flag to close it.
				c = ConnectionPool.getConn();
				
			}
			ExerciseTypeDBMapper adb = new ExerciseTypeDBMapper(c);
			return adb.findWhere(swhere, params);
		
		}catch (MOTranslatedValidationException moe) {
			throw moe;
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(bCloseConn)DBUtils.closeQuietly(c);
			//// only close the connection if we opened it.
		}
		
	}
	
	/**
	 * Method used by generated accessor methods of 1-1 associations.
	 * It retrieves the object using the ApplicationService connection, or 
	 * if that is null, it opens and closes a connection
	 * @param swhere SQL where clause
	 * @param params Parameter array
	 * @return a single ExerciseType object loaded from database
	 */
	public static ExerciseType get(String swhere, Object ... params)  {
		
		// for static methods w/o connections, we try to get a connection from 
		// the ApplicationService.getCurrentConn().  if we do not find one there, 
		// then we get from the connection pool
		boolean bCloseConn = false;
		Connection c = ApplicationService.getCurrentConn();
		
		try {
			if(c==null) {
				bCloseConn = true;  // since we open a connection from the pool, set the flag to close it.
				c = ConnectionPool.getConn();
				
			}
			ExerciseTypeDBMapper adb = new ExerciseTypeDBMapper(c);
			return (ExerciseType)adb.findOne(swhere, params);
		
		}catch (MOTranslatedValidationException moe) {
			throw moe;
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(bCloseConn)DBUtils.closeQuietly(c);
			//// only close the connection if we opened it.
		}
	}
	
	
	public static ExerciseType getByKey(final Object pkey)  {
		
		// for static methods w/o connections, we try to get a connection from 
		// the ApplicationService.getCurrentConn().  if we do not find one there, 
		// then we get from the connection pool
		boolean bCloseConn = false;
		Connection c = ApplicationService.getCurrentConn();
		
		try {
			if(c==null) {
				bCloseConn = true;  // since we open a connection from the pool, set the flag to close it.
				c = ConnectionPool.getConn();
				
			}

			ExerciseTypeDBMapper adb = new ExerciseTypeDBMapper(c);
			return (ExerciseType)adb.find(pkey);
		
		}catch (MOTranslatedValidationException moe) {
			throw moe;
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(bCloseConn)DBUtils.closeQuietly(c);
			//// only close the connection if we opened it.
		}
	}
	
	
}