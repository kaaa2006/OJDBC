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
			System.out.println("1.회원가입");
			System.out.println("2.로그인");
			System.out.println("3.회원수정");
			System.out.println("4.계정 전체보기");
			System.out.println("5.회원삭제");
			System.out.println("6.나가기");
			System.out.print(">>>");
			String select = inputStr.next();
			switch (select) {
			case "1":
				System.out.println("회원가입 메뉴로 이동합니다.");
				create(memberDAO, inputStr, session);
				break;
			case "2":
				System.out.println("로그인 메뉴로 이동합니다.");
				login(memberDAO, inputStr, session);
				break;
			case "3":
				System.out.println("회원수정 메뉴로 이동합니다.");
				update(memberDAO, inputStr, session);
				break;
			case "4":
				System.out.println("회원 모두 보기 메뉴로 이동합니다.");
				memberall(memberDAO);
				break;
			case "5":
				System.out.println("회원삭제 메뉴로 이동합니다.");
				delete(inputStr, session);
				break;
			case "6":
				System.out.println("뒤로가기 처음으로 이동합니다.");
				run = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");

				break;

			}// 스위치문 종료

		} // 와이드문 종료

	}// 서브메뉴 종료

	private void delete(Scanner inputStr, memberDTO session) throws SQLException {
		// 삭제
		System.out.println("====삭제====");
		System.out.println("삭제하려는 계정의 id를 입력하세요.");
		System.out.println("******삭제하시려면 게시글을 지워야 합니다******");
		System.out.print("id :");
		String deid = inputStr.next();
		session.setId(deid);
		memberDAO.delete(deid,session);

	}

	private void memberall(membertest.DAO.memberDAO memberDAO) throws SQLException {
		// 계정 모두 보기
		System.out.println("모든 계정 보기 리스트");
		memberDAO.memberAll();
		System.out.println("----------------------");
	}

	private void update(memberDAO memberDAO, Scanner inputStr, memberDTO session) throws SQLException {
		// 계정수정
		System.out.println("=======수정========");
		System.out.println("수정하고 싶은 본인의 id를 입력하세요.");
		System.out.print("id :");
		String bid = inputStr.next();
		System.out.println("=======================");

		memberDAO.update(bid, inputStr, session);
	}

	private void login(memberDAO memberDAO, Scanner inputStr, memberDTO session) throws SQLException {
		// 로그인 메서드
		System.out.println("========로그인=======");
		System.out.print("id :");
		session.setId(inputStr.next());
		System.out.println("=======================");

		System.out.print("pw :");
		session.setPw(inputStr.next());
		System.out.println("====================");

		memberDAO.login(session);
	}// 로그인 메서드 종료

	private void create(memberDAO memberDAO, Scanner inputStr, memberDTO session) throws SQLException {
		// 회원가입 메서드
		memberDTO memberDTO = new memberDTO();
		System.out.print("이름 :");
		session.setName(inputStr.next());
		System.out.print("id :");
		session.setId(inputStr.next());
		System.out.print("pw :");
		session.setPw(inputStr.next());

		memberDAO.create(session);

	}// 회원가입 메서드 종료

	public void boardmenu(Scanner inputStr, memberDTO session) throws SQLException {
		// 게시판
		boolean srun = true;
		System.out.println(" ***********게시판을 사용할 경우 로그인이 필요합니다!! 뒤로가기후 회원가입을 해주세요. ***********");
		
		while (srun) {
			System.out.println("게시판메뉴 입니다");
			System.out.println("1.게시판");
			System.out.println("2.게시판 모두보기");
			System.out.println("3.게시판 수정");
			System.out.println("4.게시판 삭제");
			System.out.println("5.뒤로가기");
			String subselect = inputStr.next();

			switch (subselect) {
			case "1":
				System.out.println("게시판으로 이동중");
				logininsert(inputStr, session);

				break;
			case "2":
				System.out.println("게시판 전체보기 이동중");
				readall();
				break;
			case "3":
				System.out.println("게시판 수정 이동중");
				 modify(inputStr,session);
				break;
			case "4":
				System.out.println("게시판 삭제 이동중");
				deleteOen(inputStr, session);
				
				break;
			case "5":
				System.out.println("뒤로가기 처음화면으로 이동중");
				srun=false;
				break;
				
			default:
				System.out.println("입력이 잘못되었습니다.");
				break;
			}

		}

	}

	private void deleteOen(Scanner inputStr, memberDTO session) throws SQLException {
		System.out.println("삭제하려는 게시글의 번호를 입력하세요");
		
		Scanner inputInt = new Scanner(System.in);
		System.out.print(">>>");
		int selectBno = inputInt.nextInt();
		session.setBno(selectBno);
		memberDAO.deleteOne(selectBno,session);
		
	}

	private void modify(Scanner inputStr, memberDTO session) throws SQLException {
		// T수정
		System.out.println("수정하고 싶은 게시글의 제목을 입력하세요");
		System.out.print(">>>");
		String title = inputStr.next();
		
		session.setBtitle(title);
		
	  memberDAO.modify(title, inputStr,session);
	  System.out.println("===========끝===========");
	}

	private void readall() throws SQLException {
		// 전체읽기
		System.out.println("--------------------");
		System.out.println("-----게시판 목록-----");
		memberDAO.selectAll();
		System.out.println("---------------------");
	}

	private void logininsert(Scanner inputStr, memberDTO session) throws SQLException {
		// 로그인후 게시물 작성
		System.out.println("로그인");
		System.out.print("id :");
		String boid = inputStr.next();
		System.out.print("pw :");
		String bopw = inputStr.next();
		  session.setId(boid);
		  session.setPw(bopw);
		memberDAO.logininsert(inputStr, session, boid, bopw);

	}

}// 클래스 종료
