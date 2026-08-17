# 🏆 SportsHub

SportsHub es una aplicación Android moderna desarrollada en Kotlin que permite gestionar y seguir ligas deportivas, equipos, jugadores y partidos. Construida con los últimos estándares de desarrollo de Android y Jetpack Compose, ofrece una experiencia de usuario fluida y una arquitectura robusta.

## 🚀 Características Principales

*   **Autenticación y Usuarios**: Registro e inicio de sesión seguro utilizando Firebase Authentication.
*   **Gestión Deportiva**: Visualización detallada de ligas, equipos, jugadores, partidos y clasificaciones.
*   **Multimedia**: Reproductor integrado de vídeo y audio usando Media3 (ExoPlayer).
*   **Mapas**: Integración con Google Maps para localización (ej. estadios o sedes).
*   **Notificaciones Push**: Alertas en tiempo real mediante Firebase Cloud Messaging (FCM).
*   **Modo Offline**: Almacenamiento local de datos clave con Room Database.
*   **Animaciones**: Interfaz dinámica y atractiva con Lottie Compose y carga de imágenes con Coil.

## 🛠️ Tecnologías y Arquitectura

El proyecto sigue las directrices de la arquitectura recomendada por Google (MVVM) e implementa las siguientes tecnologías y librerías:

*   **UI**: [Jetpack Compose](https://developer.android.com/jetpack/compose) - Toolkit declarativo moderno para crear la interfaz gráfica.
*   **Lenguaje**: [Kotlin](https://kotlinlang.org/)
*   **Inyección de Dependencias**: [Hilt / Dagger](https://dagger.dev/hilt/)
*   **Red y API**: [Retrofit](https://square.github.io/retrofit/) & OkHttp para el consumo asíncrono de APIs REST.
*   **Base de Datos Local**: [Room](https://developer.android.com/training/data-storage/room)
*   **Backend as a Service (BaaS)**: [Firebase](https://firebase.google.com/) (Auth, Messaging).
*   **Multimedia**: [Media3 (ExoPlayer)](https://developer.android.com/media/media3) para reproducción de audio y vídeo.
*   **Imágenes**: [Coil](https://coil-kt.github.io/coil/) para la carga eficiente de imágenes remotas.
*   **Mapas**: Google Maps Compose.
*   **Animaciones**: Lottie Compose.

## 📁 Estructura del Proyecto

El código fuente está organizado de forma limpia (Clean Architecture) bajo el paquete `com.ieschabas.sportshub`:

*   `ui/`: Contiene todos los componentes de Jetpack Compose, las distintas pantallas de la app (`screens`), la navegación y la configuración visual (`theme`).
*   `data/`: Capa de datos, repositorios, DAOs de Room y modelos para peticiones de red.
*   `domain/`: Reglas de negocio, casos de uso y modelos de dominio.
*   `di/`: Módulos de inyección de dependencias configurados con Hilt.

## ⚙️ Requisitos Previos

Para compilar y ejecutar este proyecto en tu entorno local, necesitarás:

*   [Android Studio](https://developer.android.com/studio) (versión Ladybug o superior recomendada).
*   JDK 11 o superior.
*   SDK de Android con API mínima 24 (Android 7.0) y Target API 36.
*   **Configuración de Firebase**: Deberás tener tu propio archivo `google-services.json` configurado en la carpeta `app/` para que los servicios de Firebase (Autenticación y Notificaciones) funcionen correctamente.

## 🏃‍♂️ Instalación y Ejecución

1.  Clona este repositorio:
    ```bash
    git clone https://github.com/tu-usuario/sportshub.git
    ```
2.  Abre la carpeta del proyecto en Android Studio.
3.  Espera a que finalice la sincronización de los archivos de Gradle (`Sync Project with Gradle Files`).
4.  Asegúrate de colocar tu archivo `google-services.json` en el directorio `app/`.
5.  Ejecuta la app en un emulador o en tu dispositivo físico haciendo clic en el botón **Run** (o pulsando `Shift + F10`).

## 📝 Licencia

Este proyecto fue desarrollado con fines educativos (IES Chabás - Desarrollo de Aplicaciones Multiplataforma / Programación Multimedia).
