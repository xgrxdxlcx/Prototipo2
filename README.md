# 📱 Prototipo 2 – Programación Android

App simple en **Java** que implementa **8 intents**: 5 implícitos y 3 explícitos, con validaciones. 🚀

## ⚙️ Versión
- `compileSdk 36`, `minSdk 31`, `targetSdk 36`
- AGP 9.0.1, Java 11


## 🌐 Intents implícitos (abren otras apps)
| # | Intent | Pasos de prueba |
|---|--------|-----------------|
| 1 | 🗺️ `geo:` → Google Maps | Escribir un lugar → *Abrir en Maps* |
| 2 | 🌍 `ACTION_VIEW` + `https://` | Escribir `santotomas.cl` → *Abrir página web* |
| 3 | 📞 `ACTION_DIAL` + `tel:` | Escribir un teléfono → *Marcar teléfono* |
| 4 | ✉️ `ACTION_SENDTO` + `mailto:` | Escribir un correo → asunto y cuerpo vienen prellenados |
| 5 | 📶 `ACTION_WIFI_SETTINGS` | Tocar *Ajustes Wi-Fi* |

## 🔀 Intents explícitos (dentro de la app)
| # | Intent | Pasos de prueba |
|---|--------|-----------------|
| 1 | `MainActivity → DetalleActivity` (`putExtra`) | Escribir un nombre → *Ver detalle* |
| 2 | `MainActivity → ConfigActivity` | Tocar *Ajustes* → *Volver* |
| 3 | `MainActivity → ConfirmActivity` (`registerForActivityResult`) | *Confirmar* → Sí/No → aparece un Toast con el resultado |


## 📸 Capturas
_(agregar mínimo 4 capturas en la carpeta `capturas/01_principal.png`)_

## 🛠️ Compilar
```
./gradlew assembleDebug
```
APK en `app/build/generate app bundles or apks/generate apks`
