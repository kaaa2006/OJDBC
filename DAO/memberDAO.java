package membertest.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import membertest.DTO.memberDTO;

public class memberDAO {
	public memberDTO memberDTO = new memberDTO();
//����� db�� ���� ���
	public memberDTO memberdto = new memberDTO();
	public Connection connection = null; // 1�ܰ� ���
	public Statement stmt = null; // 3�ܰ輭 ���
	public PreparedStatement pstmt = null;// 3�ܰ輭 ���
	public ResultSet resultset = null; // 4�ܰ迡�� ����޴� ǥ ��ü select ��� executeUpdate
	public int result = 0; // 4�ܰ迡�� ����޴� ���� insert update delete ���

//�⺻������ 
	public memberDAO() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.169:1521:xe", "membertest",
					"membertest");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �̸� �Ǵ� ojdbc6.jar ������ Ȯ�����ּ���");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("ULR,ID,PW �� �߸��Ǿ��ų� BoardDAO�� �⺻�����ڸ� Ȯ�����ּ���.");
			e.printStackTrace();
			System.exit(0);
		}

	}// �⺻������ ����

	public void create(memberDTO session) throws SQLException {
		// ȸ������
		try {
			String sql = "insert into member (mno,name,id,pw) values (member_seq.nextval,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, session.getName());
			pstmt.setString(2, session.getId());
			pstmt.setString(3, session.getPw());
			System.out.println("���� Ȯ�� " + sql);

			result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(result + "���� ������ ��ϵǾ����ϴ�");
				connection.commit();
				System.out.println(session.getName() + "�� ȯ���մϴ�!");

			} else {
				System.out.println("���� ������� " + result);
				System.out.println("ȸ������ ����");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("���ܹ߻�");
			e.printStackTrace();
		} finally {
			pstmt.close();
		}

	}// ȸ������ ����

	public memberDTO login(memberDTO session) throws SQLException {
		// �α���

		try {
			String sql = "select * from member where id=? and pw=? ";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, session.getId());
			pstmt.setString(2, session.getPw());

			resultset = pstmt.executeQuery();

			if (resultset.next()) {
				session.setMno(resultset.getInt("mno"));
				session.setName(resultset.getString("name"));
				session.setId(resultset.getString("id"));
				session.setPw(resultset.getString("pw"));
				System.out.println("�α��� ����!!");
				System.out.println(session.getName() + "�� �ݰ�����!");

				return session;
			} else {
				System.out.println("�α��� ����");
				System.out.println("id�Ǵ�pw�� Ʋ�Ƚ��ϴ�.");

			}
		} catch (SQLException e) {
			System.out.println("�α��� �޼���,DAO�� Ȯ�����ּ���.");
			e.printStackTrace();
		} finally {
			pstmt.close();
			resultset.close();
		}
		return session;

	}//

	public void update(String bid, Scanner inputStr, memberDTO session) throws SQLException {
		// ���� ������ ���� id�� ã�� ���������� ����
		memberDTO memberdto = new memberDTO();
		System.out.println(bid + "���� ������ �����մϴ�.");

		System.out.println("===���ο� ������ �Է��ϼ���===");
		System.out.print("id :");
		String newid = inputStr.next();
		System.out.println("pw :");
		String newpw = inputStr.next();

		session.setId(newid);
		session.setPw(newpw);

		PreparedStatement pstmt = null;

		try {
			String sql = "update member set id=?, pw=?, regidate=sysdate where id=?";

			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, session.getId());
			pstmt.setString(2, session.getPw());
			pstmt.setString(3, bid);
			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println(result + "���� ������ �����Ǿ����ϴ�.");
				connection.commit();
			} else {
				System.out.println("�Է��� id�� ���� id�Դϴ�.");
				System.out.println("�ٽ� Ȯ�����ּ���.");
				connection.rollback();
			}

		} catch (Exception e) {
			System.out.println("upadte()�޼��� �������� Ȯ�����ּ���");
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
		}

	}

	public void memberAll() throws SQLException {
		// ��ü���� ����
		try {
			String sql = "select mno,name,id,pw,regidate from member order by regidate desc";
			// �����ͺ��̽��� board ���̺� ������ �������� ������
			stmt = connection.createStatement(); // �������� ������ ��ü ����
			resultset = stmt.executeQuery(sql); // �������� �����Ͽ� ����� ǥ�� �޴´�.

			System.out.println("��ȣ\t �̸�\t id\t pw\t");
			while (resultset.next()) {
				// ���ǥ�� ������ �Ʒ����� �������鼭 ���
				System.out.print(resultset.getInt("mno") + "\t");
				System.out.print(resultset.getString("name") + "\t");
				System.out.print(resultset.getString("id") + "\t");
				System.out.println(resultset.getString("pw") + "\t");
				System.out.println(resultset.getDate("regidate") + "\t");

			}
			System.out.println("========��=========");
		} catch (SQLException e) {
			// ���� �߻��� ����ó����
			System.out.println("selectAll()�޼��忡 �������� �߸� �Ǿ����ϴ�.");
			e.printStackTrace();

		} finally {
			// �׻� ���๮
			resultset.close();
			stmt.close();
			// connection.close(); //������ü�� �ݾƾ� �ٸ� �޼��嵵 ���� �۵��Ѵ�.
		}
	}

	public void delete(String deid, memberDTO session) throws SQLException {
		// ����
		try {
			String sql = "delete from member where id = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, session.getId());
			result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(result + "������ �����Ǿ����ϴ�.");
				connection.commit();
			} else {
				System.out.println("id�� Ȯ�����ּ���");
				System.out.println("******�����Ͻ÷��� �Խñ��� ������ �մϴ�******");
				connection.rollback();
			}
			memberAll(); // ������ ��������Ʈ ����
		} catch (Exception e) {
			System.out.println("===========================");
			e.printStackTrace();

		} finally {
			pstmt.close();
		}

	}

	public memberDTO logininsert(Scanner inputStr, membertest.DTO.memberDTO session, String boid, String bopw)
			throws SQLException {
		// �α����ϰ� �Խ���
		try {
			String sql = "select * from member where id=? and pw=? ";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, session.getId());
			pstmt.setString(2, session.getPw());

			
			resultset = pstmt.executeQuery();

			if (resultset.next()) {
				session.setMno(resultset.getInt("mno"));
				session.setName(resultset.getString("name"));
				session.setId(resultset.getString("id"));
				session.setPw(resultset.getString("pw"));
				System.out.println("�α��� ����!!");
				System.out.println(session.getName() + "�� �ݰ�����!");
				
				
				session.setBwriter(session.getId());  
				
				
				System.out.println("�Խ��Ǹ�忡 �����̽��ϴ�.");

				System.out.print("���� :");
				String title = inputStr.next();
				System.out.print("���� :");
				String content = inputStr.next();
				

				session.setBtitle(title);
				session.setBcontent(content);
				
				
				// �Խ��� �� DB�� ����
				String Sql = "INSERT INTO board (bno, btitle, bcontent, bwriter, bdate) VALUES (board_seq.nextval, ?, ?, ?, SYSDATE)";

				pstmt = connection.prepareStatement(Sql);
				pstmt.setString(1, session.getBtitle());
				pstmt.setString(2, session.getBcontent());
				pstmt.setString(3, session.getBwriter());
				result = pstmt.executeUpdate();
				if (result > 0) {
					System.out.println("�Խñ��� ��ϵǾ����ϴ�!");
					connection.commit();
				} else {
					System.out.println("�Խñ� ��� ����");
					connection.rollback();
				}

				return session;
			} else {
				System.out.println("�α��� ����");
				System.out.println("id�Ǵ�pw�� Ʋ�Ƚ��ϴ�.");

			}
		} catch (SQLException e) {
			System.out.println("�α��� �޼���,DAO�� Ȯ�����ּ���.");
			e.printStackTrace();
		} finally {
			pstmt.close();
			resultset.close();
		}
		return session;

	}//

	public void selectAll() throws SQLException {
		// TODO Auto-generated method stub
		try {
			String sql = "select bno,btitle,bwriter,bdate from board order by bdate desc";
			// �����ͺ��̽��� board ���̺� ������ �������� ������
			stmt = connection.createStatement(); // �������� ������ ��ü ����
			resultset = stmt.executeQuery(sql); // �������� �����Ͽ� ����� ǥ�� �޴´�.

			System.out.println("��ȣ\t ����\t �ۼ���\t �ۼ���\t");
			while (resultset.next()) {
				// ���ǥ�� ������ �Ʒ����� �������鼭 ���
				System.out.print(resultset.getInt("bno") + "\t");
				System.out.print(resultset.getString("btitle") + "\t");
				System.out.print(resultset.getString("bwriter") + "\t");
				System.out.println(resultset.getDate("bdate") + "\t");

			}
			System.out.println("========��=========");
		} catch (SQLException e) {
			// ���� �߻��� ����ó����
			System.out.println("selectAll()�޼��忡 �������� �߸� �Ǿ����ϴ�.");
			e.printStackTrace();

		} finally {
			// �׻� ���๮
			resultset.close();
			stmt.close();
			// connection.close(); //������ü�� �ݾƾ� �ٸ� �޼��嵵 ���� �۵��Ѵ�.
		}
	}

	public void modify(String title, Scanner inputStr, memberDTO session) throws SQLException {
		//���� db����
		// ������ ã�Ƽ� ������ �����Ѵ�.
				memberDAO boardDTO = new memberDAO();
				
				System.out.println("������ ������ �Է��ϼ���");
				System.out.print(">>>");
				session.setBtitle(inputStr.next());
				Scanner inputLine = new Scanner(System.in);
				System.out.print("���� : ");
				session.setBcontent(inputLine.nextLine());
				
				
					try {
						String sql = "update board set btitle = ? , bcontent = ? , bdate = sysdate where btitle=? ";
						pstmt = connection.prepareStatement(sql);
						pstmt.setString(1, session.getBtitle());
						pstmt.setString(2, session.getBcontent());
						pstmt.setString(3, title);
						
						result = pstmt.executeUpdate(); //������ ������ ����� ������ ������
					
						if (result > 0 ) {
							System.out.println(result +"���� �����Ͱ� �����Ǿ����ϴ�");
							connection.commit();
						}else {
							System.out.println("���ܹ߻� : modify �޼��� sql�� Ȯ���ϼ���");
						}
					
					
					
					
					} catch (Exception e) {
						System.out.println("���ܹ߻�");
						e.printStackTrace();
					}finally {
						pstmt.close();
					}
		
	}

	public void deleteOne(int selectBno, membertest.DTO.memberDTO session) throws SQLException {
		// ����
		try {
			String sql= "delete from board where bno = ?";
			pstmt =connection.prepareStatement(sql);
			pstmt.setInt(1, selectBno);
			
			result = pstmt.executeUpdate(); 
			
			if(result>0) {
				System.out.println(result + "�Խù� ����");
				connection.commit();
			}else {
				System.out.println("�Խù� ���� �ȵ�");
				connection.rollback();			
			}
			System.out.println("===========================");
			selectAll(); // ������ ��ü ����Ʈ ���� 
			
			
			
		} catch (SQLException e) {
			System.out.println("���ܹ߻� : deleteone�޼���� sql���� Ȯ���ϼ���");
			e.printStackTrace();
		} finally {
			pstmt.close();
			
		}
	}

}
