package kosta.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kosta.model.Board;
import kosta.model.Reply;
import kosta.model.Search;


public interface BoardMapper {
	int insertBoard(Board board);//mapper 아이디와 동일
	List<Board> listBoard(Search search, RowBounds row);
	Board detailBoard(int seq);
	int updateBoard(Board board);
	int deleteBoard(int seq);
	int countBoard(Search search);
	int insertReply(Reply reply);
	List<Reply> detailReply(int seq);
}
