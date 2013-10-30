package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.interfaces.CuentaDao;
import dao.interfaces.AutorDao;
import dao.interfaces.UsuarioDao;
import dao.interfaces.AutorbaseDao;
import daofactory.DaoFactory;
import beans.Autor;
import beans.UsuarioBean;
import beans.AutorBase;;



/**
 * Servlet implementation class AlertaBilletera_Registrar
 */
@WebServlet("/RegistrarBlog")
public class RegistrarBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarBlog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("frmRegistroAlumno.jsp").
		forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		try {
			String tipocuenta = request.getParameter("rbn_tipo");
			String nombres = request.getParameter("txt_nombres");
			String apellidopate = request.getParameter("txt_apepat");
			String apellidomate = request.getParameter("txt_apemat");
			String correo = request.getParameter("txt_correo");
			String password = request.getParameter("txt_contra");
			String fechaNacimiento = request.getParameter("txt_fecha");
			String tituloblog = request.getParameter("txt_titulo");
			String direccionblog = request.getParameter("txt_direccion");
			
			
			DaoFactory dao = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
			AutorbaseDao autordao = dao.getAutorbaseDao();
			AutorBase autor= autordao.verificar(nombres,apellidopate,apellidomate);
			
			if (autor!=null){
				
				
				DaoFactory variable1 = DaoFactory.getDAOFactory(DaoFactory.MYSQL);
				AutorDao variable2 = variable1.getAutorDao();
				
				variable2.registro(tipocuenta, nombres, apellidopate, apellidomate,correo, password, fechaNacimiento, tituloblog, direccionblog);
				Date hoy = new Date();
				
				
				
				
				request.setAttribute("mensaje", "verifico correctamente  </br>Reporte de Datos del Autor </br></br> Titulo blog : "+tituloblog+"</br> Direccion blog : "+direccionblog+"</br> Nombres del Autor : "+ nombres +"</br> Apellidos  del Autor : "+ apellidopate+" "+apellidomate+"</br> Fecha de creacion : "+hoy+ "</br> Correo Electronico : "+correo);
				
			
		
			}else{
				request.setAttribute("mensaje", "el sistema de base de datos no puede verificar los datos del autor ");
			}

				
			request.getRequestDispatcher("mensaje.jsp").
			forward(request, response);	
			
		} catch (Exception e) {
			// TODO: handle exception
			out.print(e.getMessage());
		}
	}

}
