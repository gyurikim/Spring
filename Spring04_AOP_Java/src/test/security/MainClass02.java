package test.security;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass02 {
	public static void main(String[] args) {
		//이전에 입력한 비밀번호라고 가정하자.
		String lastPwd="1234";
		//입력한 비밀번호를 암호화해서 저장된 비밀번호라고 가정하자.
		String encodePwd=new BCryptPasswordEncoder().encode(lastPwd);
		
		Scanner scan=new Scanner(System.in);
		System.out.print("비밀번호 입력 : ");
		String pwd=scan.nextLine();
		
		//비밀번호 일치 여부를 BCrypt클래스의 static메소드를 이용해서 얻어낸다
		boolean isValid=BCrypt.checkpw(pwd, encodePwd);
		
		if(isValid) {
			System.out.println("비밀번호가 일치해요!");
		}else {
			System.out.println("비밀번호가 틀려요! 다시 확인해 주세요");
		}
	}
}
