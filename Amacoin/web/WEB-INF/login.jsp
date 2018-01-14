<%-- 
    Document   : login
    Created on : 21 déc. 2017, 09:02:40
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
    <body>
       <div class="center-align">
      <div class="container">
          <div class="section"></div>
          <div class="section">
          <div class="register">
              <h5>S'identifier sur Amacoin</h5>
          </div>
          </div>
          
          
        <div class="z-depth-1 grey lighten-4 row" style="display: block; padding: 32px 48px 20px 48px; border: 1px solid #EEE;">
            <form method="post" action="login">
                    <div class="input-field">
                        <i class="material-icons prefix">face</i>
                        <input name="email" id="email" type="text" class="validate">
                        <label for="email">Adresse mail</label>
                    </div>
                
                
                    <div class="input-field">
                        <i class="material-icons prefix">enhanced_encryption</i>
                        <input name="pwd" id="pwd" type="password" class="validate">
                        <label for="pwd">Mot de passe</label>
                    </div>
               
                
                 <button class="btn waves-effect waves-light cyan" type="submit" name="action">S'identifier
                    <i class="material-icons right">send</i>
                </button>
            </form>
        </div>
      </div>
       </div>
    </body>
</html>
<jsp:include page="footer.jsp" />
