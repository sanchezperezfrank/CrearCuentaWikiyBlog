<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<title>Insert title here</title>

<style type="text/css">
#user{
margin-top:80px;
}
fieldset legend{
border: solid 1px #AAA;
display:block;
padding: 5px 15px 5px 15px;
border-radius: 5px;
box-shadow:0px 0px 7px #666;
}
fieldset{
border-radius:7px 7px 0 0;
width: 350px;
background-color:#ECECEC;
box-shadow:
}
#enter{
margin-top:30px;
}
#enter span{
float:left;
margin-left:50px;

}
#enter input{
margin-left:150px;
display:block;
}
button{
margin-right:43;
width:100px;
height:30px;
cursor:pointer;
background-color:#5DA61E;
border-radius:5px;
border:none;
color:white;
}
}
button:hover{
box-shadow:0px 0px 3px #666;
border:none;
color:white;
}
button .spam{
margin-right:12px;
}
hr{
width:100%;
}
</style>
<div id="user">
<fieldset>
<legend>Login de Usuario</legend>
<div id="enter">
<form name="frm_usuario" method="post" action="<%=application.getContextPath() %>/Usuario_Login">
Ingrese Usuario<input  type="text" name ="txt_usuario" -ms-input-placeholder="Nombre de Usuario" /><br>
Contraseña<input type="password" max="5" min="2"  name ="txt_password" -ms-input-placeholder="Password"/>
<div>
<hr>
<button type="submit" value="Entrar" style="float:right;">Ingresar</button>
</form>
</fieldset>
</div>
		
		 <%
            	String mensaje = "";
            	if(request.getAttribute("mensaje") != null ){
            		mensaje = (String)request.getAttribute("mensaje");
            	}
 %>
 <%=mensaje %>
 

	
</body>
</html>