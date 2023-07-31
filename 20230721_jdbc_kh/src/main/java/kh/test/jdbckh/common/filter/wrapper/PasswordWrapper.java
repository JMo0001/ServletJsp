package kh.test.jdbckh.common.filter.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PasswordWrapper extends HttpServletRequestWrapper{

	public PasswordWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {

		if(name!=null && name.equals("pwd")) {	//request.getParameter("pwd") 가 호출되면
			System.out.println("[ejkim] 암호화전 "+name.length()+", "+name);
			name = getSha512(super.getParameter(name));	//88자 String << 아래 메소드에 의해서.
		} else {	//request.getParameter("pwd외 다른이름") 가 호출되면
			name=super.getParameter(name);
		}
		System.out.println("[ejkim] 암호화후 "+name.length()+", "+name);
		return name;
	}
	
	private String getSha512(String pwd) {
		String result = null;
		//SHA-512 암호화 메소드
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");	//singleton
			byte[] pwdBytes = pwd.getBytes(Charset.forName("UTF-8"));
			md.update(pwdBytes);	// 암호화.
			// 암호화된 byte[] 를 다시 String 형으로 변형
			result = Base64.getEncoder().encodeToString(pwdBytes);	//88자 String 형태.
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
