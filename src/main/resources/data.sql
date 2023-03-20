INSERT INTO aviones(id, modelo, capacidad_pasajeros) VALUES (1, '747', 400);
INSERT INTO aviones(id, modelo, capacidad_pasajeros) VALUES (2, 'A320', 220);
INSERT INTO aviones(id, modelo, capacidad_pasajeros) VALUES (3, '777', 305);
INSERT INTO aviones(id, modelo, capacidad_pasajeros) VALUES (4, '737', 168);

INSERT INTO vuelos (id, despegado, fecha_despegue, ultima_modificacion, avion_id) 
VALUES (999, true, '2023-03-17 13:36:37.482254', NOW(), 1);
INSERT INTO vuelos (id, despegado, fecha_despegue, ultima_modificacion, avion_id) 
VALUES (998, false, '2023-03-17 20:36:37.482254', NOW(), 2);
INSERT INTO vuelos (id, despegado, fecha_despegue, ultima_modificacion, avion_id) 
VALUES (997, false, '2023-03-17 21:36:37.482254', NOW(), 3);
INSERT INTO vuelos (id, despegado, fecha_despegue, ultima_modificacion, avion_id) 
VALUES (996, false, '2023-03-17 22:36:37.482254', NOW(), 4);

INSERT INTO aerolinea(id, nombre, suma_aviones) VALUES (1, 'Lemonair', SELECT COUNT(DISTINCT(id)) FROM aviones);