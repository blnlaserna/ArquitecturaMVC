# ArquitecturaMVC
En esta práctica abordaremos el patrón  Modelo Vista Controlador MVC.
Como introducción, podemos hablar de los patrones de software como soluciones reulizables
en el diseño de una aplicación. En nuestro caso la utilización del patrón MVC proporciona
una arquitectura uniforme qu permite una fácil expansión, mantenimiento y  modificación de
una aplicación.
El principal objetivo de la arquitectura MVC es aislar tanto los datos de la aplicación como
el estado (modelo) de la misma, del mecanismo utilizado para representar (vista) dicho estado,
así como para modularizar esta vista y  modelar la transición entre estados del modelo
(controlador)

Las aplicaciones MVC se dividen en tres grandes áreas funcionales:
- Vista: Presentación de los datos
- Controlador: Atenderá las peticiones y toma de decisiones de la aplicación.
- Modelo: La lógica del negocio y los datos asociados con la aplicación.

El propósito del MVC es aislar los cambios. Es una arquitectura preparada para los cambios, que
desacopla los datos y la lógica de negocio de la lógica de presentación, permitiendo la
actualización y desarrollo independiente de cada uno de los citados componentes.

Las aplicaciones MVC pueden ser implementadas con J2EE utilizando JSP para las vistas, servlets
como controladores y JavaBeans para el modelo, siendo JavaBeans componenetes de código 
reutilizables en cualquier aplicación.

Observad en la práctica que elementos se corresponden con cada uno de los componenentes del 
patrón:
- Vista: La página order.jsp se encarga de mostrar la página de compras mientra que la página
checkout.jsp se encargará de mostrar el resumen de compra.
- Controlador: El servlet ServletControlador se encarga de atender las peticiones y dirigir la
aplicación.
- Modelo: La lógica de negocio está representada por la clase ElementoPedido.java que representa
un elemento del pedido y LibrosBD.java que se encarga de la comunicación con la base de datos.