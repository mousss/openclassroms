package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 *
 * The implementation does not need to order the list
 *
 */
public interface ISymptomReader {
	List<String> GetSymptoms () throws IOException;
	String getNameFileSymptoms() throws IOException;
	Set<String> getDistinctSymptoms(List<String> list);
}
