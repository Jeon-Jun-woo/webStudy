package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;
import com.sist.vo.*;
import com.sist.dao.*;
public class ReplyModel {
	private String[] tab= {"","location","nature","shop","food"};
  @RequestMapping("reply/insert.do")
  public String reply_insert(HttpServletRequest requset,
		  HttpServletResponse response)
  {
	  try
	  {
		  requset.setCharacterEncoding("UTF-8");
	  }catch(Exception ex) {}
	  String type=requset.getParameter("type");
	  String cno=requset.getParameter("cno");
	  String msg=requset.getParameter("msg");
	  HttpSession session=requset.getSession();
	  String id=(String)session.getAttribute("id");
	  String name=(String)session.getAttribute("name");
	  
	  ReplyVO vo=new ReplyVO();
	  vo.setType(Integer.parseInt(type));
	  vo.setCno(Integer.parseInt(cno));
	  vo.setId(id);
	  vo.setName(name);
	  vo.setMsg(msg);
	  
	  ReplyDAO dao=ReplyDAO.newInstance();
	  dao.replyInsert(vo);
	  return "redirect:../seoul/"+tab[Integer.parseInt(type)]+"_detail.do?no="+cno;
  }
  @RequestMapping("reply/delete.do")
  public String reply_delete(HttpServletRequest requset,
		  HttpServletResponse response)
  {
	  String type=requset.getParameter("type");//구분자
	  String cno=requset.getParameter("cno");//명소 번호
	  String no=requset.getParameter("no");//댓글 번호
	  ReplyDAO dao=ReplyDAO.newInstance();
	  dao.replyDelete(Integer.parseInt(no));
	  return "redirect:../seoul/"+tab[Integer.parseInt(type)]+"_detail.do?no="+cno;
  }
  @RequestMapping("reply/update.do")
  public String reply_update(HttpServletRequest requset,
		  HttpServletResponse response)
  {
	  try
	  {
		  requset.setCharacterEncoding("UTF-8");
	  }catch(Exception ex) {}
	  String type=requset.getParameter("type");//구분자
	  String cno=requset.getParameter("cno");//명소 번호
	  String no=requset.getParameter("no");//댓글 번호
	  String msg=requset.getParameter("msg");
	  ReplyDAO dao=ReplyDAO.newInstance();
	  dao.replyUpdate(Integer.parseInt(no), msg);
	  return "redirect:../seoul/"+tab[Integer.parseInt(type)]+"_detail.do?no="+cno;
  }
}
