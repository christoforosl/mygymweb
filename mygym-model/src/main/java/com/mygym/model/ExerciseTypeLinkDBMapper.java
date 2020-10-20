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
 * Class for Database Data Mapper Pattern for table <b>exercise_type_link</b>.<br>
 * <b>!!!!!!!! DO NOT MODIFY CODE OF THIS CLASS!!!!!!!!</b><br>
 * This class has the responsibility of loading 
 * data into Model Objects, and saving them back to 
 * the Database
 */
@Generated(
        value = {"com.netu.codeGen.XMLModelGenerator"},
        comments = "Mapper Object for table exercise_type_link ",
        date = "Tue Oct 20 21:24:13 EEST 2020"
    )
@DMLQueries(
	update="update exercise_type_link set exercise_type_id=?,exercise_id=? where exercise_type_link_id=?",
	updateRowid="",
	delete="DELETE FROM exercise_type_link WHERE exercise_type_link_id=?",
	deleteRowid="",
	insert="insert into exercise_type_link (exercise_type_id,exercise_id) values (?,?)",
	selectone="SELECT t.exercise_type_link_id, t.exercise_type_id, t.exercise_id FROM  exercise_type_link t  WHERE exercise_type_link_id=?",
	selectall="SELECT t.exercise_type_link_id, t.exercise_type_id, t.exercise_id FROM  exercise_type_link t ",
	pagingSelect="SELECT t.exercise_type_link_id, t.exercise_type_id, t.exercise_id FROM  exercise_type_link t  {criteria} LIMIT {offset}, {pageSize}")
public class ExerciseTypeLinkDBMapper extends MySQLDBMapper  {
	
	public ExerciseTypeLinkDBMapper(Connection c) {
		super(c);
	}
	public ExerciseTypeLinkDBMapper() {
                // empty constructor, used in dynamic instantiations
		// will get a connection from the ApplicationService
		super();
	}
	
	/**
	* Clients can override this to return a custom class for loading
	*/
	public ExerciseTypeLink getInstanceForLoad() {
		
		return new ExerciseTypeLink();
		
	}
		
	public ModelObject load(Object ors) {
		
		ResultSet rs = (ResultSet)ors;
		
		ExerciseTypeLink ret = this.getInstanceForLoad();
		try {
			ret.setLoading(true);
			
			ret.setExerciseTypeLinkId(readInt(rs,ExerciseTypeLink.FLD_EXERCISE_TYPE_LINK_ID));
			ret.setExerciseTypeId(readInt(rs,ExerciseTypeLink.FLD_EXERCISE_TYPE_ID));
			ret.setExerciseId(readInt(rs,ExerciseTypeLink.FLD_EXERCISE_ID));

			
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());		
		
		}
		ret.setLoading(false);
		ret.setNew(false); // since we load from database, we mark as "old"
		return ret;
    
    }
	 
	
	



	
	@Override
	public void fillStatement(ModelObject obj, CallableStatement stmt, boolean bForInsert) throws Exception {
		
		ExerciseTypeLink o = (ExerciseTypeLink)obj;
		
		if (o.getExerciseTypeId()==null){
			stmt.setNull(1, Types.VARCHAR);
		}else{
			stmt.setInt(1,o.getExerciseTypeId());
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
			stmt.setInt(3,o.getExerciseTypeLinkId().intValue());
		}


	}
	

	
	
	/**
	 * Method used by generated accessor methods of 1-many associations.
	 * It retrieves the object collection using the ApplicationService connection, or 
	 * if that is null, it opens and closes a connection
	 * @param swhere SQL where clause
	 * @param params Parameter array
	 * @return a ModelObjectList of ExerciseTypeLink objects loaded from database
	 */
	 public static ModelObjectList<ExerciseTypeLink> getAll(String swhere, Object ... params)  {
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
			ExerciseTypeLinkDBMapper adb = new ExerciseTypeLinkDBMapper(c);
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
	 * @return a single ExerciseTypeLink object loaded from database
	 */
	public static ExerciseTypeLink get(String swhere, Object ... params)  {
		
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
			ExerciseTypeLinkDBMapper adb = new ExerciseTypeLinkDBMapper(c);
			return (ExerciseTypeLink)adb.findOne(swhere, params);
		
		}catch (MOTranslatedValidationException moe) {
			throw moe;
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(bCloseConn)DBUtils.closeQuietly(c);
			//// only close the connection if we opened it.
		}
	}
	
	
	public static ExerciseTypeLink getByKey(final Object pkey)  {
		
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

			ExerciseTypeLinkDBMapper adb = new ExerciseTypeLinkDBMapper(c);
			return (ExerciseTypeLink)adb.find(pkey);
		
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