package comment;

import java.util.List;

public class CommentService {
	CommentDAO commentDAO;
	
	public CommentService() {
		commentDAO = new CommentDAO();
	}
	
	public List<CommentVO> listComments(int lkey)
	{
		List<CommentVO> commentsList = commentDAO.selectALLComments(lkey);
		return commentsList;
	}
	
	public void addComment(CommentVO commentVO) {
		commentDAO.addComment(commentVO);
	}
}
