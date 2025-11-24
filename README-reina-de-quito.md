Explicacion del ultimo ejercicio (los demás ya fueron hechos en anteriores trabajos por eso no los incluí en la tarea)
Clase abstracta Candidata Define los atributos comunes (id, nombre, edad, distrito, puntaje) y el método abstracto mostrarDetalles(). → Esto asegura herencia y polimorfismo.

Clases hijas CandidataEstudiante y CandidataProfesional Extienden de Candidata, añaden atributos propios (universidad/carrera o profesión/años experiencia)
y sobrescriben mostrarDetalles(). → Aquí aplicas polimorfismo mostrando información distinta según el tipo.

Excepción personalizada DatoInvalidoException Se lanza cuando los datos ingresados son incorrectos (edad negativa, nombre vacío, puntaje fuera de rango). → Esto asegura validaciones y control de errores.

Clase Voto Registra un voto con idVoto, idCandidata y la fecha/hora (LocalDateTime.now()). → Permite llevar el conteo de votos.

Clase Concurso

Tiene listas (ArrayList) para candidatas y votos.

Métodos para registrar candidatas, votar, contar votos y obtener ganadoras.

Usa HashMap para contar votos por candidata. → Aquí integras todo el sistema y aplicas colecciones dinámicas.

Clase Main Implementa un menú en consola para interactuar: registrar, listar, buscar, filtrar, votar y mostrar resultados. → Es la interfaz principal del usuario.

El codigo fue orientado a objetos con herencia y polimorfismo para gestionar candidatas, valida datos con excepciones personalizadas, 
guarda la 
información en listas dinámicas (ArrayList y HashMap), y permite registrar, votar y obtener ganadoras mediante un menú 
interactivo en consola.

Evidencias de ejecucion
<img width="967" height="895" alt="image" src="https://github.com/user-attachments/assets/83224ee2-5e33-4364-81a2-0b406204eb45" />
<img width="968" height="863" alt="image" src="https://github.com/user-attachments/assets/46b5049d-a081-4eef-b9c3-0f3aa954639c" />



