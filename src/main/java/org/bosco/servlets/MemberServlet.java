package org.bosco.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bosco.dtos.MemberDTO;
import org.bosco.entities.JspMember;
import org.bosco.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/member/*")
public class MemberServlet extends HttpServlet {

    private final MemberService service = new MemberService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();

        String lastname = req.getParameter("lastname");
        service.printMembers();

        String data = mapper.writeValueAsString(service.findMemberByLastname(lastname));
        System.out.println("parameter input - lastname " + lastname);
        System.out.println(data);
        resp.getWriter().write(data);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        String lastname = req.getParameter("lastname");
        System.out.println("The parameter requested is " + lastname);

//        JspMember member = JspMember.getInstance();
        Optional<JspMember> optional = service.findMemberByLastname("Ishimwe");
//        if(optional.isPresent()){
//            member = optional.get();
//            System.out.println("This member's last name is " + member.getLastname());
//        }
//
//
//        MemberDTO dto = new MemberDTO();
//        dto.createDTOfromMember(member);

        System.out.println(optional);
        String m = mapper.writeValueAsString(optional);
        resp.getWriter().write(m);

    }
}
