# ArquitecturaMVC
En esta pr�ctica abordaremos el patr�n  Modelo Vista Controlador MVC.
Como introducci�n, podemos hablar de los patrones de software como soluciones reulizables
en el dise�o de una aplicaci�n. En nuestro caso la utilizaci�n del patr�n MVC proporciona
una arquitectura uniforme qu permite una f�cil expansi�n, mantenimiento y  modificaci�n de
una aplicaci�n.
El principal objetivo de la arquitectura MVC es aislar tanto los datos de la aplicaci�n como
el estado (modelo) de la misma, del mecanismo utilizado para representar (vista) dicho estado,
as� como para modularizar esta vista y  modelar la transici�n entre estados del modelo
(controlador)

Las aplicaciones MVC se dividen en tres grandes �reas funcionales:
- Vista: Presentaci�n de los datos
- Controlador: Atender� las peticiones y toma de decisiones de la aplicaci�n.
- Modelo: La l�gica del negocio y los datos asociados con la aplicaci�n.

El prop�sito del MVC es aislar los cambios. Es una arquitectura preparada para los cambios, que
desacopla los datos y la l�gica de negocio de la l�gica de presentaci�n, permitiendo la
actualizaci�n y desarrollo independiente de cada uno de los citados componentes.

Las aplicaciones MVC pueden ser implementadas con J2EE utilizando JSP para las vistas, servlets
como controladores y JavaBeans para el modelo, siendo JavaBeans componenetes de c�digo 
reutilizables en cualquier aplicaci�n.

Observad en la pr�ctica que elementos se corresponden con cada uno de los componenentes del 
patr�n:
- Vista: La p�gina order.jsp se encarga de mostrar la p�gina de compras mientra que la p�gina
checkout.jsp se encargar� de mostrar el resumen de compra.
- Controlador: El servlet ServletControlador se encarga de atender las peticiones y dirigir la
aplicaci�n.
- Modelo: La l�gica de negocio est� representada por la clase ElementoPedido.java que representa
un elemento del pedido y LibrosBD.java que se encarga de la comunicaci�n con la base de datos.