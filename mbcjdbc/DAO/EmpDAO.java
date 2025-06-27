package jdbc.mbcjdbc.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDAO {
	// jdbc를 담당하는 클래스 
			// 오라클과 쿼리를 작성하는 crud 를 제공 
			// jdbc는 이미 만들어진 외부 라이브러리로 5단계 설정이 필수이다 
			// 1단계 : 연결하는 객체 connection 
			// 2단계 : 쿼리문을 생성하는 객체 statement (구형,정적쿼리) / preparedStatement (신형, 동적 쿼리 )
			// 3단계 : 쿼리문을 실행하고 
			// 4단계 : 쿼리문 실행결과를 받음 select(resultset)/ 나머지는 int 
			// 5단계 : 연결을 종료 
			
			// 필드 
			
			// 기본 생성자 (생략시 기본으로 만듦)
			
			// 메서드 
			
	public void insertEMP(String name, String dept, double score) throws SQLException {
		
		Connection conn = null; //db에서 연결하는 객체 
		Statement stmt = null; //쿼리문 저장객체 (구형)	
		PreparedStatement pstmt = null; // 
		ResultSet resultset = null; // 쿼리 실행 결과 표로 출력 
		int result =0; //쿼리 실행 결과로 정수로 출력 cud 결과값이 1이면 성공 0이면 실패 
		
		
		try { //예외 발생 가능성이 있는 실행문에서 활용 
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1단계용 ojdbc6 jar 호출 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.169:1521:xe", "jdbctest", "jdbctest");
			
			stmt = conn.createStatement(); //쿼리 처리용 객체 
			// insert into emp (num,name,dept,score)
			// values (emp_seq.nextval,'num','name','dept','score'); 
			
			String sql = "insert into emp (num,name,dept,score)" + " values(emp_seq.nextval,'" + name +"','" + dept + "','"+score +"') "; //쿼리문 완성  
			
			result  = stmt.executeUpdate(sql); // int 타입으로 결과를 받을 명령어 
			
			if(result>0) {
				System.out.println(result+"행의 데이터를 추가 합니다. \n");
		
				conn.commit();
				
			}else {
				System.out.println("결과 :"+ result + "입니다.");
				System.out.println("입력 실패 롤백 됩니다.");
				conn.rollback();
			}
		
		}catch(ClassNotFoundException e) { // ojdbc6 jar 를 찾을수 없거나 forName 이름이 잘못됨
			System.out.println("ojdbc6.jar가 없거나 forName에 문자열이 잘못되었습니다.");
			e.printStackTrace(); //  자바에서 제공하는 오류 메세지를 출력(빨간 글자)
		
		
		}catch(SQLException e) { // url이나 id pw 대한 예외처리용 
			System.out.println("URL 이나 id,pw 쿼리문을 확인해주세요 ");
			e.printStackTrace(); //자바에서 제공하는 오류 메세지 출력
		}finally { //성공이든 실패든 무조건 마지막에 실행되는 문 
			//열림과 반대로 닫아준다.
			stmt.close();
			//System.out.println("스테이트문 종료");
			conn.close();
			//System.out.println("커넥트 종료");
			
		}
		

		
		
	}// insertEmp문 종료

	public void selectEMPALL() throws SQLException{
		// emp 테이블에 모든 정보를 번호 기준으로 내림차순 추력 
		Connection conn = null; //연결객체
		Statement stmt = null; // 쿼리문 처리 객체 
		PreparedStatement pstst = null; //쿼리문을 처리하는 객체 
		ResultSet resultset = null; //select의 결과를 표형식으로 생성객체
		int result = 0; // update delete create 결과가 정수로 나옴 (1행 처리 완료)
		
		
		
	}

}
