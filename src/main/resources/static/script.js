$(document).ready(function() {

    var shoppingCart = 0;
    $(".addToCartBtn").click(
      addToCart() );

    function addToCart() {
      shoppingCart++;
      console.log(shoppingCart);
      console.log("added to cart");
    }

    $( ".addToCartBtn" ).click(function() {
      alert( "Handler for .click() called." );
      addToCart();
    });

});
