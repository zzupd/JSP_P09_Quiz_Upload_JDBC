package pack.dto;

import java.sql.Timestamp;

public class DataBean {

	// DTO
	private int num ;
	private String subject;
	private String content;
	private String originalFile;
	private String uploadFile;
	private String fileType;
	private int fileSize;
	private Timestamp regTM;
	private String remoteIP;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOriginalFile() {
		return originalFile;
	}
	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}
	public String getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public Timestamp getRegTM() {
		return regTM;
	}
	public void setRegTM(Timestamp regTM) {
		this.regTM = regTM;
	}
	public String getRemoteIP() {
		return remoteIP;
	}
	public void setRemoteIP(String remoteIP) {
		// JDBC Insert에서는 직접 입력
		this.remoteIP = remoteIP;
	}

}
