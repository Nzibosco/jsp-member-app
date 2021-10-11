package org.bosco.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bosco.dtos.ErrorResponseDTO;
import org.bosco.dtos.MemberDTO;
import org.bosco.dtos.WelcomeDTO;
import org.bosco.entities.JspMember;
import org.bosco.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

@WebServlet("/welcome")
public class LoginServlet extends HttpServlet {

    private final MemberService service = new MemberService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        //PrintWriter w = resp.getWriter();

        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM YYYY HH:mm:ss");
        String todaysDate = formatter.format(localDate);

        WelcomeDTO message = new WelcomeDTO();
        message.setMessage("Welcome to the member JSP application & platform!");
        message.setTodaysDate(todaysDate);
        String response = mapper.writeValueAsString(message);
        resp.setStatus(200);
        resp.getWriter().write(response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();


        MemberDTO dto = mapper.readValue(req.getInputStream(), MemberDTO.class);
        try {
            service.addMember(dto);
            Iterable<MemberDTO> members = new HashSet<>();
            members = service.getMembers();
            String membersList = mapper.writeValueAsString(members);
            resp.getWriter().write(membersList);
        } catch (Exception e){

            ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
            errorResponseDTO.setErrorMessage(e.getMessage());
            errorResponseDTO.setStatusCode(400);
            String error = mapper.writeValueAsString(errorResponseDTO);
            resp.setStatus(400);
            resp.getWriter().write(error);
        }
    }
}
