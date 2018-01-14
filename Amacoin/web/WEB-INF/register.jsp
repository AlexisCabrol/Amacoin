<%-- 
    Document   : register
    Created on : 20 déc. 2017, 15:04:26
    Author     : Alexis
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
    <body>
       <div class="center-align">
      <div class="container">
          <div class="section"></div>
          <div class="section">
          <div class="register">
              <h5> Inscription à Amacoin</h5>
          </div>
          </div>
          
        <div class="z-depth-1 grey lighten-4 row" style="display: block; padding: 32px 48px 20px 48px; border: 1px solid #EEE;">
            <form method="post" action="register">
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">face</i>
                        <input id="email" type="email" class="validate" name="email" >
                        <label for="email">Adresse mail <span class="requis">*</span></label>
                        
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">enhanced_encryption</i>
                        <input name="pwd" id="pwd" type="password" class="validate">
                        <label for="pwd">Mot de passe <span class="requis">*</span></label>
                        
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <i class="material-icons prefix">enhanced_encryption</i>
                        <input  name="confirmation" id="confirmation" type="password" class="validate">
                        <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                        
                    </div>
                </div>
                 <button class="btn waves-effect waves-light cyan" type="submit" name="action">S'inscrire !
                    <i class="material-icons right">send</i>
                </button>
                    
                        <p class="${empty erreurs ? 'succes' : 'erreur'}"${resultat}</p>
            </form>
        </div>
      </div>
      </div>
    </body>
</html>
<jsp:include page="footer.jsp" />
