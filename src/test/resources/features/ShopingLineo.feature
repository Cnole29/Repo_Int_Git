#language: es
@EndToEnd
Característica: ShopingLineo
  Yo, como usuario
  Quiero, iniciar sesión
  Para poder agregar productos al carrito

  @test
  Escenario: Shoping Lineo
    Dado que me encuentro en la página de login de Lineo
    Cuando inicio sesión con las credenciales Email: "carlos.nole1994@gmail.com" y contraseña: "Everyday2021"
    Entonces valido la autenticacion correcta "Carlos Aaron"
    Cuando selecciona la categoria mejores calificados
    Y da click en el primer producto
    Entonces se visualiza el detalle del producto con nombre "Audífono Bluetooth F9 PRO 3000 mAh"
    Cuando se selecciona el boton añadir carrito
    Entonces se visualiza el mensaje "Tu producto se agrego al carrito"

