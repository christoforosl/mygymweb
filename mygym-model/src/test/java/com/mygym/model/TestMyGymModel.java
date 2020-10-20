package com.mygym.model;
import com.netu.lib.ApplicationService;
import com.netu.lib.DBUtils;
import com.netu.lib.Model.ModelObject;
import com.netu.lib.db.ConnectionPool;

import java.sql.Connection;
import org.json.JSONObject;

import com.mygym.model.ExerciseDefinition;
import com.mygym.model.ExerciseDefinitionDBMapper;
import com.mygym.model.BodyPart;
import com.mygym.model.BodyPartDBMapper;
import com.mygym.model.ExerciseTypeLink;
import com.mygym.model.ExerciseTypeLinkDBMapper;
import com.mygym.model.BodyPartExercise;
import com.mygym.model.BodyPartExerciseDBMapper;
import com.mygym.model.ExerciseType;
import com.mygym.model.ExerciseTypeDBMapper;


import javax.annotation.Generated;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.netu.lib.TestUtils;

@Generated(
        value = {"com.netu.codeGen.XMLModelGenerator, Version 3"},
        comments = "junit tests ",
        date = "Tue Oct 20 21:24:13 EEST 2020"
    ) 
/**
 * Class autogenerated on <DATE>Tue Oct 20 21:24:13 EEST 2020</DATE> by com.netu.codeGen.XMLModelGenerator.
 * This class is used to test all modelobjects for project 
 * <b>DO NOT change code in this class.</b> 
 */
public class TestMyGymModel {
	
	java.util.Properties testProps = com.netu.lib.NetuUtils.getProperties("nuftests.properties");

    //Use TestInitialize to run code before running each test
    @BeforeClass
    public static void setUp()  throws Exception  {
		TestUtils.configureNUFTestsForOracle();
		Connection c = ConnectionPool.getConn();
        ApplicationService.newCurrent(c, "test");
		
    }
	
    @AfterClass
    public static void tearDown() {
		ApplicationService.release();
    }

    @Test
	public void testExerciseDefinition() throws Exception  {
        
		ApplicationService.beginTrans();
		System.err.println("testing ExerciseDefinition"  );
		try {
			
			final ExerciseDefinitionDBMapper pdb = new ExerciseDefinitionDBMapper();
			final String newvals = (String) testProps.get("ExerciseDefinitionNew");
			
			if (newvals !=null ) {
				// to test put this in nuafTests.properties
				// ExerciseDefinitionNew={"Name":"","VideoUrl":"", }
				JSONObject jsn = new JSONObject(newvals);
				ExerciseDefinition newmo = new ExerciseDefinition();
					
			newmo.setName(jsn.optString("Name",null));
			newmo.setVideoUrl(jsn.optString("VideoUrl",null));

				pdb.save(newmo);  // save new record
				newmo.setDirty(true); // make dirty so we test update
				pdb.save(newmo);  // this will do update

				final Object newmoId = newmo.getId();
				Assert.assertNotNull(newmoId);
				pdb.delete( newmo ); // this will do delete

				Assert.assertNull(pdb.find(newmoId));	
				
			} else {	

				final Object pid = DBUtils.getValue("select EXERCISE_DEFINITION_ID from exercise_definition  limit 1,1");
				if(pid!=null) {	

					ExerciseDefinition p = (ExerciseDefinition)pdb.findOne("EXERCISE_DEFINITION_ID=?",pid);
					final ExerciseDefinition p2 =  (ExerciseDefinition)p.clone();			
			
			Assert.assertEquals("Expected Field NAME to be equal",p.getName(), p2.getName());
			Assert.assertEquals("Expected Field VIDEO_URL to be equal",p.getVideoUrl(), p2.getVideoUrl());

					p.setDirty(true); //force save
					pdb.save(p);

					//now reload object from database
					p = (ExerciseDefinition)pdb.findOne("EXERCISE_DEFINITION_ID=?",pid);
					Assert.assertNotNull( p );
				} else { 
					System.err.println("  --Warning: No records found of type ExerciseDefinition"  );
				}

			}

		} finally {
			ApplicationService.rollbackTrans();
			// note: do not release here! It happens in tear down
		}
            
        
    }

    @Test
	public void testBodyPart() throws Exception  {
        
		ApplicationService.beginTrans();
		System.err.println("testing BodyPart"  );
		try {
			
			final BodyPartDBMapper pdb = new BodyPartDBMapper();
			final String newvals = (String) testProps.get("BodyPartNew");
			
			if (newvals !=null ) {
				// to test put this in nuafTests.properties
				// BodyPartNew={"BodyPartNAME":"", }
				JSONObject jsn = new JSONObject(newvals);
				BodyPart newmo = new BodyPart();
					
			newmo.setBodyPartNAME(jsn.optString("BodyPartNAME",null));

				pdb.save(newmo);  // save new record
				newmo.setDirty(true); // make dirty so we test update
				pdb.save(newmo);  // this will do update

				final Object newmoId = newmo.getId();
				Assert.assertNotNull(newmoId);
				pdb.delete( newmo ); // this will do delete

				Assert.assertNull(pdb.find(newmoId));	
				
			} else {	

				final Object pid = DBUtils.getValue("select body_part_id from body_part  limit 1,1");
				if(pid!=null) {	

					BodyPart p = (BodyPart)pdb.findOne("body_part_id=?",pid);
					final BodyPart p2 =  (BodyPart)p.clone();			
			
			Assert.assertEquals("Expected Field body_part_NAME to be equal",p.getBodyPartNAME(), p2.getBodyPartNAME());

					p.setDirty(true); //force save
					pdb.save(p);

					//now reload object from database
					p = (BodyPart)pdb.findOne("body_part_id=?",pid);
					Assert.assertNotNull( p );
				} else { 
					System.err.println("  --Warning: No records found of type BodyPart"  );
				}

			}

		} finally {
			ApplicationService.rollbackTrans();
			// note: do not release here! It happens in tear down
		}
            
        
    }

    @Test
	public void testExerciseTypeLink() throws Exception  {
        
		ApplicationService.beginTrans();
		System.err.println("testing ExerciseTypeLink"  );
		try {
			
			final ExerciseTypeLinkDBMapper pdb = new ExerciseTypeLinkDBMapper();
			final String newvals = (String) testProps.get("ExerciseTypeLinkNew");
			
			if (newvals !=null ) {
				// to test put this in nuafTests.properties
				// ExerciseTypeLinkNew={"ExerciseTypeId":"","ExerciseId":"", }
				JSONObject jsn = new JSONObject(newvals);
				ExerciseTypeLink newmo = new ExerciseTypeLink();
					
			newmo.setExerciseTypeId(jsn.optString("ExerciseTypeId",null));
			newmo.setExerciseId(jsn.optString("ExerciseId",null));

				pdb.save(newmo);  // save new record
				newmo.setDirty(true); // make dirty so we test update
				pdb.save(newmo);  // this will do update

				final Object newmoId = newmo.getId();
				Assert.assertNotNull(newmoId);
				pdb.delete( newmo ); // this will do delete

				Assert.assertNull(pdb.find(newmoId));	
				
			} else {	

				final Object pid = DBUtils.getValue("select exercise_type_link_id from exercise_type_link  limit 1,1");
				if(pid!=null) {	

					ExerciseTypeLink p = (ExerciseTypeLink)pdb.findOne("exercise_type_link_id=?",pid);
					final ExerciseTypeLink p2 =  (ExerciseTypeLink)p.clone();			
			
			Assert.assertEquals("Expected Field exercise_type_id to be equal",p.getExerciseTypeId(), p2.getExerciseTypeId());
			Assert.assertEquals("Expected Field exercise_id to be equal",p.getExerciseId(), p2.getExerciseId());

					p.setDirty(true); //force save
					pdb.save(p);

					//now reload object from database
					p = (ExerciseTypeLink)pdb.findOne("exercise_type_link_id=?",pid);
					Assert.assertNotNull( p );
				} else { 
					System.err.println("  --Warning: No records found of type ExerciseTypeLink"  );
				}

			}

		} finally {
			ApplicationService.rollbackTrans();
			// note: do not release here! It happens in tear down
		}
            
        
    }

    @Test
	public void testBodyPartExercise() throws Exception  {
        
		ApplicationService.beginTrans();
		System.err.println("testing BodyPartExercise"  );
		try {
			
			final BodyPartExerciseDBMapper pdb = new BodyPartExerciseDBMapper();
			final String newvals = (String) testProps.get("BodyPartExerciseNew");
			
			if (newvals !=null ) {
				// to test put this in nuafTests.properties
				// BodyPartExerciseNew={"BodyPartId":"","ExerciseId":"", }
				JSONObject jsn = new JSONObject(newvals);
				BodyPartExercise newmo = new BodyPartExercise();
					
			newmo.setBodyPartId(jsn.optString("BodyPartId",null));
			newmo.setExerciseId(jsn.optString("ExerciseId",null));

				pdb.save(newmo);  // save new record
				newmo.setDirty(true); // make dirty so we test update
				pdb.save(newmo);  // this will do update

				final Object newmoId = newmo.getId();
				Assert.assertNotNull(newmoId);
				pdb.delete( newmo ); // this will do delete

				Assert.assertNull(pdb.find(newmoId));	
				
			} else {	

				final Object pid = DBUtils.getValue("select body_part_exercise_id from body_part_exercise  limit 1,1");
				if(pid!=null) {	

					BodyPartExercise p = (BodyPartExercise)pdb.findOne("body_part_exercise_id=?",pid);
					final BodyPartExercise p2 =  (BodyPartExercise)p.clone();			
			
			Assert.assertEquals("Expected Field body_part_id to be equal",p.getBodyPartId(), p2.getBodyPartId());
			Assert.assertEquals("Expected Field exercise_id to be equal",p.getExerciseId(), p2.getExerciseId());

					p.setDirty(true); //force save
					pdb.save(p);

					//now reload object from database
					p = (BodyPartExercise)pdb.findOne("body_part_exercise_id=?",pid);
					Assert.assertNotNull( p );
				} else { 
					System.err.println("  --Warning: No records found of type BodyPartExercise"  );
				}

			}

		} finally {
			ApplicationService.rollbackTrans();
			// note: do not release here! It happens in tear down
		}
            
        
    }

    @Test
	public void testExerciseType() throws Exception  {
        
		ApplicationService.beginTrans();
		System.err.println("testing ExerciseType"  );
		try {
			
			final ExerciseTypeDBMapper pdb = new ExerciseTypeDBMapper();
			final String newvals = (String) testProps.get("ExerciseTypeNew");
			
			if (newvals !=null ) {
				// to test put this in nuafTests.properties
				// ExerciseTypeNew={"ExerciseType":"", }
				JSONObject jsn = new JSONObject(newvals);
				ExerciseType newmo = new ExerciseType();
					
			newmo.setExerciseType(jsn.optString("ExerciseType",null));

				pdb.save(newmo);  // save new record
				newmo.setDirty(true); // make dirty so we test update
				pdb.save(newmo);  // this will do update

				final Object newmoId = newmo.getId();
				Assert.assertNotNull(newmoId);
				pdb.delete( newmo ); // this will do delete

				Assert.assertNull(pdb.find(newmoId));	
				
			} else {	

				final Object pid = DBUtils.getValue("select exercise_type_id from exercise_type  limit 1,1");
				if(pid!=null) {	

					ExerciseType p = (ExerciseType)pdb.findOne("exercise_type_id=?",pid);
					final ExerciseType p2 =  (ExerciseType)p.clone();			
			
			Assert.assertEquals("Expected Field exercise_type to be equal",p.getExerciseType(), p2.getExerciseType());

					p.setDirty(true); //force save
					pdb.save(p);

					//now reload object from database
					p = (ExerciseType)pdb.findOne("exercise_type_id=?",pid);
					Assert.assertNotNull( p );
				} else { 
					System.err.println("  --Warning: No records found of type ExerciseType"  );
				}

			}

		} finally {
			ApplicationService.rollbackTrans();
			// note: do not release here! It happens in tear down
		}
            
        
    }



}