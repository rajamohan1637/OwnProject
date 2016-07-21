package com.examportal.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.examportal.dto.AnswersDTO;
import com.examportal.dto.QtonDTO;
import com.examportal.jdbc.MyJDBCClass;

public class QtonFetchClass {

	private String query = "select * from examination.USER_QUESTIONS";

	Connection conn = null;
	PreparedStatement pstmt = null;
	boolean qStatus = false;
	ResultSet rs = null;

	String str = null;
	String priStr = null;
	int priority = 0;
	int sNo = 0;
	
	public int getPriority() {
		return priority;
	}

	public int getsNo() {
		return sNo;
	}

	public ArrayList<QtonDTO> getQtonArrayList() {
		ArrayList<QtonDTO> qList = new ArrayList<QtonDTO>();
		ArrayList<String> qAns = new ArrayList<String>(); 
		AnswersDTO adto = new  AnswersDTO();
		try {
			conn = MyJDBCClass.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QtonDTO qdto = new QtonDTO();
				priStr = rs.getString("PRIORITY");
				priority = Integer.parseInt(priStr);
				str = rs.getString("qton_id");

				qdto.setNum(Integer.parseInt(str));
				qdto.setQton(rs.getString("qton"));
				qdto.setOpt1(rs.getString("A"));
				qdto.setOpt2(rs.getString("B"));
				qdto.setOpt3(rs.getString("C"));
				qdto.setOpt4(rs.getString("D"));
				qdto.setAnswer(rs.getString("ANS"));  
				qdto.setPriority(priority);
				qAns.add(rs.getString("ANS"));
				qList.add(qdto);			
			}
			adto.setqAns(qAns); 
			System.out.println("QLIST Size : " + qList.size());
			return qList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Set<QtonDTO> getQtonOnPriority(int priority) {
		ArrayList<QtonDTO> a = new QtonFetchClass().getQtonArrayList();
		Set<QtonDTO> final2 = new HashSet<QtonDTO>();
		Map<Integer, String> qtonAnsPair = new HashMap<Integer, String>(); 
		Integer qtonId = 0;
		String ansOpt = null;
		for(QtonDTO mydto : a){
			if(mydto.getPriority() == priority){
				System.out.println("Qton No : "+mydto.getNum()+ "\tInput parameter : "+priority);
				final2.add(mydto);
				//qtonAnsPair.put(mydto.getNum(), mydto.getAnswer());
			}
		}
		System.out.println("Set Size from JAVA : "+final2.size());
		return final2;
	}
	
	public HashMap<Integer, QtonDTO> getQtonList(int pri){
		
		Set<QtonDTO> setList = new QtonFetchClass().getQtonOnPriority(pri);
		HashMap<Integer, QtonDTO> mapList = new HashMap<Integer, QtonDTO>();
		for(QtonDTO dto : setList){
			mapList.put(dto.getNum(), dto);
		}
		return mapList;
	}
	

	@Override
	public int hashCode() {
		return getsNo();
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}
