-- Crear la tabla Tipo_instrumento
CREATE TABLE Tipo_instrumento (
    Id SERIAL PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Descripcion TEXT NOT NULL
);

-- Crear la tabla Instrumento_musical
CREATE TABLE Instrumento_musical (
    Id SERIAL PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Descripcion TEXT,
    Material VARCHAR(255),
    Marca VARCHAR(255),
    Precio DOUBLE PRECISION NOT NULL,
    Descuento DOUBLE PRECISION,
    IdTipo_instrumento INT NOT NULL,
    FOREIGN KEY (IdTipo_instrumento) REFERENCES Tipo_instrumento(Id)
);


INSERT INTO Tipo_instrumento (Nombre, Descripcion) VALUES
('Cuerda', 'Instrumentos que producen sonido mediante la vibración de cuerdas.'),
('Viento', 'Instrumentos que producen sonido por la vibración de una columna de aire.'),
('Percusión', 'Instrumentos que producen sonido al ser golpeados o sacudidos.'),
('Teclado', 'Instrumentos que producen sonido al presionar teclas que activan mecanismos internos.');


INSERT INTO Instrumento_musical (Nombre, Descripcion, Material, Marca, Precio, Descuento, IdTipo_instrumento) VALUES
('Guitarra Clásica', 'Guitarra de cuerdas de nylon.', 'Madera', 'Yamaha', 250.00, 10.00, 1),
('Violín', 'Violín acústico de 4 cuerdas.', 'Madera', 'Stentor', 300.00, 15.00, 1),
('Flauta Traversa', 'Flauta de concierto plateada.', 'Metal', 'Yamaha', 400.00, 20.00, 2),
('Trompeta', 'Trompeta en Si bemol.', 'Latón', 'Bach', 500.00, 10.0, 2),
('Batería Acústica', 'Batería de 5 piezas.', 'Metal y Plástico', 'Pearl', 800.00, 50.00, 3),
('Caja Percusión', 'Caja orquestal de 14 pulgadas.', 'Metal', 'Ludwig', 150.00, 5.00, 3),
('Piano Digital', 'Piano de 88 teclas contrapesadas.', 'Madera y Plástico', 'Roland', 1200.00, 100.00, 4),
('Teclado Electrónico', 'Teclado portátil de 61 teclas.', 'Plástico', 'Casio', 300.00, 20.0, 4),
('Saxofón Alto', 'Saxofón en Mi bemol.', 'Latón', 'Selmer', 900.00, 75.00, 2),
('Contrabajo', 'Contrabajo acústico de 4 cuerdas.', 'Madera', 'Thomann', 1500.00, 200.00, 1);
