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
 * Class autogenerated on <DATE>Tue Oct 20 21:24:13 EEST 2020</DATE> by com.netu.codeGen.XMLModelGenerator.<br>
 * Class for Database Data Mapper Pattern for table <b>body_part_exercise</b>.<br>
 * <b>!!!!!!!! DO NOT MODIFY CODE OF THIS CLASS!!!!!!!!</b><br>
 * This class has the responsibility of loading 
 * data into Model Objects, and saving them back to 
 * the Database
 */
@Generated(
        value = {"com.netu.codeGen.XMLModelGenerator"},
        comments = "Mapper Object for table body_part_exercise ",
        date = "Tue Oct 20 21:24:13 EEST 2020"
    )
@DMLQueries(
	update="update body_part_exercise set body_part_id=?,exercise_id=? where body_part_exercise_id=?",
	updateRowid="",
	delete="DELETE FROM body_part_exercise WHERE body_part_exercise_id=?",
	deleteRowid="",
	insert="insert into body_part_exercise (body_part_id,exercise_id) values (?,?)",
	selectone="SELECT t.body_part_exercise_id, t.body_part_id, t.exercise_id FROM  body_part_exercise t  WHERE body_part_exercise_id=?",
	selectall="SELECT t.body_part_exercise_id, t.body_part_id, t.exercise_id FROM  body_part_exercise t ",
	pagingSelect="SELECT t.body_part_exercise_id, t.body_part_id, t.exercise_id FROM  body_part_exercise t  {criteria} LIMIT {offset}, {pageSize}")
public class BodyPartExerciseDBMapper extends MySQLDBMapper  {
	
	public BodyPartExerciseDBMapper(Connection c) {
		super(c);
	}
	public BodyPartExerciseDBMapper() {
                // empty constructor, used in dynamic instantiations
		// will get a connection from the ApplicationService
		super();
	}
	
	/**
	* Clients can override this to return a custom class for loading
	*/
	public BodyPartExercise getInstanceForLoad() {
		
		return new BodyPartExercise();
		
	}
		
	public ModelObject load(Object ors) {
		
		ResultSet rs = (ResultSet)ors;
		
		BodyPartExercise ret = this.getInstanceForLoad();
		try {
			ret.setLoading(true);
			
			ret.setBodyPartExerciseId(readInt(rs,BodyPartExercise.FLD_BODY_PART_EXERCISE_ID));
			ret.setBodyPartId(readInt(rs,BodyPartExercise.FLD_BODY_PART_ID));
			ret.setExerciseId(readInt(rs,BodyPartExercise.FLD_EXERCISE_ID));

			
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());		
		
		}
		ret.setLoading(false);
		ret.setNew(false); // since we load from database, we mark as "old"
		return ret;
    
    }
	 
	
	



	
	@Override
	public void fillStatement(ModelObject obj, CallableStatement stmt, boolean bForInsert) throws Exception {
		
		BodyPartExercise o = (BodyPartExercise)obj;
		
		if (o.getBodyPartId()==null){
			stmt.setNull(1, Types.VARCHAR);
		}else{
			stmt.setInt(1,o.getBodyPartId());
		}
		if (o.getExerciseId()==null){
			stmt.setNull(2, Types.VARCHAR);
		}else{
			stmt.setInt(2,o.getExerciseId());
		}


		/* PRIMARY KEY FIELD HANDLED BELOW AND SHOULD ALAWAYS BE THE LAST PARAMETER IN THE SQL */
		if (bForInsert){
		 /* No Need to pass anything For INSERTS.  MySQL will assign an autoincrement value, and the MySQLDBMapper will receive it.*/
		} else {
		 /* For Update statement*/
			stmt.setInt(3,o.getBodyPartExerciseId().intValue());
		}


	}
	

	
	
	/**
	 * Method used by generated accessor methods of 1-many associations.
	 * It retrieves the object collection using the ApplicationService connection, or 
	 * if that is null, it opens and closes a connection
	 * @param swhere SQL where clause
	 * @param params Parameter array
	 * @return a ModelObjectList of BodyPartExercise objects loaded from database
	 */
	 public static ModelObjectList<BodyPartExercise> getAll(String swhere, Object ... params)  {
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
			BodyPartExerciseDBMapper adb = new BodyPartExerciseDBMapper(c);
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
	 * @return a single BodyPartExercise object loaded from database
	 */
	public static BodyPartExercise get(String swhere, Object ... params)  {
		
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
			BodyPartExerciseDBMapper adb = new BodyPartExerciseDBMapper(c);
			return (BodyPartExercise)adb.findOne(swhere, params);
		
		}catch (MOTranslatedValidationException moe) {
			throw moe;
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(bCloseConn)DBUtils.closeQuietly(c);
			//// only close the connection if we opened it.
		}
	}
	
	
	public static BodyPartExercise getByKey(final Object pkey)  {
		
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

			BodyPartExerciseDBMapper adb = new BodyPartExerciseDBMapper(c);
			return (BodyPartExercise)adb.find(pkey);
		
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