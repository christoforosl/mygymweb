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
 * Class autogenerated on <DATE>Tue Jan 19 18:01:34 EET 2021</DATE> by com.netu.codeGen.XMLModelGenerator.<br>
 * Class for Database Data Mapper Pattern for table <b>exercise_definition</b>.<br>
 * <b>!!!!!!!! DO NOT MODIFY CODE OF THIS CLASS!!!!!!!!</b><br>
 * This class has the responsibility of loading 
 * data into Model Objects, and saving them back to 
 * the Database
 */
@Generated(
        value = {"com.netu.codeGen.XMLModelGenerator"},
        comments = "Mapper Object for table exercise_definition ",
        date = "Tue Jan 19 18:01:34 EET 2021"
    )
@DMLQueries(
	update="update exercise_definition set NAME=?,VIDEO_URL=? where EXERCISE_DEFINITION_ID=?",
	updateRowid="",
	delete="DELETE FROM exercise_definition WHERE EXERCISE_DEFINITION_ID=?",
	deleteRowid="",
	insert="insert into exercise_definition (NAME,VIDEO_URL) values (?,?)",
	selectone="SELECT t.EXERCISE_DEFINITION_ID, t.NAME, t.VIDEO_URL FROM  exercise_definition t  WHERE EXERCISE_DEFINITION_ID=?",
	selectall="SELECT t.EXERCISE_DEFINITION_ID, t.NAME, t.VIDEO_URL FROM  exercise_definition t ",
	pagingSelect="SELECT t.EXERCISE_DEFINITION_ID, t.NAME, t.VIDEO_URL FROM  exercise_definition t  {criteria} LIMIT {offset}, {pageSize}")
public class ExerciseDefinitionDBMapper extends MySQLDBMapper  {
	
	public ExerciseDefinitionDBMapper(Connection c) {
		super(c);
	}
	public ExerciseDefinitionDBMapper() {
                // empty constructor, used in dynamic instantiations
		// will get a connection from the ApplicationService
		super();
	}
	
	/**
	* Clients can override this to return a custom class for loading
	*/
	public ExerciseDefinition getInstanceForLoad() {
		
		return new ExerciseDefinition();
		
	}
		
	public ModelObject load(Object ors) {
		
		ResultSet rs = (ResultSet)ors;
		
		ExerciseDefinition ret = this.getInstanceForLoad();
		try {
			ret.setLoading(true);
			
			ret.setExerciseDefinitionId(readInt(rs,ExerciseDefinition.FLD_EXERCISE_DEFINITION_ID));
			ret.setName(rs.getString(ExerciseDefinition.FLD_NAME));
			ret.setVideoUrl(rs.getString(ExerciseDefinition.FLD_VIDEO_URL));

			
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());		
		
		}
		ret.setLoading(false);
		ret.setNew(false); // since we load from database, we mark as "old"
		return ret;
    
    }
	 
	
	
	@Override
	public void saveChildren(ModelObject mo) {

		ExerciseDefinition ret = (ExerciseDefinition)mo;
		if (ret.bodyPartsAffectedLoaded()){
			BodyPartExerciseDBMapper bodypartsaffectedMapper= new BodyPartExerciseDBMapper(this.getConnection());
			bodypartsaffectedMapper.saveModelObjectList(ret.getBodyPartsAffected());
		}

		if (ret.exerciseTypesLoaded()){
			ExerciseTypeLinkDBMapper exercisetypesMapper= new ExerciseTypeLinkDBMapper(this.getConnection());
			exercisetypesMapper.saveModelObjectList(ret.getExerciseTypes());
		}

	}


	
	@Override
	public void fillStatement(ModelObject obj, CallableStatement stmt, boolean bForInsert) throws Exception {
		
		ExerciseDefinition o = (ExerciseDefinition)obj;
		
		if (o.getName()==null){
			stmt.setNull(1, Types.VARCHAR);
		}else{
			stmt.setString(1,o.getName());
		}
		if (o.getVideoUrl()==null){
			stmt.setNull(2, Types.VARCHAR);
		}else{
			stmt.setString(2,o.getVideoUrl());
		}


		/* PRIMARY KEY FIELD HANDLED BELOW AND SHOULD ALAWAYS BE THE LAST PARAMETER IN THE SQL */
		if (bForInsert){
		 /* No Need to pass anything For INSERTS.  MySQL will assign an autoincrement value, and the MySQLDBMapper will receive it.*/
		} else {
		 /* For Update statement*/
			stmt.setInt(3,o.getExerciseDefinitionId().intValue());
		}


	}
	

	
	
	/**
	 * Method used by generated accessor methods of 1-many associations.
	 * It retrieves the object collection using the ApplicationService connection, or 
	 * if that is null, it opens and closes a connection
	 * @param swhere SQL where clause
	 * @param params Parameter array
	 * @return a ModelObjectList of ExerciseDefinition objects loaded from database
	 */
	 public static ModelObjectList<ExerciseDefinition> getAll(String swhere, Object ... params)  {
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
			ExerciseDefinitionDBMapper adb = new ExerciseDefinitionDBMapper(c);
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
	 * @return a single ExerciseDefinition object loaded from database
	 */
	public static ExerciseDefinition get(String swhere, Object ... params)  {
		
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
			ExerciseDefinitionDBMapper adb = new ExerciseDefinitionDBMapper(c);
			return (ExerciseDefinition)adb.findOne(swhere, params);
		
		}catch (MOTranslatedValidationException moe) {
			throw moe;
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(bCloseConn)DBUtils.closeQuietly(c);
			//// only close the connection if we opened it.
		}
	}
	
	
	public static ExerciseDefinition getByKey(final Object pkey)  {
		
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

			ExerciseDefinitionDBMapper adb = new ExerciseDefinitionDBMapper(c);
			return (ExerciseDefinition)adb.find(pkey);
		
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