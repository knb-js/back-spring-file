# Ejercicio de Desarrollo JAVA: División y Envío de Archivos

## Requerimiento Funcional

El cliente necesita una herramienta que le permita dividir archivos en segmentos de tamaños configurables y enviarlos por correo. Los pasos para realizar esta operación son los siguientes:

1. El cliente debe poder cargar un archivo (puede ser desde el disco o arrastrado).
2. El cliente debe indicar el tamaño de cada segmento en bytes.
3. Al apretar el botón "Procesar", el archivo se carga al servidor y se divide en tantos segmentos como sea necesario, según el tamaño indicado.
4. Durante el proceso de división, la página debe mostrar un mensaje de estado, como "Procesando Archivo".
5. Una vez terminado el proceso, los segmentos generados deben mostrarse en pantalla en orden y numerados desde el 0 en adelante.
6. El cliente podrá descargar cada segmento haciendo clic sobre él.
7. El cliente podrá enviar los segmentos por correo electrónico.

## Requerimientos Tecnológicos

El sistema debe cumplir con los siguientes requerimientos tecnológicos:

- **Lenguaje de desarrollo:** Java
- **Sin base de datos:** El sistema no utilizará ninguna base de datos.
- **Soporte de tipos de archivo:** El sistema debe permitir cargar y procesar archivos de cualquier tipo (por ejemplo, `.png`, `.gif`, `.pdf`, `.zip`, etc.).

## Validación del Resultado

Para validar la correcta operación del sistema, los segmentos generados deben ser "pegados" para regenerar el archivo original. La validación puede realizarse utilizando el sistema operativo de la siguiente manera:

### En Windows:
```bash
copy /b Form.0.pdf + Form.1.pdf + Form.2.pdf Form.pdf
