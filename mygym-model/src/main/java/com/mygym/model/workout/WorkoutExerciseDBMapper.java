package com.mygym.model.workout;

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
 * Class for Database Data Mapper Pattern for table <b>workout_exercise</b>.<br>
 * <b>!!!!!!!! DO NOT MODIFY CODE OF THIS CLASS!!!!!!!!</b><br>
 * This class has the responsibility of loading 
 * data into Model Objects, and saving them back to 
 * the Database
 */
@Generated(
        value = {"com.netu.codeGen.XMLModelGenerator"},
        comments = "Mapper Object for table workout_exercise ",
        date = "Wed Jan 20 12:07:47 EET 2021"
    )
@DMLQueries(
	update="update workout_exercise set workout_id=?,sequence=?,exercise_id=?,number_of_sets=?,repetitions_each_set=?,duration_seconds=?,rest_seconds=?,create_date=?,update_date=?,create_user=?,update_user=? where workout_exercise_id=?",
	updateRowid="",
	delete="DELETE FROM workout_exercise WHERE workout_exercise_id=?",
	deleteRowid="",
	insert="insert into workout_exercise (workout_id,sequence,exercise_id,number_of_sets,repetitions_each_set,duration_seconds,rest_seconds,create_date,update_date,create_user,update_user) values (?,?,?,?,?,?,?,?,?,?,?)",
	selectone="SELECT t.workout_exercise_id, t.workout_id, t.sequence, t.exercise_id, t.number_of_sets, t.repetitions_each_set, t.duration_seconds, t.rest_seconds, t.create_date, t.update_date, t.create_user, t.update_user FROM  workout_exercise t  WHERE workout_exercise_id=?",
	selectall="SELECT t.workout_exercise_id, t.workout_id, t.sequence, t.exercise_id, t.number_of_sets, t.repetitions_each_set, t.duration_seconds, t.rest_seconds, t.create_date, t.update_date, t.create_user, t.update_user FROM  workout_exercise t ",
	pagingSelect="SELECT t.workout_exercise_id, t.workout_id, t.sequence, t.exercise_id, t.number_of_sets, t.repetitions_each_set, t.duration_seconds, t.rest_seconds, t.create_date, t.update_date, t.create_user, t.update_user FROM  workout_exercise t  {criteria} LIMIT {offset}, {pageSize}")
public class WorkoutExerciseDBMapper extends MySQLDBMapper  {
	
	public WorkoutExerciseDBMapper(Connection c) {
		super(c);
	}
	public WorkoutExerciseDBMapper() {
                // empty constructor, used in dynamic instantiations
		// will get a connection from the ApplicationService
		super();
	}
	
	/**
	* Clients can override this to return a custom class for loading
	*/
	public WorkoutExercise getInstanceForLoad() {
		
		return new WorkoutExercise();
		
	}
		
	public ModelObject load(Object ors) {
		
		ResultSet rs = (ResultSet)ors;
		
		WorkoutExercise ret = this.getInstanceForLoad();
		try {
			ret.setLoading(true);
			
			ret.setWorkoutExerciseId(readInt(rs,WorkoutExercise.FLD_WORKOUT_EXERCISE_ID));
			ret.setWorkoutId(readInt(rs,WorkoutExercise.FLD_WORKOUT_ID));
			ret.setSequence(readInt(rs,WorkoutExercise.FLD_SEQUENCE));
			ret.setExerciseId(readInt(rs,WorkoutExercise.FLD_EXERCISE_ID));
			ret.setNumberOfSets(readInt(rs,WorkoutExercise.FLD_NUMBER_OF_SETS));
			ret.setRepetitionsEachSet(readInt(rs,WorkoutExercise.FLD_REPETITIONS_EACH_SET));
			ret.setDurationSeconds(readInt(rs,WorkoutExercise.FLD_DURATION_SECONDS));
			ret.setRestSeconds(readInt(rs,WorkoutExercise.FLD_REST_SECONDS));
			ret.setCreateDate(readTimeStamp(rs,WorkoutExercise.FLD_CREATE_DATE));
			ret.setUpdateDate(readTimeStamp(rs,WorkoutExercise.FLD_UPDATE_DATE));
			ret.setCreateUser(rs.getString(WorkoutExercise.FLD_CREATE_USER));
			ret.setUpdateUser(rs.getString(WorkoutExercise.FLD_UPDATE_USER));

			
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());		
		
		}
		ret.setLoading(false);
		ret.setNew(false); // since we load from database, we mark as "old"
		return ret;
    
    }
	 
	
	



	
	@Override
	public void fillStatement(ModelObject obj, CallableStatement stmt, boolean bForInsert) throws Exception {
		
		WorkoutExercise o = (WorkoutExercise)obj;
		
		if (o.getWorkoutId()==null){
			stmt.setNull(1, Types.VARCHAR);
		}else{
			stmt.setInt(1,o.getWorkoutId());
		}
		if (o.getSequence()==null){
			stmt.setNull(2, Types.VARCHAR);
		}else{
			stmt.setInt(2,o.getSequence());
		}
		if (o.getExerciseId()==null){
			stmt.setNull(3, Types.VARCHAR);
		}else{
			stmt.setInt(3,o.getExerciseId());
		}
		if (o.getNumberOfSets()==null){
			stmt.setNull(4, Types.VARCHAR);
		}else{
			stmt.setInt(4,o.getNumberOfSets());
		}
		if (o.getRepetitionsEachSet()==null){
			stmt.setNull(5, Types.VARCHAR);
		}else{
			stmt.setInt(5,o.getRepetitionsEachSet());
		}
		if (o.getDurationSeconds()==null){
			stmt.setNull(6, Types.VARCHAR);
		}else{
			stmt.setInt(6,o.getDurationSeconds());
		}
		if (o.getRestSeconds()==null){
			stmt.setNull(7, Types.VARCHAR);
		}else{
			stmt.setInt(7,o.getRestSeconds());
		}
		if (o.getCreateDate()==null){
			stmt.setNull(8, Types.VARCHAR);
		}else{
			stmt.setTimestamp(8, new java.sql.Timestamp( o.getCreateDate().getTime()));
		}
		if (o.getUpdateDate()==null){
			stmt.setNull(9, Types.VARCHAR);
		}else{
			stmt.setTimestamp(9, new java.sql.Timestamp( o.getUpdateDate().getTime()));
		}
		if (o.getCreateUser()==null){
			stmt.setNull(10, Types.VARCHAR);
		}else{
			stmt.setString(10,o.getCreateUser());
		}
		if (o.getUpdateUser()==null){
			stmt.setNull(11, Types.VARCHAR);
		}else{
			stmt.setString(11,o.getUpdateUser());
		}


		/* PRIMARY KEY FIELD HANDLED BELOW AND SHOULD ALAWAYS BE THE LAST PARAMETER IN THE SQL */
		if (bForInsert){
		 /* No Need to pass anything For INSERTS.  MySQL will assign an autoincrement value, and the MySQLDBMapper will receive it.*/
		} else {
		 /* For Update statement*/
			stmt.setInt(12,o.getWorkoutExerciseId().intValue());
		}


	}
	

	
	
	/**
	 * Method used by generated accessor methods of 1-many associations.
	 * It retrieves the object collection using the ApplicationService connection, or 
	 * if that is null, it opens and closes a connection
	 * @param swhere SQL where clause
	 * @param params Parameter array
	 * @return a ModelObjectList of WorkoutExercise objects loaded from database
	 */
	 public static ModelObjectList<WorkoutExercise> getAll(String swhere, Object ... params)  {
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
			WorkoutExerciseDBMapper adb = new WorkoutExerciseDBMapper(c);
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
	 * @return a single WorkoutExercise object loaded from database
	 */
	public static WorkoutExercise get(String swhere, Object ... params)  {
		
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
			WorkoutExerciseDBMapper adb = new WorkoutExerciseDBMapper(c);
			return (WorkoutExercise)adb.findOne(swhere, params);
		
		}catch (MOTranslatedValidationException moe) {
			throw moe;
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(bCloseConn)DBUtils.closeQuietly(c);
			//// only close the connection if we opened it.
		}
	}
	
	
	public static WorkoutExercise getByKey(final Object pkey)  {
		
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

			WorkoutExerciseDBMapper adb = new WorkoutExerciseDBMapper(c);
			return (WorkoutExercise)adb.find(pkey);
		
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