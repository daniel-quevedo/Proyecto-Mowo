<div class="line-top sticky-top">    
    <img src="../../img/menu.png" alt="" class="menu-bar">        
    <div class="btn-group his">
        <a data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><%=session.getAttribute("nameUser")%> <img src="../../img/avatar.jpg"></a>
        <div class="dropdown-menu  dropdown-menu-right">
            <a class="dropdown-item" href="perfil.jsp">Perfil</a>
            <a class="dropdown-item" href="../../LoginSERVLET?logout=1">Cerrar Sesión</a>						
        </div>
    </div>
</div>   
