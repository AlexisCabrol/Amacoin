<%-- 
    Document   : ethereum
    Created on : 12 janv. 2018, 09:52:26
    Author     : Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
    <body>
        <div class="container">
            <div class="section"></div>
            <div class="row">
                <div class="col s6">
                            <script type="text/javascript" src="https://files.coinmarketcap.com/static/widget/currency.js"></script><div class="coinmarketcap-currency-widget" data-currency="ethereum" data-base="EUR" data-secondary="" data-ticker="true" data-rank="false" data-marketcap="true" data-volume="true" data-stats="EUR" data-statsticker="false"></div>
                </div>
            </div>
        
              <div class="row">
                <% if(session.getAttribute("log") == null || ((Boolean) session.getAttribute("log") == false )) { %>
                        Pour ajouter des articles à votre panier il faut être identifer.
                  <% } else {
                            if((Boolean) request.getAttribute("insert") == null) { %>
                            L'ajout dans le panier ne c'est pas bien dérouler.
                            <% } else { %>
                            L'ajout dans le panier c'est bien dérouler.
                            <% } %>
                            <div class="row">
    <form class="col s12" action="ethereum" method="post">
      <div class="row">
        <div class="input-field col s6">
          <input id="nombre" name="nombre" type="text" class="validate">
          <label for="nombre">Nombre d'item</label>
        </div>
      </div>
          <div class="row">
               <div class="col s12">
  <button class="btn waves-effect waves-light light-blue accent-2" type="submit" name="action">Envoyer vers le panier !
    <i class="material-icons right">send</i>
  </button>
               
      </div
          </div>
    </form>
  
        
        </div>
        </div>
                            <% } %>
        </div>
    </div>
    
    </body>
</html>
<jsp:include page="footer.jsp" />
