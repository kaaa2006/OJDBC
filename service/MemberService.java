package membertest.service;

import java.sql.SQLException;
import java.util.Scanner;

import membertest.DAO.memberDAO;
import membertest.DTO.memberDTO;

public class MemberService {

	public memberDAO memberDAO = new memberDAO();

	public void submenu(Scanner inputStr, memberDTO session) throws SQLException {
		boolean run = true;

		while (run) {
			System.out.println("1.ȸ������");
			System.out.println("2.�α���");
			System.out.println("3.ȸ������");
			System.out.println("4.���� ��ü����");
			System.out.println("5.ȸ������");
			System.out.println("6.������");
			System.out.print(">>>");
			String select = inputStr.next();
			switch (select) {
			case "1":
				System.out.println("ȸ������ �޴��� �̵��մϴ�.");
				create(memberDAO, inputStr, session);
				break;
			case "2":
				System.out.println("�α��� �޴��� �̵��մϴ�.");
				login(memberDAO, inputStr, session);
				break;
			case "3":
				System.out.println("ȸ������ �޴��� �̵��մϴ�.");
				update(memberDAO, inputStr, session);
				break;
			case "4":
				System.out.println("ȸ�� ��� ���� �޴��� �̵��մϴ�.");
				memberall(memberDAO);
				break;
			case "5":
				System.out.println("ȸ������ �޴��� �̵��մϴ�.");
				delete(inputStr, session);
				break;
			case "6":
				System.out.println("�ڷΰ��� ó������ �̵��մϴ�.");
				run = false;
				break;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");

				break;

			}// ����ġ�� ����

		} // ���̵幮 ����

	}// ����޴� ����

	private void delete(Scanner inputStr, memberDTO session) throws SQLException {
		// ����
		System.out.println("====����====");
		System.out.println("�����Ϸ��� ������ id�� �Է��ϼ���.");
		System.out.println("******�����Ͻ÷��� �Խñ��� ������ �մϴ�******");
		System.out.print("id :");
		String deid = inputStr.next();
		session.setId(deid);
		memberDAO.delete(deid,session);

	}

	private void memberall(membertest.DAO.memberDAO memberDAO) throws SQLException {
		// ���� ��� ����
		System.out.println("��� ���� ���� ����Ʈ");
		memberDAO.memberAll();
		System.out.println("----------------------");
	}

	private void update(memberDAO memberDAO, Scanner inputStr, memberDTO session) throws SQLException {
		// ��������
		System.out.println("=======����========");
		System.out.println("�����ϰ� ���� ������ id�� �Է��ϼ���.");
		System.out.print("id :");
		String bid = inputStr.next();
		System.out.println("=======================");

		memberDAO.update(bid, inputStr, session);
	}

	private void login(memberDAO memberDAO, Scanner inputStr, memberDTO session) throws SQLException {
		// �α��� �޼���
		System.out.println("========�α���=======");
		System.out.print("id :");
		session.setId(inputStr.next());
		System.out.println("=======================");

		System.out.print("pw :");
		session.setPw(inputStr.next());
		System.out.println("====================");

		memberDAO.login(session);
	}// �α��� �޼��� ����

	private void create(memberDAO memberDAO, Scanner inputStr, memberDTO session) throws SQLException {
		// ȸ������ �޼���
		memberDTO memberDTO = new memberDTO();
		System.out.print("�̸� :");
		session.setName(inputStr.next());
		System.out.print("id :");
		session.setId(inputStr.next());
		System.out.print("pw :");
		session.setPw(inputStr.next());

		memberDAO.create(session);

	}// ȸ������ �޼��� ����

	public void boardmenu(Scanner inputStr, memberDTO session) throws SQLException {
		// �Խ���
		boolean srun = true;
		System.out.println(" ***********�Խ����� ����� ��� �α����� �ʿ��մϴ�!! �ڷΰ����� ȸ�������� ���ּ���. ***********");
		
		while (srun) {
			System.out.println("�Խ��Ǹ޴� �Դϴ�");
			System.out.println("1.�Խ���");
			System.out.println("2.�Խ��� ��κ���");
			System.out.println("3.�Խ��� ����");
			System.out.println("4.�Խ��� ����");
			System.out.println("5.�ڷΰ���");
			String subselect = inputStr.next();

			switch (subselect) {
			case "1":
				System.out.println("�Խ������� �̵���");
				logininsert(inputStr, session);

				break;
			case "2":
				System.out.println("�Խ��� ��ü���� �̵���");
				readall();
				break;
			case "3":
				System.out.println("�Խ��� ���� �̵���");
				 modify(inputStr,session);
				break;
			case "4":
				System.out.println("�Խ��� ���� �̵���");
				deleteOen(inputStr, session);
				
				break;
			case "5":
				System.out.println("�ڷΰ��� ó��ȭ������ �̵���");
				srun=false;
				break;
				
			default:
				System.out.println("�Է��� �߸��Ǿ����ϴ�.");
				break;
			}

		}

	}

	private void deleteOen(Scanner inputStr, memberDTO session) throws SQLException {
		System.out.println("�����Ϸ��� �Խñ��� ��ȣ�� �Է��ϼ���");
		
		Scanner inputInt = new Scanner(System.in);
		System.out.print(">>>");
		int selectBno = inputInt.nextInt();
		session.setBno(selectBno);
		memberDAO.deleteOne(selectBno,session);
		
	}

	private void modify(Scanner inputStr, memberDTO session) throws SQLException {
		// T����
		System.out.println("�����ϰ� ���� �Խñ��� ������ �Է��ϼ���");
		System.out.print(">>>");
		String title = inputStr.next();
		
		session.setBtitle(title);
		
	  memberDAO.modify(title, inputStr,session);
	  System.out.println("===========��===========");
	}

	private void readall() throws SQLException {
		// ��ü�б�
		System.out.println("--------------------");
		System.out.println("-----�Խ��� ���-----");
		memberDAO.selectAll();
		System.out.println("---------------------");
	}

	private void logininsert(Scanner inputStr, memberDTO session) throws SQLException {
		// �α����� �Խù� �ۼ�
		System.out.println("�α���");
		System.out.print("id :");
		String boid = inputStr.next();
		System.out.print("pw :");
		String bopw = inputStr.next();
		  session.setId(boid);
		  session.setPw(bopw);
		memberDAO.logininsert(inputStr, session, boid, bopw);

	}

}// Ŭ���� ����
