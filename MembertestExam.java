package membertest;

import java.sql.SQLException;
import java.util.Scanner;

import membertest.DTO.memberDTO;

import membertest.service.MemberService;

public class MembertestExam {
	public static Scanner inputStr = new Scanner(System.in); // ����
	public static memberDTO session = new memberDTO();
	
	public static void main(String[] args) throws SQLException {
		// member ���̺� ���� Ŭ����
		//���� ��ü���⸸ �߽��ϴ�. 
		boolean run = true;

		while (run) {
			System.out.println("�Խ���");
			System.out.println("1.ȸ��");
			System.out.println("2.�Խ���");
			System.out.println("3����");
			System.out.print(">>>");
			String select = inputStr.next();
			switch (select) {
			case "1":
				System.out.println("ȸ�����񽺷� �̵���");
				MemberService memberservice = new MemberService();
				memberservice.submenu(inputStr, session);

				break;
			case "2":
				System.out.println("�Խ������� �̵���");
				MemberService memberService2= new MemberService();
				memberService2.boardmenu(inputStr,session);
				break;
			case "3":
				System.out.println("���α׷� ����");
				run = false;
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				break;
			}// ����ġ�� ����

		} // ���̵幮 ����

	}// ���� ����

}// Ŭ���� ����
