import html.Tag;
import html_generator.HtmlGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.xml.xpath.XPathExpressionException;

import org.jdom.JDOMException;
import org.joda.time.DateTime;

import parser.DukeCalParser;

import event.CalendarEvent;
import filter.*;
import html_generator.*;


public class Main {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, JDOMException{
		
		//this is the new parser
		DukeCalParser calendarParser = new DukeCalParser("dukecal.xml");
		ArrayList<CalendarEvent> list = calendarParser.parseFile();
		
		// Choose the method of filtering
		System.out.println("Please select and option (keyword or date):");
		Scanner in2 = new Scanner(System.in);
		String filterOption = in2.nextLine();
		
		Map<Object, ArrayList<CalendarEvent>> outputMap = new TreeMap<Object, ArrayList<CalendarEvent>>();

		String outputOption = "horizontal";
		
		HtmlGenerator tableCreator = new HtmlHorizontalTable(outputMap);
		HtmlGenerator headerCreator = new HtmlVerticalHeaders(outputMap);
		
		if (outputOption.equals("horizontal"))
			tableCreator.generateOutput();
		else if (outputOption.equals("vertical"))
			headerCreator.generateOutput();
	}

}
