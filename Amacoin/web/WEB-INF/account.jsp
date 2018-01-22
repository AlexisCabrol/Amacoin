<%-- 
    Document   : litecoin
    Created on : 12 janv. 2018, 09:52:13
    Author     : Alexis
--%>

<%@page import="beans.Bitcoin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<c:set var ="wallet_btc" value=""/>
<!DOCTYPE html>
<html>
    <body>
        <div class="container">
            <h3>Le court général de nos Crypto-monnaies</h3>
            <div class="row">
                <div class="col s6">
                                                <script type="text/javascript" src="https://files.coinmarketcap.com/static/widget/currency.js"></script><div class="coinmarketcap-currency-widget" data-currency="ethereum" data-base="EUR" data-secondary="" data-ticker="true" data-rank="false" data-marketcap="true" data-volume="true" data-stats="EUR" data-statsticker="false"></div>

                </div>
                <div class="col s6">
                    <script type="text/javascript" src="https://files.coinmarketcap.com/static/widget/currency.js"></script><div class="coinmarketcap-currency-widget" data-currency="bitcoin" data-base="EUR" data-secondary="" data-ticker="true" data-rank="false" data-marketcap="true" data-volume="true" data-stats="EUR" data-statsticker="false"></div>
                </div>

                <div class="col s6">
                                        <script type="text/javascript" src="https://files.coinmarketcap.com/static/widget/currency.js"></script><div class="coinmarketcap-currency-widget" data-currency="ripple" data-base="EUR" data-secondary="" data-ticker="true" data-rank="false" data-marketcap="true" data-volume="true" data-stats="EUR" data-statsticker="false"></div>

                </div>
                <div class="col s6">
                                               <script type="text/javascript" src="https://files.coinmarketcap.com/static/widget/currency.js"></script><div class="coinmarketcap-currency-widget" data-currency="litecoin" data-base="EUR" data-secondary="" data-ticker="true" data-rank="false" data-marketcap="true" data-volume="true" data-stats="EUR" data-statsticker="false"></div> 

                </div>
            </div>
            <div class="section">
            </div>
            
            <h3>Vos wallets de crypto</h3>
            


      <table class="striped">
        <thead>
          <tr>
              <th>Crypto</th>
              <th>Montant</th>
              <th>Wallet adresse</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>Bitcoin (BTC)</td>
            <td>${ wallet_btc.nombre * wallet_btc.unit}€</td>
            <td>${ wallet_btc.wallets }
           </td>
          </tr>
          <tr>
            <td>Ripple (XPR)</td>
            <td>${wallet_xrp.nombre * wallet_xrp.unit}€</td>
            <td>${wallet_xrp.wallets}</td>
          </tr>
          <tr>
            <td>Ethereum (ETH)</td>
            <td>${wallet_eth.nombre * wallet_eth.unit}€</td>
            <td>${wallet_eth.wallets}</td>
          </tr>
           <tr>
            <td>Litecoin (LTC)</td>
            <td>${wallet_ltc.nombre * wallet_ltc.unit}€</td>
            <td>${wallet_ltc.wallets}</td>
          </tr>
        </tbody>
      </table>
            <div class="section">
            </div>
            


            
            </div>
    </body>
</html>
<jsp:include page="footer.jsp" />
