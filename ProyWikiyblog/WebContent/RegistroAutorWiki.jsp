<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creacion de WIKI</title>
<style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0; padding: 0 }
      #map_canvas { height: 100% }
</style>
<link rel="stylesheet"  href="http://code.jquery.com/ui/1.9.1/themes/base/jquery.ui.all.css">
<link rel="stylesheet"  href="css/demos.css">
<script src="http://code.jquery.com/jquery.js"></script>
<script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	$("#txt_fecha").datepicker({
		showOn: "button",
		buttonImage: "images/calendar.gif",
		buttonImageOnly: true
	});
});
</script>

</head>

<form name="formulario" method="post" action="RegistrarWiki" >
<table width="360" border="0">
  <tr bgcolor="#0099FF">
    <td colspan="2">Creacion de Cuenta de WIKI </td>
    </tr>
	 <tr>
    <td bgcolor="#CCCCCC">Tipo cuenta  : </td>
    <td><p>
          <input name="rbn_tipo" type="radio" value="Administrador">
      Administrador
        <input name="rbn_tipo" type="radio" value="Usuario">
        Usuario</p>      </td>
  </tr>
  <tr>
    <td width="119" bgcolor="#CCCCCC">Nombres : </td>
    <td width="225"><input type="text" name="txt_nombres"></td>
  </tr>
  <tr>
    <td bgcolor="#CCCCCC">Apellido Paterno:</td>
    <td><input type="text" name="txt_apepat"></td>
  </tr>
 
 <tr>
    <td bgcolor="#CCCCCC">Apellido Materno:</td>
    <td><input type="text" name="txt_apemat"></td>
  </tr>
  <tr>
    <td bgcolor="#CCCCCC">Correo : </td>
    <td><input type="text"  name="txt_correo" id="txt_correo">
    
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td > </td>
    <td><input type="button" name="boton" value="Validar Correo" onClick="javascript:validaremail(this.form);"></td>
  </tr>
  <tr>
    <td bgcolor="#CCCCCC">Contrasena : </td>
    <td><input name="txt_contra" type="password" value=""></td>
  </tr>
  <tr>
    <td bgcolor="#CCCCCC">Fecha Nac : </td>
    <td><input type="text" name="txt_fecha">    </td>
  </tr> 
  <tr>
    <td bgcolor="#CCCCCC">Titulo Blog : </td>
    <td><input type="text" name="txt_titulo">    </td>
  </tr> 
  <tr>
    <td bgcolor="#CCCCCC">Direccion Blog : </td>
    <td><input type="text" name="txt_direccion">    </td>
  </tr>  
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" value="Registrar"></td>
  </tr>
</table>
</form>

</body>
</html>
<script language="javascript"> 
function validaremail(formulario) { 
if (document.formulario.txt_correo.value.indexOf('@') == -1) {
alert ("La \"Dirección de Email\" no es correcta"); 
document.formulario.txt_correo.focus() ;
}else { 
	alert (" La Dirección de Email  es correcta "); 
} 
} 
</script>