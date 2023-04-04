package kb.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kb.mvc.common.DBManager;
import kb.mvc.dto.BoardDTO;
import kb.mvc.dto.ReplyDTO;
import kb.mvc.exception.DMLException;
import kb.mvc.exception.SearchWrongException;

public class BoardDAOImpl implements BoardDAO {

	private static BoardDAO instance = new BoardDAOImpl();

	/**
	 * 외부에서 객체 생성 불가
	 */
	private BoardDAOImpl() {
	}

	public static BoardDAO getInstance() {
		return instance;
	}

	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		List<BoardDTO> list = new ArrayList<>();
		String sql = "select * from board order by board_no desc";
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(sql);

			rs = st.executeQuery();
			while (rs.next()) { // board_no, subject, writer, content, board_date
				BoardDTO dto = new BoardDTO(rs.getInt("board_no"), rs.getString("subject"), rs.getString("writer"),
						rs.getString("content"), rs.getString("board_date"));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("전체 검색 도중 예외가 발생했습니다. 다시 조회해주세요.");
		} finally {
			DBManager.releaseConnection(con, st, rs);
		}
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SearchWrongException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		BoardDTO dto = null;
		List<BoardDTO> list = new ArrayList<>();

		String sql = "select * from board where upper(subject) like upper(?)";

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(sql);

			st.setString(1, "%" + keyWord + "%");

			rs = st.executeQuery();

			while (rs.next()) { // board_no, subject, writer, content, board_date

				dto = new BoardDTO(rs.getInt("board_no"), rs.getString("subject"), rs.getString("writer"),
						rs.getString("content"), rs.getString("board_date"));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, st, rs);
		}

		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SearchWrongException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		BoardDTO dto = null;

		String sql = "select * from board where board_no = ? ";

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(sql);

			st.setInt(1, boardNo);

			rs = st.executeQuery();

			if (rs.next()) { // board_no, subject, writer, content, board_date

				dto = new BoardDTO(rs.getInt("board_no"), rs.getString("subject"), rs.getString("writer"),
						rs.getString("content"), rs.getString("board_date"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, st, rs);
		}

		return dto;
	}

	@Override
	public int boardInsert(BoardDTO boardDTO) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;

		int result = 0;
		String sql = "insert into board (board_no, subject, writer, content, board_date)values "
				+ "(board_seq.nextval, ?, ?, ?, sysdate)";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, boardDTO.getSubject());
			ps.setString(2, boardDTO.getWriter());
			ps.setString(3, boardDTO.getContent());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("게시물 등록에 실패하였습니다. 다시 등록해주세요.");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;

		int result = 0;
		String sql = "update board set content = ? where board_no = ?";

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, boardDTO.getContent());
			ps.setInt(2, boardDTO.getBoardNo());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}

		return result;
	}

	@Override
	public int boardDelete(int boardNo) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;

		int result = 0;
		String sql = "delete from board where board_no = ?";

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, boardNo);

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("먼저 삭제하려는 글의 댓글을 삭제한 후 삭제해주세요");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int replyInsert(ReplyDTO replyDTO) throws DMLException {

		Connection con = null;
		PreparedStatement ps = null;

		int result = 0;

		String sql = "insert into reply values(reply_no_seq.nextval , ?, ?, sysdate)";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

//			reply_no, reply_content, board_no, reply_regdate

			ps.setString(1, replyDTO.getReplyContent());
			ps.setInt(2, replyDTO.getBoardNo());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(con, ps);
		}

		return result;
	}

	@Override
	public BoardDTO replySelectByParentNo(int boardNo) throws SearchWrongException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		BoardDTO boardDTO = null;

//		String sql = " select * from board join reply using(board_no) where board_no=?";
		String sql = " select * from board where board_no=?";

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, boardNo);

			rs = ps.executeQuery();

			if (rs.next()) {
				boardDTO = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
			}

			// 댓글번호를 검색한다.
			List<ReplyDTO> replyList = this.replySelect(con, boardNo);
			boardDTO.setRepliesList(replyList);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("부모글 정보조회에 오류가 발생했습니다.");
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}

		return boardDTO;
	}

	/**
	 * 부모 글에 해당하는 댓글정보를 검색하는 메소드 내부에서만 사용하기 떄문에 private
	 * 
	 */
	private List<ReplyDTO> replySelect(Connection con, int boardNo) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<ReplyDTO> list = new ArrayList<>();
		String sql = "select * from reply where board_no=?";

		ReplyDTO reply = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);

			rs = ps.executeQuery();

			while (rs.next()) {
				reply = new ReplyDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				list.add(reply);
			}
		} finally {
			DBManager.releaseConnection(null, ps, rs);
		}

		return list;
	}

}
