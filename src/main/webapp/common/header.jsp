<%@page import="beans.Signup" %>
<%@page import="java.util.*" %>

<%@page import="common.DataBaseConnect" %>



<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="Index.jsp">GriH KiranA</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="Index.jsp">Home</a>
      </li>
				      <!-- 
				      					PhoductCategory
				       -->
      <li class="nav-item">
        <a class="nav-link" href="#">About</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Contact</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="emailvalidate">SignUp</a>
      </li>
      <li class="nav-item dropdown">
      <%
      		if(session.getAttribute("signup")!=null){
      			Signup sb=(Signup) session.getAttribute("signup");
      %>
      	 <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
      	 <%= sb.getName() %>
      	 <span class="caret"></span>
        
      </a>
      <div class="dropdown-menu">
     
      <%			
      			if(sb.getUserrole().equals("admin")){
      %>
      		<a class="dropdown-item" href="admin/index.jsp">Dashboard</a>
      		<a class="dropdown-item" href="logout">Logout</a>
      <%
      			}else if(sb.getUserrole().equals("user")){
      %>
      		<a class="dropdown-item" class="dropdown-item" href="user/index.jsp">Dashboard</a>
      		<a class="dropdown-item" href="logout">Logout</a>
      	 </div>
      <%				
      			}
      		}else{
     %>
        		<a class="nav-link" href="Signin">SignIn</a>
        	<%
        		}
     		%>
      </li>
    </ul>
  </div>
</nav>