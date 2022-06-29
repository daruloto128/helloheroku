package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Danilo
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {
	
	Calendar calendar = new GregorianCalendar();

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String lang = request.getParameter("lang");
        if(lang==null) {
        	lang = "por";
        }

        String ola = this.cumprimentos(lang);
        
        String nome = request.getParameter("nome");
        if(nome == "") {
        	nome = "Fulano";	
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" +ola+nome+ "!</h1>"+"Horario: "+calendar.get((Calendar.HOUR_OF_DAY)));            
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String lang = request.getParameter("lang");
        if(lang==null) {
        	lang = "por";        	
        }

        String ola = this.cumprimentos(lang);
        
        String nome = request.getParameter("nome");
        if(nome == "") {
        	nome = "Fulano";
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" +ola+nome+"!</h1>"+"Horario: "+calendar.get((Calendar.HOUR_OF_DAY)));            
            out.println("</body>");
            out.println("</html>");
        }
    }

    public String cumprimentos(String lang) {
    	String msg = "";
    	switch (lang) {
    	case "":
        case "pt":
        	if(calendar.get(Calendar.HOUR_OF_DAY) <= 12) {
        		msg = "Bom dia, ";
        	}else if(calendar.get((Calendar.HOUR_OF_DAY)) > 12 && (calendar.get(Calendar.HOUR_OF_DAY) <= 18)) {
        		msg = "Boa tarde, ";
        	}else if(calendar.get(Calendar.HOUR_OF_DAY) > 18){
        		msg = "Boa noite, ";
        	}	        	
            break;
        case "en":
        	if(calendar.get(Calendar.HOUR_OF_DAY) <= 12) {
        		msg = "Good morning, ";
        	}else if(calendar.get((Calendar.HOUR_OF_DAY)) > 12 && (calendar.get(Calendar.HOUR_OF_DAY) <= 18)) {
        		msg = "Good afternoon, ";
        	}else if(calendar.get(Calendar.HOUR_OF_DAY) > 18){
        		msg = "Good night, ";
        	}	  
            break;
        case "fr":
        	if(calendar.get(Calendar.HOUR_OF_DAY) <= 12) {
        		msg = "Bonjour, ";
        	}else if(calendar.get((Calendar.HOUR_OF_DAY)) > 12 && (calendar.get(Calendar.HOUR_OF_DAY) <= 18)) {
        		msg = "Bonne aprï¿½s-midi, ";
        	}else if(calendar.get(Calendar.HOUR_OF_DAY) > 18){
        		msg = "Bonne nuit, ";
        	}
            break;
        case "de":
        	if(calendar.get(Calendar.HOUR_OF_DAY) <= 12) {
        		msg = "Guten Morgen, ";
        	}else if(calendar.get((Calendar.HOUR_OF_DAY)) > 12 && (calendar.get(Calendar.HOUR_OF_DAY) <= 18)) {
        		msg = "Guten Nachmittag, ";
        	}else if(calendar.get(Calendar.HOUR_OF_DAY) > 18){
        		msg = "Gute Nacht, ";
        	}	
            break;
        case "es":
        	if(calendar.get(Calendar.HOUR_OF_DAY) <= 12) {
        		msg = "Buenos dias, ";
        	}else if(calendar.get((Calendar.HOUR_OF_DAY)) > 12 && (calendar.get(Calendar.HOUR_OF_DAY) <= 18)) {
        		msg = "Buenas tardes, ";
        	}else if(calendar.get(Calendar.HOUR_OF_DAY) > 18){
        		msg = "Buenas noches, ";
        	}
            break;
        case "no":
        	if(calendar.get(Calendar.HOUR_OF_DAY) <= 12) {
        		msg = "God morgen, ";
        	}else if(calendar.get((Calendar.HOUR_OF_DAY)) > 12 && (calendar.get(Calendar.HOUR_OF_DAY) <= 18)) {
        		msg = "God ettermiddag, ";
        	}else if(calendar.get(Calendar.HOUR_OF_DAY) > 18){
        		msg = "God natt, ";
        	}	 
        case "jp":
        	if(calendar.get(Calendar.HOUR_OF_DAY) <= 12) {
        		msg = "Ohayō, ";
        	}else if(calendar.get((Calendar.HOUR_OF_DAY)) > 12 && (calendar.get(Calendar.HOUR_OF_DAY) <= 18)) {
        		msg = "Kon'nichiwa, ";
        	}else if(calendar.get(Calendar.HOUR_OF_DAY) > 18){
        		msg = "Oyasumi, ";
        	}	
            break;
		default:
			msg = "Erro - Opção inválida! Tente novamente.";
			break;
		}
    	
    	return msg;
    }
}
