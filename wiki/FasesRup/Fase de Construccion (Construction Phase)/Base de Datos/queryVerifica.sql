SELECT * FROM banco.usuarios;


SELECT id_usuario FROM banco.usuarios
WHERE nombre_user = 'Rolando' AND contrasena = 'Rolas01';

SELECT * FROM banco.usuario_depto
WHERE  id_user='2' AND id_depto ='1';

SELECT * FROM banco.usuarios
WHERE admin = 1 AND nombre_user = 'Rolando' AND contrasena = 'Rolas01';