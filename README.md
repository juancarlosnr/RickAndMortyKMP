# Rick and Morty KMP App

[![Kotlin](https://img.shields.io/badge/Kotlin-2.2.0-blue?logo=kotlin)](https://kotlinlang.org/)
[![Ktor](https://img.shields.io/badge/Ktor-HTTP%20Client-green)](https://ktor.io/)
[![Room](https://img.shields.io/badge/Room-Database-orange)](https://developer.android.com/training/data-storage/room)
[![Paging3](https://img.shields.io/badge/Paging-3-yellow)](https://developer.android.com/topic/libraries/architecture/paging/v3-overview)
[![Koin](https://img.shields.io/badge/Koin-DI-lightgrey)](https://insert-koin.io/)
[![KMP](https://img.shields.io/badge/KMP-Multiplatform-purple)](https://kotlinlang.org/docs/multiplatform.html)

Una aplicación **Kotlin Multiplatform (KMP)** basada en la API de [Rick and Morty](https://rickandmortyapi.com/), desarrollada con arquitectura moderna y librerías multiplataforma.  

El objetivo es demostrar cómo estructurar un proyecto **KMP** utilizando:  
- **Ktor** para consumo de API  
- **Room** para persistencia local  
- **Paging 3** para paginación de datos  
- **Koin** para inyección de dependencias  

---

## 🚀 Tecnologías y librerías

- **Kotlin Multiplatform** (Android + iOS)  
- **Ktor** – cliente HTTP multiplataforma  
- **Room** – base de datos local (Android)  
- **Paging 3** – soporte de listas paginadas  
- **Koin** – inyección de dependencias ligera  
- **Coroutines + Flow** – programación reactiva asíncrona  

---

## 📂 Estructura del proyecto

```
rick-and-morty-kmp/
│── androidApp/           # Módulo Android
│── iosApp/               # Módulo iOS
│── shared/               # Módulo compartido KMP
│   ├── data/             # Repositorios, fuentes de datos
│   ├── network/          # Ktor API service
│   ├── db/               # Room database y DAO
│   ├── di/               # Definiciones de Koin
│   ├── model/            # Modelos de dominio
│   ├── paging/           # Lógica de paginación con Paging3
│   └── util/             # Utilidades
```

---

## ⚙️ Configuración

### 1. Clonar el repositorio
```bash
git clone https://github.com/tuusuario/rick-and-morty-kmp.git
```

### 2. Abrir en Android Studio
- Recomendado: **Android Studio Ladybug o superior** (con soporte KMP)  
- Instalar el plugin **Kotlin Multiplatform Mobile**

### 3. Sincronizar dependencias
Gradle descargará automáticamente las dependencias al abrir el proyecto.

---

## 🔌 API usada
La app consume datos de personajes, episodios y ubicaciones de:  
👉 [https://rickandmortyapi.com/](https://rickandmortyapi.com/)

Ejemplo de endpoint:
```
https://rickandmortyapi.com/api/character
```

---

## 📸 Capturas

*(Agrega capturas de la app en Android/iOS aquí)*

---

## 🧩 Roadmap

- [x] Configuración de proyecto KMP  
- [x] Consumo de API con Ktor  
- [x] Cache local con Room  
- [x] Paginación con Paging3  
- [x] Inyección con Koin  
- [ ] UI en Compose Multiplatform  
- [ ] Tests unitarios y de integración  

---