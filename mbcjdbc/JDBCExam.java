package jdbc.mbcjdbc;

import java.sql.SQLException;
import java.util.Scanner;

import jdbc.mbcjdbc.DAO.EmpDAO;

public class JDBCExam {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("사원 이름: ");
		String name = input.next();
		System.out.print("부서명 : ");
		String dept = input.next();
		System.out.print("입사 점수 : ");
		double score = input.nextDouble();
		//키보드로 입력 완료 num은 db에서 시퀀스 객체로 자동 주입 
		
		EmpDAO empDAO = new EmpDAO();
		empDAO.insertEMP(name,dept,score); 
		
		
		System.out.println("모든 데이터 확인");
		empDAO.selectEMPALL();
	}

}
