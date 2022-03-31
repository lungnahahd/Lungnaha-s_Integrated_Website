package com.Lungnaha.IntegratedWebsite.mvc;


import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.*;
import java.io.IOException;
import java.text.*;


import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

//import sun.security.util.Length;



@Controller
public class InfoController {
	
	@RequestMapping("/search.do")
	public String login(HttpServletRequest request) throws IOException {
		System.out.println("Spring MVC 구조 ==> 크롤링 테스트");
		System.out.println(request.getParameter("want"));
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
		Date currentTime = new Date();
		
		String dTime = formatter.format(currentTime);
		String e_date = dTime;
		
		currentTime.setDate(currentTime.getDate() - 1);
		String s_date = formatter.format(currentTime);
		String query = request.getParameter("want");
		String s_from = s_date.replace(".", "");
		String e_to = e_date.replace(".", "");
		int page = 1;
		ArrayList<String> al1 = new ArrayList<>();
		ArrayList<String> al2 = new ArrayList<>();
		List<String> al3 = new ArrayList<>();
		while (page < 10) {
			String address = "https://search.naver.com/search.naver?where=news&query=" + query;
			Document rawData = Jsoup.connect(address).timeout(5000).get();
			System.out.println(rawData);
			System.out.println(address);
			//Elements blogOption = rawData.select("dl dt");
			Elements blogOption = rawData.select("li");
			String realURL = "";
			String realTITLE = "";
			
			for(Element option : blogOption) {
				realURL = option.select("a").attr("href");
				realTITLE = option.select("a").attr("title");
				System.out.println(realTITLE);
				al1.add(realURL);
				al2.add(realTITLE);
				
				//System.out.println(al1);
				//System.out.println(al2);
			}
			page += 10;
			al3 = al2.subList(32, al1.size());
			System.out.println(al3);
			System.out.println(al1);
			System.out.println(al2);
			
		}
	
		
		
		
		
		
		
		return ".jsp";
		 
	}
}
