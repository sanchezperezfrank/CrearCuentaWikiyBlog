package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UsuarioBean;
import dao.interfaces.UsuarioDao;
import daofactory.DaoFactory;

/**
 * Servlet implementation class Cuenta_Login
 */
@WebServlet("/Usuario_Login")
public class Usuario_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario_Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				PrintWriter out = response.getWriter();
				try {
					HttpSession sesion = request.getSession();
					sesion.removeAttribute("usuario");
					sesion.removeAttribute("password");
					
					//sesion.invalidate();
					
					response.sendRedirect("principal.jsp");
					
				} catch (Exception e) {
					out.print(e.getMessage());
				}
			}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				PrintWriter out = response.getWriter();
				try {
					String usuario = request.getParameter("txt_usuario");
					String clave = request.getParameter("txt_password");
					
					DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
					UsuarioDao usuariodao = dao.getUsuarioDao();
					UsuarioBean usuariobean = usuariodao.login(usuario, clave);
					
					if(usuariobean == null){
						request.setAttribute("mensaje", "Datos incorrectos");
						getServletContext().getRequestDispatcher("/index.jsp")
															.forward(request, response);
					}else{
						HttpSession sesion = request.getSession();
						
						sesion.setAttribute("usuario", usuariobean.getUsuario());
						sesion.setAttribute("password", usuariobean.getPassword());
						
						response.sendRedirect("principal.jsp");
						
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					out.print(e.getMessage());
				}
			}

		}
