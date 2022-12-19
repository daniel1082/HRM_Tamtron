package com.hrm.genericUtility;

/**
 * This Interface contains all the excel file, Property file and Database paths
 * @author daniel
 *
 */
public interface IConstantPath {
	String EXCEL_PATH="./src/test/resources/TestData.xlsx";
	String PROPERTY_FILE_PATH="./src/test/resources/CommonData.properties";
	String DATABASE_URL="jdbc:mysql://localhost:3306/sdet44";
	String DATABASE_USERNAME="root";
	String DATABASE_PASSWORD="tiger";
	String TESTFILE_PATH = "./src/test/resources/hrm points.docx";
	String TESTIMAGE_PATH= "./src/test/resources/depositphotos_123605182-stock-photo-software-testing-concept-golden-metallic.jpg";
}
