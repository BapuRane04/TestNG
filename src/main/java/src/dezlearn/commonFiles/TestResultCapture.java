package src.dezlearn.commonFiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class TestResultCapture {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy hh:mm:ss");
	private static String timeStamp = dateFormat.format(new Date());
	public static String location = "";
	//static FileWriter writer;
	static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	static LocalDate date = LocalDate.now();
	static LocalTime time = LocalTime.now();
	static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH_mm");
	public static void testCaptureLogs(String testCaseName,String scenario,String actual,String expected,Boolean result) {
		try {
			
			
			String Result = (result)? "PASS":"FAIL";
			String dir = System.getProperty("user.dir")+File.separator+Result+File.separator+"Test-Result"+File.separator+scenario+File.separator+date.format(dateFormatter)+File.separator+time.format(timeFormatter);
			File directory = new File(dir);
			if(!directory.exists()) {
				directory.mkdirs();
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(dir+File.separator+testCaseName+".txt"),true));
	        writer.write("\n"+timeStamp+" : "+"Scenario: "+scenario+"\n"+"Actual Result: "+actual+"\n"+"Expected Result: "+expected+"\n Result: "+Result+"\n");
	        writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testCaseTitle(String scenario,String testcaseName,boolean result) throws IOException {
		String Result = (result)? "PASS":"FAIL";
		String dir = System.getProperty("user.dir")+File.separator+Result+File.separator+"Result"+File.separator+scenario+File.separator+date.format(dateFormatter)+File.separator+time.format(timeFormatter);
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(dir+File.separator+testcaseName+".txt"),true));
        writer.write("\n"+timeStamp+" : "+"-----------------------"+scenario+"-----------------------------------"+"\n");
        writer.close();
	}
}
