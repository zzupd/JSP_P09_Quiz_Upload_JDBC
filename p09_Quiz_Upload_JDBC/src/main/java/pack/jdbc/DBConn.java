package pack.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import pack.dto.DataBean;

public class DBConn {
	// DAO
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	// DB 접속용 메서드
	public Connection mtdDBConn() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/fileUp?";
			url += "useSSL=false&";
			url += "useUnicode=true&";
			url += "characterEncoding=UTF8&";
			url += "serverTimezone=Asia/Seoul&";
			url += "allowPublicKeyRetrieval=true";

			String uid = "root";
			String upw = "1234";

			conn = DriverManager.getConnection(url, uid, upw);
			// Select 실행 및 출력영역 시작

		} catch (ClassNotFoundException e) {
			System.out.print(e.getMessage());
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return conn;

	}
	
	
	// 입력용 메서드 시작
	public boolean mtdInsert(HttpServletRequest req, DataBean dataBean) {
		
//		rtnData[0] = subject;
//		rtnData[1] = content;
//		rtnData[2] = originalFile;
//		rtnData[3] = uploadFile;
//		rtnData[4] = fileType;
//		rtnData[5] = fSize;
		
		String remoteIp = req.getRemoteAddr();
		
		boolean chk =false;
		try {
			String sql = "insert into uploadTbl ";
			sql += "(subject, content, originalFile, ";
			sql += "uploadFile, fileType, fileSize, remoteIP) ";
			sql += "values (?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dataBean.getSubject());
			pstmt.setString(2, dataBean.getContent());
			pstmt.setString(3, dataBean.getOriginalFile());
			pstmt.setString(4, dataBean.getUploadFile());
			pstmt.setString(5, dataBean.getFileType());
			pstmt.setInt(6, dataBean.getFileSize());
			pstmt.setString(7, remoteIp);
			int rtnCnt = pstmt.executeUpdate();
			if(rtnCnt == 1) {
				chk = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chk;
	}
	
	// 입력용 메서드  끝

}






