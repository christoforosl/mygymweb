package com.mygym.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class autogenerated on <DATE>Tue Oct 20 21:24:13 EEST 2020</DATE> by com.netu.codeGen.XMLModelGenerator
 * Feel Free to change the generated code. 
 */
public class ExerciseDefinition extends ExerciseDefinitionModelBase  {
	
	public List<String> getBodyParts() {
		return this.getBodyPartsAffected().stream()
				.map( x -> x.getBodyPart()!=null ? x.getBodyPart().getBodyPartName(): null)
				.collect(Collectors.toList());
	}
	public List<String> getTypes() {
		return this.getExerciseTypes().stream()
				.map( x -> x.getExerciseType()!=null ? x.getExerciseType().getExerciseType(): null)
				.collect(Collectors.toList());
	}
  
}
