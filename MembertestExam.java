package membertest;

import java.sql.SQLException;
import java.util.Scanner;

import membertest.DTO.memberDTO;

import membertest.service.MemberService;

public class MembertestExam {
	public static Scanner inputStr = new Scanner(System.in); // 공용
	public static memberDTO session = new memberDTO();
	
	public static void main(String[] args) throws SQLException {
		// member 테이블 메인 클래스
		//보드 전체보기만 했습니다. 
		boolean run = true;

		while (run) {
			System.out.println("게시판");
			System.out.println("1.회원");
			System.out.println("2.게시판");
			System.out.println("3종료");
			System.out.print(">>>");
			String select = inputStr.next();
			switch (select) {
			case "1":
				System.out.println("회원서비스로 이동중");
				MemberService memberservice = new MemberService();
				memberservice.submenu(inputStr, session);

				break;
			case "2":
				System.out.println("게시판으로 이동중");
				MemberService memberService2= new MemberService();
				memberService2.boardmenu(inputStr,session);
				break;
			case "3":
				System.out.println("프로그램 종료");
				run = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}// 스위치문 종료

		} // 와이드문 종료

	}// 메인 종료

}// 클래스 종료
